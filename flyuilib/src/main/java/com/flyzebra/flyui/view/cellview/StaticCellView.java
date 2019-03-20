package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.view.customview.FlyImageView;
import com.flyzebra.flyui.view.customview.MirrorView;

public class StaticCellView extends FrameLayout implements ICell {
    protected CellBean appInfo;
    private FlyImageView imageView;
    private MirrorView mirrorView;

    public StaticCellView(Context context) {
        this(context, null);
    }

    public StaticCellView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StaticCellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public void initView(Context context) {
        imageView = new FlyImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(imageView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setData(CellBean appInfo) {
        this.appInfo = appInfo;
    }

    @Override
    public void notifyView() {
        if (imageView == null) return;
        Glide.with(getContext())
                .load(appInfo.imageurl1)
                .asBitmap()
                .skipMemoryCache(false)
                .dontAnimate()
                .into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(final Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                imageView.setImageBitmap(bitmap);
                if (mirrorView != null) {
                    setDrawingCacheEnabled(true);
                    Bitmap bmp = getDrawingCache();
                    mirrorView.showImage(bmp);
                }
            }
        });
    }

    @Override
    public void runAction() {
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
    }

    @Override
    public void setMirrorView(MirrorView mirrorView) {
        this.mirrorView = mirrorView;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

}
