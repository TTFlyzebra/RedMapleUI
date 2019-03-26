package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.module.FlyFindClass;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseView;
import com.flyzebra.flyui.view.customview.MirrorView;
import com.flyzebra.flyui.view.themeview.PagesViewPager;

/**
 * Author FlyZebra
 * 2019/3/25 12:08
 * Describ:
 **/
public class PagesNavCellView extends BaseView implements ICell, ViewPager.OnPageChangeListener {
    private CellBean mCellBean;
    private ViewPager mViewPger;
    private Paint paint;
    private int width;
    private int height;
    private int sumItem = 0;
    private int currentItem = 0;
    private Bitmap nav_on;
    private Bitmap nav_off;

    public PagesNavCellView(Context context) {
        this(context, null);
    }

    public PagesNavCellView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagesNavCellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }

    @Override
    public void upView() {
        FlyLog.d("upView");
        if (mCellBean == null) {
            return;
        }
        Glide.with(getContext()).load(mCellBean.imageurl1).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                nav_on = bitmap;
                if (nav_on != null) {
                    postInvalidate();
                }
            }
        });

        Glide.with(getContext()).load(mCellBean.imageurl2).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                nav_off = bitmap;
                if (nav_off != null) {
                    postInvalidate();
                }
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
            setViewPager(FlyFindClass.get(PagesViewPager.class));
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
