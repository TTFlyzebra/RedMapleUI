//package com.flyzebra.flyui.view.cellview;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.os.Handler;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.text.TextUtils;
//import android.view.MotionEvent;
//import android.view.View;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.bumptech.glide.request.target.BitmapImageViewTarget;
//import com.bumptech.glide.request.transition.Transition;
//import com.flyzebra.flyui.event.IAction;
//import com.flyzebra.flyui.bean.CellBean;
//import com.flyzebra.flyui.bean.ThemeBean;
//import com.flyzebra.flyui.chache.UpdataVersion;
//import com.flyzebra.flyui.event.ActionKey;
//import com.flyzebra.flyui.event.FlyAction;
//import com.flyzebra.flyui.utils.FlyLog;
//import com.flyzebra.flyui.view.customview.FlyImageView;
//import com.flyzebra.flyui.view.customview.MirrorView;
//
//public class StatusCellView extends FlyImageView implements ICell, IAction, View.OnTouchListener, View.OnClickListener {
//    protected CellBean mCellBean;
//    private MirrorView mirrorView;
//
//    public StatusCellView(Context context) {
//        super(context);
//        init(context);
//    }
//
//    @Override
//    public void init(CellBean cellBean) {
//        focusChange(false);
//    }
//
//    @Override
//    public void setCellBean(CellBean cellBean) {
//        this.mCellBean = cellBean;
//        if (mCellBean.send!=null) {
//            setOnClickListener(this);
//            setOnTouchListener(this);
//        }
//        setScaleType(ScaleType.CENTER);
//        refresh();
//    }
//
//    @Override
//    public void setEnabled(boolean enabled) {
//        super.setEnabled(enabled);
//        focusChange(!enabled);
//    }
//
//    public void refresh(CellBean cellBean) {
//        switch (mCellBean.recv) {
//            case ActionKey.MSG_PLAY_STATUS:
//            case ActionKey.MSG_MENU_STATUS:
//            case ActionKey.MSG_LOOP_STATUS:
//                Object obj = FlyAction.getValue(mCellBean.recvAction);
//                if (obj instanceof Integer) {
//                    int status = (int) obj;
//                    if (status == 0) {
//                        showImageUrl(mCellBean.imageurl1);
//                    }else if (status > 0 && mCellBean.subCells != null && mCellBean.subCells.size() >= status) {
//                        showImageUrl(mCellBean.subCells.get(status - 1).imageurl1);
//                    }
//                }else{
//                    showImageUrl(mCellBean.imageurl1);
//                }
//                break;
//            default:
//                showImageUrl(mCellBean.imageurl1);
//                break;
//        }
//    }
//
//    private void showImageUrl(String imageurl) {
//        if (TextUtils.isEmpty(imageurl)) return;
//        String url = UpdataVersion.getNativeFilePath(imageurl);
//        Glide.with(getContext())
//                .asBitmap()
//                .load(url)
//                .centerInside()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(new BitmapImageViewTarget(this){
//                    @Override
//                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
//                        FlyLog.d("width=%d,height=%d",resource.getWidth(),resource.getHeight());
//                        setImageBitmap(resource);
//                        if (mirrorView != null) {
//                            mirrorView.showImage(resource);
//                        }
//                    }
//                });
//    }
//
//    @Override
//    public void onClick() {
//        FlyLog.d("onClick event=" + mCellBean.sendAction);
//        if (mCellBean.sendAction > 0) {
//            FlyAction.sendEvent(mCellBean.sendAction);
//        }
//    }
//
//    @Override
//    public void bindMirrorView(MirrorView mirrorView) {
//        this.mirrorView = mirrorView;
//    }
//
//    @Override
//    public void onClick(View v) {
//        setEnabled(false);
//        onClick();
//        setEnabled(true);
//    }
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                focusChange(true);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                focusChange(isTouchPointInView(v, (int) event.getRawX(), (int) event.getRawY()));
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//                focusChange(false);
//                break;
//        }
//        return false;
//    }
//
//    private void focusChange(boolean flag) {
//        if (flag) {
//            mHandler.removeCallbacks(show);
//            mHandler.postDelayed(show, 300);
//            setColorFilter(ThemeBean.filterColor);
//        } else {
//            clearColorFilter();
//        }
//    }
//
//    private boolean isTouchPointInView(View view, int x, int y) {
//        if (view == null) {
//            return false;
//        }
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//        int left = location[0];
//        int top = location[1];
//        int right = left + view.getMeasuredWidth();
//        int bottom = top + view.getMeasuredHeight();
//        return y >= top && y <= bottom && x >= left && x <= right;
//    }
//
//    private Handler mHandler = new Handler();
//    private Runnable show = new Runnable() {
//        @Override
//        public void run() {
//            focusChange(false);
//        }
//    };
//
//
//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        FlyAction.register(this);
//    }
//
//    @Override
//    protected void onDetachedFromWindow() {
//        mHandler.removeCallbacksAndMessages(null);
//        focusChange(false);
//        FlyAction.unregister(this);
//        super.onDetachedFromWindow();
//    }
//
//    @Override
//    public boolean sendEvent(int key) {
//        if (mCellBean == null || key != mCellBean.recvAction) return false;
//        switch (mCellBean.recvAction) {
//            case ActionKey.MSG_PLAY_STATUS:
//            case ActionKey.MSG_MENU_STATUS:
//            case ActionKey.MSG_LOOP_STATUS:
//                Object obj = FlyAction.getValue(key);
//                if (obj instanceof Integer) {
//                    int status = (int) obj;
//                    if (status == 0) {
//                        showImageUrl(mCellBean.imageurl1);
//                    }else if (status > 0 && mCellBean.subCells != null && mCellBean.subCells.size() >= status) {
//                        showImageUrl(mCellBean.subCells.get(status - 1).imageurl1);
//                    }
//                }
//                return false;
//        }
//        return false;
//    }
//
//}
