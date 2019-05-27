package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.ImageBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseImageCellView;
import com.flyzebra.flyui.view.base.BaseViewFunc;
import com.flyzebra.flyui.view.customview.MirrorView;

public class SimpleImageCellView extends BaseImageCellView implements View.OnTouchListener, View.OnClickListener {
    private MirrorView mirrorView;
    private Handler mHandler = new Handler();
    private Bitmap mBitmap;

    public SimpleImageCellView(Context context) {
        super(context);
    }


    @Override
    public boolean verify(CellBean cellBean) {
        return !(cellBean == null ||
                cellBean.images == null ||
                cellBean.images.isEmpty());
    }

    @Override
    public void init(CellBean cellBean) {
        setScaleType(mCellBean.images.get(0).getScaleType());
        if (mCellBean.send != null) {
            setOnClickListener(this);
            setOnTouchListener(this);
        }
    }

    @Override
    public void refresh(CellBean cellBean) {
        String imageurl = UpdataVersion.getNativeFilePath(cellBean.images.get(0).url);
        Glide.with(getContext())
                .asBitmap()
                .load(imageurl)
                .override(cellBean.images.get(0).width, cellBean.images.get(0).height)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerInside()
                .into(new BitmapImageViewTarget(this) {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        if (mBitmap == null){
                            setImageBitmap(resource);
                        }
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

                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        super.onLoadFailed(errorDrawable);
                    }
                });
    }

    /**
     * 启动优先级，包名+类名>Action>包名
     */
    @Override
    public void onClick() {
        BaseViewFunc.onClick(getContext(),mCellBean.send);
    }

    @Override
    public void bindMirrorView(ViewGroup viewGroup, ViewGroup.LayoutParams lpMirror) {
        MirrorView mirrorView = new MirrorView(getContext());
        mirrorView.setScaleType(ImageView.ScaleType.FIT_XY);
        mirrorView.setRefHeight(MirrorView.MIRRORHIGHT);
        viewGroup.addView(mirrorView, lpMirror);
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
            try {
                setColorFilter(Color.parseColor(mCellBean.filterColor));
            } catch (Exception e) {
                setColorFilter(0x3FFFFFFF);
            }
            mHandler.removeCallbacks(show);
            mHandler.postDelayed(show, 300);
        } else {
            clearColorFilter();
        }
    }

    @Override
    public void onClick(View v) {
        onClick();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mCellBean == null || mCellBean.images.isEmpty()) return;
        ImageBean imageBean = mCellBean.images.get(0);
        if (imageBean == null || imageBean.recv == null || imageBean.recv.recvId == null) return ;
        recvEvent(ByteUtil.hexString2Bytes(imageBean.recv.recvId));
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

    @Override
    public boolean recvEvent(byte[] key) {
        if (mCellBean == null || mCellBean.images.isEmpty()) return false;
        ImageBean imageBean = mCellBean.images.get(0);
        if (imageBean == null || imageBean.recv == null || imageBean.recv.recvId == null) {
            return false;
        }
        if (!imageBean.recv.recvId.equals(ByteUtil.bytes2HexString(key))) {
            return false;
        }
        switch (imageBean.recv.recvId) {
            case "100201":
                break;
            case "100227":
                final byte[] imageBytes = (byte[]) FlyEvent.getValue(imageBean.recv.recvId);
                FlyLog.d("handle 100227 imageBytes=" + imageBytes);
                if (imageBytes == null) {
                    mBitmap = null;
                    refresh(mCellBean);
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                            } catch (Exception e) {
                                FlyLog.e(e.toString());
                                return;
                            }
                            if (mBitmap == null) return;
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (mBitmap != null) {
                                        setImageBitmap(mBitmap);
                                    }
                                    FlyLog.d("handle 100227 finish; bitmap=" + mBitmap);
                                }
                            });
                        }
                    }).start();
                }
                break;

        }
        return false;
    }
}
