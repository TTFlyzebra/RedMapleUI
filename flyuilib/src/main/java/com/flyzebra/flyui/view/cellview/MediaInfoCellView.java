package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;


public class MediaInfoCellView extends SimpleCellView {
    public Bitmap bitmap = null;
    public Bitmap defBitmap = null;

    public MediaInfoCellView(Context context) {
        super(context);
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return super.verify(cellBean);
    }

    @Override
    public void loadingRes(CellBean cellBean) {
        if (cellBean.images == null && mCellBean.images.isEmpty()) return;
        String imageurl = UpdataVersion.getNativeFilePath(cellBean.images.get(0).url);
        Glide.with(getContext())
                .asBitmap()
                .load(imageurl)
                .override(cellBean.images.get(0).width, cellBean.images.get(0).height)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerInside()
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        defBitmap = resource;
                        refreshView(mCellBean);
                        try{
                            FlyEvent.sendEvent(mCellBean.recv.recvId);
                        }catch (Exception e){
                            FlyLog.e(e.toString());
                        }
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    @Override
    public void refreshView(CellBean cellBean) {
        //设置图片
        if (!imageViewList.isEmpty()) {
            if (bitmap == null) {
                if (defBitmap != null) {
                    imageViewList.get(0).setImageBitmap(defBitmap);
                }
            } else {
                imageViewList.get(0).setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public boolean recvEvent(byte[] key) {
        if (mCellBean == null || mCellBean.recv == null || mCellBean.recv.recvId == null) {
            return false;
        }
        if (!mCellBean.recv.recvId.equals(ByteUtil.bytes2HexString(key))) {
            return false;
        }
        switch (mCellBean.recv.recvId) {
            case "100201":
                break;
            case "100227":
                final byte[] imageBytes = (byte[]) FlyEvent.getValue(mCellBean.recv.recvId);
                FlyLog.d("handle 100227 imageBytes=" + imageBytes);
                if (imageBytes == null) {
                    bitmap = null;
                    refreshView(mCellBean);
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                            } catch (Exception e) {
                                FlyLog.e(e.toString());
                                bitmap = null;
                            }
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    refreshView(mCellBean);
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
}
