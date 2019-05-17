package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseView;


/**
 * Author FlyZebra
 * 2019/3/25 12:08
 * Describ:
 **/
public class SimpleNavCellView extends BaseView implements ICell {
    private CellBean mCellBean;
    private Paint paint;
    private int sumItem = 20;
    private int currentItem = 1;
    private Bitmap nav_on;
    private Bitmap nav_off;

    public SimpleNavCellView(Context context) {
        super(context);
    }


    @Override
    public void setCellBean(CellBean cellBean) {
        FlyLog.d("setCellBean");
        this.mCellBean = cellBean;
        verify(mCellBean);
    }

    @Override
    public void verify(CellBean mCellBean) {
        if (mCellBean != null && mCellBean.images != null && mCellBean.images.size() > 1) {
            loadingRes(mCellBean);
        }
    }

    @Override
    public void loadingRes(CellBean mCellBean) {
        Glide.with(getContext())
                .asBitmap()
                .load(UpdataVersion.getNativeFilePath(mCellBean.images.get(0).url))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        nav_on = resource;
                        postInvalidate();
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }

                });

        Glide.with(getContext())
                .asBitmap()
                .load(UpdataVersion.getNativeFilePath(mCellBean.images.get(1).url))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        nav_off = resource;
                        postInvalidate();
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
        initView(getContext());
    }

    @Override
    public void initView(Context context) {
        initPaint();
        refreshView(mCellBean);
    }


    @Override
    public void refreshView(CellBean cellBean) {

    }

    @Override
    public void onClick() {
    }

    @Override
    public void bindMirrorView(ViewGroup viewGroup, ViewGroup.LayoutParams lpMirror) {
    }

    @Override
    public boolean handleAction(byte[] key) {
        return false;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (sumItem > 0 && nav_on != null && nav_off != null && mCellBean.width > 0 && mCellBean.height > 0) {
            float x = mCellBean.width / 2 - (sumItem * mCellBean.height) + mCellBean.height / 2;
            if (paint == null) {
                initPaint();
            }
            for (int i = 1; i <= sumItem; i++) {
                if (i == currentItem) {
                    canvas.drawBitmap(nav_on, x + (i - 1) * mCellBean.height * 2, 0, paint);
                } else {
                    canvas.drawBitmap(nav_off, x + (i - 1) * mCellBean.height * 2, 0, paint);
                }
            }
        }

    }

    private void initPaint() {
        if (paint == null) {
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    public void setSumItem(int sumItem) {
        if (sumItem > 1) {
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
        }
        this.sumItem = sumItem;
        postInvalidate();
    }

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
        postInvalidate();
    }

}
