package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.FlyImageView;
import com.flyzebra.flyui.view.customview.MirrorView;

public class SimpleImageCellView extends FlyImageView implements ICell, View.OnTouchListener, View.OnClickListener {
    protected CellBean mCellBean;
    private MirrorView mirrorView;

    public SimpleImageCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
        focusChange(false);
        setScaleType(ScaleType.CENTER);
    }

    @Override
    public void setCellBean(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean.send != null) {
            setOnClickListener(this);
            setOnTouchListener(this);
        }
        refreshView(cellBean);
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return true;
    }

    @Override
    public void loadingRes(CellBean cellBean) {

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        focusChange(!enabled);
    }

    @Override
    public void refreshView(CellBean cellBean) {
        showImageUrl(mCellBean.images.get(0).url);
    }

    private void showImageUrl(String imageurl) {
        if (TextUtils.isEmpty(imageurl)) return;
        String url = UpdataVersion.getNativeFilePath(imageurl);
        Glide.with(getContext())
                .asBitmap()
                .load(url)
                .override(mCellBean.width, mCellBean.height)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new BitmapImageViewTarget(this) {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        setImageBitmap(resource);
                        if (mirrorView != null) {
                            mirrorView.showImage(resource);
                        }
                    }
                });
    }

    @Override
    public void onClick() {
        FlyLog.d("onClick event=" + mCellBean.send.eventId);
//        FlyAction.sendEvent(mCellBean.send.eventId);
    }

    @Override
    public void bindMirrorView(ViewGroup viewGroup, ViewGroup.LayoutParams lpMirror) {
        MirrorView mirrorView = new MirrorView(getContext());
        mirrorView.setScaleType(ImageView.ScaleType.FIT_XY);
        mirrorView.setRefHeight(MirrorView.MIRRORHIGHT);
        viewGroup.addView(mirrorView, lpMirror);
        this.mirrorView = mirrorView;
    }

    @Override
    public void onClick(View v) {
        setEnabled(false);
        onClick();
        setEnabled(true);
    }

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
            setColorFilter(ThemeBean.filterColor);
        } else {
            clearColorFilter();
        }
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

    private Handler mHandler = new Handler();
    private Runnable show = new Runnable() {
        @Override
        public void run() {
            focusChange(false);
        }
    };


    @Override
    protected void onAttachedToWindow() {
        FlyLog.d("onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyLog.d("onDetachedFromWindow");
        mHandler.removeCallbacksAndMessages(null);
        focusChange(false);
        super.onDetachedFromWindow();
    }

}
