package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.module.FlyClass;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseView;
import com.flyzebra.flyui.view.customview.MirrorView;
import com.flyzebra.flyui.view.themeview.PagesViewPager;

/**
 * Author FlyZebra
 * 2019/3/25 12:08
 * Describ:
 **/
public class NavCellView extends BaseView implements ICell, ViewPager.OnPageChangeListener {
    private CellBean mCellBean;
    private ViewPager mViewPger;
    private Paint paint;
    private int width;
    private int height;
    private int sumItem = 0;
    private int currentItem = 0;
    private Bitmap nav_on;
    private Bitmap nav_off;

    public NavCellView(Context context) {
        super(context);
        initView(context);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (sumItem > 0 && nav_on != null && nav_off != null && width > 0 && height > 0) {
            float x = width / 2 - (sumItem * height * 2 - height) / 2;
            for (int i = 0; i < sumItem; i++) {
                if (i == currentItem) {
                    if (sumItem > 1 && i > 0 && i < sumItem - 1) {
                        canvas.drawBitmap(nav_on, x + i * height * 2, 0, paint);
                    }
                } else {
                    if (sumItem > 1 && i > 0 && i < sumItem - 1) {
                        canvas.drawBitmap(nav_off, x + i * height * 2, 0, paint);
                    }
                }
            }
        }

    }

    private void initPaint() {
        if (paint == null) {
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(0xFFFFFFFF);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    @Override
    public void initView(Context context) {
        initPaint();
    }

    @Override
    public void upData(CellBean cellBean) {
        FlyLog.d("upData");
        mCellBean = cellBean;
        upView();
    }

    public void upView() {
        FlyLog.d("upView");
        if (mCellBean == null) {
            return;
        }
        Glide.with(getContext())
                .asBitmap()
                .load(UpdataVersion.getNativeFilePath(mCellBean.imageurl1))
                .override(mCellBean.width, mCellBean.height)
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
                .load(UpdataVersion.getNativeFilePath(mCellBean.imageurl2))
                .override(mCellBean.width, mCellBean.height)
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
        postInvalidate();
    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

    }

    public void setViewPager(final ViewPager viewPager) {
        if (viewPager == null) return;
        if (mViewPger != null) {
            mViewPger.removeOnPageChangeListener(this);
        }
        mViewPger = viewPager;
        setCurrentItem(mViewPger.getCurrentItem());
        if (viewPager.getAdapter() != null) {
            setSumItem(mViewPger.getAdapter().getCount());
        }
        if (mViewPger != null) {
            mViewPger.removeOnPageChangeListener(this);
            mViewPger.addOnPageChangeListener(this);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mViewPger == null) {
            setViewPager(FlyClass.get(PagesViewPager.class));
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mViewPger != null) {
            mViewPger.removeOnPageChangeListener(this);
        }
        super.onDetachedFromWindow();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        int item = mViewPger.getCurrentItem();
        if (sumItem > 1) {
            if (item == sumItem - 1) {
                item = sumItem - 2;
            } else if (item == 0) {
                item = 1;
            }
        }
        setCurrentItem(item);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

}
