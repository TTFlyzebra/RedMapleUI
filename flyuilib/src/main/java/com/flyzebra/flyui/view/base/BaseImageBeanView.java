package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.flyzebra.flyui.bean.ImageBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.IntentUtil;
import com.flyzebra.flyui.view.customview.ShapeImageView;

/**
 * Author FlyZebra
 * 2019/5/20 16:08
 * Describ:
 **/
public class BaseImageBeanView extends ShapeImageView implements IFlyEvent, View.OnClickListener, View.OnTouchListener {
    private ImageBean mImageBean;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public Bitmap mBitmap = null;

    public BaseImageBeanView(Context context) {
        super(context);
    }

    public void setmImageBean(final ImageBean imageBean) {
        if (imageBean == null) return;
        mImageBean = imageBean;
        setScaleType(imageBean.getScaleType());
        setShapeType(imageBean.shapeType);
        if (mImageBean != null && mImageBean.send != null) {
            setOnClickListener(this);
            setOnTouchListener(this);
        }
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

    protected void focusChange(boolean flag) {
        if (flag) {
            try {
                setColorFilter(Color.parseColor(mImageBean.filterColor));
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
    protected void onAttachedToWindow() {
        FlyLog.v("onAttachedToWindow");
        super.onAttachedToWindow();
        FlyEvent.register(this);
        if (mImageBean == null || mImageBean.recv == null || mImageBean.recv.recvId == null) {
            return;
        }
        recvEvent(ByteUtil.hexString2Bytes(mImageBean.recv.recvId));
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyLog.v("onDetachedFromWindow");
        mHandler.removeCallbacksAndMessages(null);
        FlyEvent.unregister(this);
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
        if (mImageBean == null || mImageBean.recv == null || mImageBean.recv.recvId == null) {
            return false;
        }
        if (!mImageBean.recv.recvId.equals(ByteUtil.bytes2HexString(key))) {
            return false;
        }
        switch (mImageBean.recv.recvId) {
            case "100201":
                break;
            //接受到了图片内容
            case "100227":
                final byte[] imageBytes = (byte[]) FlyEvent.getValue(mImageBean.recv.recvId);
                FlyLog.d("handle 100227 imageBytes=" + imageBytes);
                if (imageBytes == null) {
                    mBitmap = null;
                    setDefImageBitmap();
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

    private void setDefImageBitmap() {
        if (mImageBean == null || TextUtils.isEmpty(mImageBean.url)) return;
        Glide.with(getContext()).load(UpdataVersion.getNativeFilePath(mImageBean.url)).diskCacheStrategy(DiskCacheStrategy.NONE).into(this);
    }

    @Override
    public void onClick(View v) {
        if (!TextUtils.isEmpty(mImageBean.send.eventId)) {
            FlyEvent.sendEvent(mImageBean.send.eventId);
        } else if (IntentUtil.execStartPackage(getContext(), mImageBean.send.packName, mImageBean.send.className)) {
        } else if (IntentUtil.execStartPackage(getContext(), mImageBean.send.packName)) {
        }
    }
}
