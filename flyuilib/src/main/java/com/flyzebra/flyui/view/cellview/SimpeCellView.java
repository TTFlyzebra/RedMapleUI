package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.IntentUtils;
import com.flyzebra.flyui.view.customview.FlyImageView;
import com.flyzebra.flyui.view.customview.FlyTextView;
import com.flyzebra.flyui.view.customview.MirrorView;

public class SimpeCellView extends FrameLayout implements ICell, View.OnTouchListener, View.OnClickListener {
    private CellBean mCellBean;
    private FlyImageView imageView;
    private MirrorView mirrorView;
    private TextView textView;
    private Handler mHandler = new Handler();

    public SimpeCellView(Context context) {
        super(context);
        initView(context);
        focusChange(false);
    }

    @Override
    public void initView(Context context) {
        imageView = new FlyImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        addView(imageView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        textView = new FlyTextView(context);
        addView(textView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void upData(CellBean cellBean) {
        FlyLog.v(cellBean.toString());
        this.mCellBean = cellBean;
        if (cellBean.width > 0 || cellBean.height > 0) {
            LayoutParams params = (LayoutParams) imageView.getLayoutParams();
            params.width = cellBean.width;
            params.height = cellBean.height;
            imageView.setLayoutParams(params);
        }

        if(cellBean.texts.get(0).bottom<0){
            LayoutParams params = (LayoutParams) getLayoutParams();
            params.height = params.height - cellBean.texts.get(0).bottom;
            setLayoutParams(params);
        }

        try {
            textView.setTextColor(Color.parseColor(cellBean.texts.get(0).textColor));
        } catch (Exception e) {
            textView.setTextColor(0xffffffff);
        }
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, cellBean.texts.get(0).textSize);
        LayoutParams params2 = (LayoutParams) textView.getLayoutParams();
        params2.gravity = Gravity.BOTTOM;
        params2.leftMargin = cellBean.texts.get(0).left;
        params2.topMargin = cellBean.texts.get(0).top;
        params2.rightMargin = cellBean.texts.get(0).right;
        params2.bottomMargin = Math.max(0, cellBean.texts.get(0).bottom);
        params2.height = (int) (cellBean.texts.get(0).textSize * 2.5f);
        textView.setLayoutParams(params2);
        textView.setGravity(mCellBean.getTextGravity());
        textView.setLines(2);
        setOnClickListener(this);
        setOnTouchListener(this);
        upView();
    }

    public void upView() {
        if (mCellBean == null) {
            FlyLog.e("error! beacuse cellBean is empey!");
            return;
        }
        if (textView != null && mCellBean.texts.get(0).text != null) {
            textView.setText(mCellBean.texts.get(0).text.getText());
        }
        if (imageView == null || TextUtils.isEmpty(mCellBean.images.get(0).url)) {
            try {
                setBackgroundColor(Color.parseColor(mCellBean.backColor));
            } catch (Exception e) {
                FlyLog.e("error! parseColor exception!" + e.toString());
            }
            return;
        }
        String imageurl = UpdataVersion.getNativeFilePath(mCellBean.images.get(0).url);
        FlyLog.v("glide image url=" + imageurl);
        Glide.with(getContext())
                .asBitmap()
                .load(imageurl)
                .override(mCellBean.width, mCellBean.height)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerInside()
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        imageView.setImageBitmap(resource);
                        if (mirrorView != null) {
                            setDrawingCacheEnabled(true);
                            Bitmap bmp = getDrawingCache();
                            if (bmp == null) {
                                measure(MeasureSpec.makeMeasureSpec(mCellBean.width, MeasureSpec.EXACTLY),
                                        MeasureSpec.makeMeasureSpec(mCellBean.height, MeasureSpec.EXACTLY));
                                layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
                                buildDrawingCache();
                                bmp = getDrawingCache();
                            }
                            mirrorView.showImage(bmp);
                        }
                    }
                });
    }

    /**
     * 启动优先级，包名+类名>Action>包名
     */
    @Override
    public void doEvent() {
        if(mCellBean.send==null){
            return;
        }
        if (IntentUtils.execStartPackage(getContext(), mCellBean.send.packName, mCellBean.send.className)) {
        } else if (!IntentUtils.execStartPackage(getContext(), mCellBean.send.packName)) {
        }
    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {
        this.mirrorView = mirrorView;
    }

    private Runnable show = new Runnable() {
        @Override
        public void run() {
            focusChange(false);
        }
    };

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                focusChange(true);
                break;
            case MotionEvent.ACTION_MOVE:
                focusChange(isTouchPointInView(v, (int) event.getRawX(), (int) event.getRawY()));
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                focusChange(false);
                break;
        }
        return false;
    }

    private void focusChange(boolean flag) {
        if (flag) {
            mHandler.removeCallbacks(show);
            mHandler.postDelayed(show, 300);
            imageView.setColorFilter(0x3FFFFFFF);
        } else {
            imageView.clearColorFilter();
        }
    }

    @Override
    public void onClick(View v) {
        doEvent();
    }

    @Override
    protected void onDetachedFromWindow() {
        mHandler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();
    }

    private boolean isTouchPointInView(View view, int x, int y) {
        if (view == null) {
            return false;
        }
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();
        if (y >= top && y <= bottom && x >= left && x <= right) {
            return true;
        }
        return false;
    }
}
