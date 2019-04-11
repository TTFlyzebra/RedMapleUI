package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flyzebra.flyui.ActionKey;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.status.PlayStatus;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.FlyImageView;
import com.flyzebra.flyui.view.customview.MirrorView;

public class ImageCellView extends FlyImageView implements ICell, IAction, View.OnTouchListener, View.OnClickListener {
    protected CellBean mCellBean;
    private MirrorView mirrorView;

    public ImageCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
        focusChange(false);
        setScaleType(ScaleType.CENTER);
    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean.sendAction > 0) {
            setOnClickListener(this);
            setOnTouchListener(this);
        }

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        focusChange(!enabled);
    }

    @Override
    public void upView() {
        showImageUrl(mCellBean.imageurl1);
    }

    private void showImageUrl(String imageurl) {
        if (TextUtils.isEmpty(imageurl)) return;
        String url = UpdataVersion.getNativeFilePath(imageurl);
        Glide.with(getContext())
                .load(url)
                .asBitmap()
                .override(mCellBean.width, mCellBean.height)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(final Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                        setImageBitmap(bitmap);
                        if (mirrorView != null) {
                            setDrawingCacheEnabled(true);
                            Bitmap bmp = getDrawingCache();
                            mirrorView.showImage(bmp);
                        }
                    }
                });
    }

    @Override
    public void doEvent() {
        FlyLog.d("doEvent event=" + mCellBean.clickevent);
        if (mCellBean.sendAction > 0) {
            FlyAction.notifyAction(mCellBean.sendAction, null);
        }
    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {
        this.mirrorView = mirrorView;
    }

    @Override
    public void onClick(View v) {
        setEnabled(false);
        doEvent();
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
            setColorFilter(0xFF0370E5);
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
        super.onAttachedToWindow();
        FlyAction.register(this,mCellBean.recvAction);
    }

    @Override
    protected void onDetachedFromWindow() {
        mHandler.removeCallbacksAndMessages(null);
        focusChange(false);
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public void onAction(int key, Object obj) {
        if (mCellBean.recvAction != key) return;
        switch (mCellBean.recvAction) {
            case ActionKey.STATUS_PLAY:
                if (obj instanceof Integer) {
                    int status = (int) obj;
                    switchImage(status);
                }
                break;
        }
    }

    private void switchImage(int status) {
        switch (status) {
            case PlayStatus.STATUS_STARTPLAY:
            case PlayStatus.STATUS_PLAYING:
                showImageUrl(mCellBean.imageurl2);
                break;
            default:
                showImageUrl(mCellBean.imageurl1);
                break;
        }
    }
}
