package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseImageCellView;

public class SingleImageTextCellView extends BaseImageCellView {
    private String[] contents;

    public SingleImageTextCellView(Context context) {
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
        try {
            contents = cellBean.recv.recvContent.split("#");
            recvEvent(ByteUtil.hexString2Bytes(mCellBean.recv.recvId));
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    @Override
    public void refresh(CellBean cellBean) {
    }

    @Override
    public boolean recvEvent(byte[] key) {
        if (mCellBean == null || mCellBean.recv == null || mCellBean.recv.recvId == null) {
            return false;
        }
        if (!mCellBean.recv.recvId.equals(ByteUtil.bytes2HexString(key))) {
            return false;
        }
        try {
            Object obj = FlyEvent.getValue(key);
            if (obj instanceof String && contents != null) {
                int num = -1;
                for (int i = 0; i < contents.length; i++) {
                    if (((String) obj).contains(contents[i])) {
                        num = i;
                        break;
                    }
                }
                if(num>=0&&num<mCellBean.images.size()){
                    String imageurl = UpdataVersion.getNativeFilePath(mCellBean.images.get(num).url);
                    Glide.with(getContext())
                            .asBitmap()
                            .load(imageurl)
                            .override(mCellBean.images.get(0).width, mCellBean.images.get(num).height)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .centerInside()
                            .into(new BitmapImageViewTarget(this) {
                                @Override
                                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                    setImageBitmap(resource);
                                }
                            });
                }
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
        FlyLog.d("handle event=" + ByteUtil.bytes2HexString(key));
        return false;
    }
}
