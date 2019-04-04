package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.FlyImageView;
import com.flyzebra.flyui.view.customview.MirrorView;

public class ImageCellView extends FlyImageView implements ICell {
    protected CellBean mCellBean;
    private MirrorView mirrorView;

    public ImageCellView(Context context) {
        super(context);
    }


    @Override
    public void initView(Context context) {
    }

    @Override
    public void upData(CellBean appInfo) {
        this.mCellBean = appInfo;
        if(!TextUtils.isEmpty(mCellBean.event)){
            this.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    doEvent();
                }
            });
        }
    }

    @Override
    public void upView() {
        if (TextUtils.isEmpty(mCellBean.imageurl1)) return;
        String imageurl = UpdataVersion.getNativeFilePath(mCellBean.imageurl1);
        Glide.with(getContext())
                .load(imageurl)
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
        FlyLog.d("doEvent event="+mCellBean.event);
        switch (mCellBean.event) {
            case "PLAY":
                FlyAction.notifyAction(10, null);
                break;
        }
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {
        this.mirrorView = mirrorView;
    }

}
