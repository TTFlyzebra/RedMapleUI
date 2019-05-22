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
import com.flyzebra.flyui.view.customview.FlyImageView;

/**
 * Author FlyZebra
 * 2019/5/20 16:08
 * Describ:
 **/
public class BaseImageBeanView extends FlyImageView implements IFlyEvent, View.OnTouchListener {
    private ImageBean mImageBean;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public Bitmap bitmap = null;

    public BaseImageBeanView(Context context) {
        super(context);
    }

    public void setmImageBean(final ImageBean imageBean) {
        mImageBean = imageBean;
        if (mImageBean != null && mImageBean.send != null && !TextUtils.isEmpty(mImageBean.send.eventId)) {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    FlyEvent.sendEvent(mImageBean.send.eventId);
                }
            });
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

    private void focusChange(boolean flag) {
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
            case "100227":
                final byte[] imageBytes = (byte[]) FlyEvent.getValue(mImageBean.recv.recvId);
                FlyLog.d("handle 100227 imageBytes=" + imageBytes);
                if (imageBytes == null) {
                    setDefImageBitmap();
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                            } catch (Exception e) {
                                FlyLog.e(e.toString());
                                return;
                            }
                            if (bitmap == null) return;
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (bitmap != null) {
                                        setImageBitmap(bitmap);
                                    }
                                    FlyLog.d("handle 100227 finish; bitmap=" + bitmap);
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
}
