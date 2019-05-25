package com.flyzebra.flyui.view.cellview;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.ImageBean;
import com.flyzebra.flyui.bean.TextBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseImageBeanView;
import com.flyzebra.flyui.view.base.BaseLayoutCellView;
import com.flyzebra.flyui.view.base.BaseTextBeanView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Author FlyZebra
 * 2019/5/23 17:56
 * Describ:
 **/
public class LoopPlayCellView extends BaseLayoutCellView implements View.OnTouchListener {
    private int screenWidth = 1024;
    private int screenHeigh = 600;
    private float countScrollX = 0;
    private int childWidth = 200;
    private float mouseDownX = 0;
    private MyView views[];

    public LoopPlayCellView(Context context) {
        super(context);
        setOnTouchListener(this);
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeigh = dm.heightPixels;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        GV.viewPage_scoller = false;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return true;
    }

    @Override
    public void init(CellBean cellBean) {
        //TODO:加入判断机制
        try {
            removeAllViews();
            childWidth = mCellBean.images.get(2).width;
            views = new MyView[mCellBean.images.size()];
            for (int i = 0; i < views.length; i++) {
                views[i] = new MyView(getContext());
                ImageBean imageBean = cellBean.images.get(i);
                LayoutParams flp = new LayoutParams(imageBean.width, imageBean.height);
                flp.leftMargin = imageBean.left;
                flp.topMargin = imageBean.top;
                addView(views[i], flp);

                ImageView imageView = new BaseImageBeanView(getContext());
                ((BaseImageBeanView) imageView).setmImageBean(imageBean);
                views[i].addImageView(imageView, new LayoutParams(imageBean.width, imageBean.height));

                TextBean textBean = cellBean.texts.get(i);
                TextView textView = new BaseTextBeanView(getContext());
                ((BaseTextBeanView) textView).setTextBean(textBean);
                int tw = (imageBean.width - textBean.right) - textBean.left;
                int top = textBean.top * imageBean.height / mCellBean.images.get(2).height;
                int th = (imageBean.height - textBean.bottom) - top;
                LayoutParams tlp = new LayoutParams(tw == 0 ? imageBean.width : tw, th == 0 ? imageBean.height : th);
                tlp.topMargin = top;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textBean.textSize * imageBean.height / mCellBean.images.get(2).height);
                views[i].addTextView(textView, tlp);

            }

            post(new Runnable() {
                @Override
                public void run() {
                    bringAllViewToFront();
                }
            });
        } catch (Exception e) {
            FlyLog.d();
        }
    }


    private void setViewPoint(int count, int during) {
        FlyLog.d("setViewPoing sss %d", count);
        countScrollX = count % (childWidth * mCellBean.images.size());
        if (countScrollX < 0) {
            countScrollX = countScrollX + childWidth * mCellBean.images.size();
        }
        int num = (int) (countScrollX / childWidth);
        float go = countScrollX % (float) childWidth / (float) childWidth;
//        if (go > 0) {
        for (int i = 0; i < views.length; i++) {
            //X坐标
            int maxGoX = mCellBean.images.get((i + num) % mCellBean.images.size()).left;
            int minGoX = (int) ((mCellBean.images.get((i + num + 1) % mCellBean.images.size()).left - maxGoX) * go);
            views[i].animate().x(maxGoX + minGoX).setDuration(during).start();
            //Y坐标
            int maxGoY = mCellBean.images.get((i + num) % mCellBean.images.size()).top;
            int minGoY = (int) ((mCellBean.images.get((i + num + 1) % mCellBean.images.size()).top - maxGoY) * go);
            views[i].animate().y(maxGoY + minGoY).setDuration(during).start();

            ViewWrapper viewWrapper = new ViewWrapper(views[i]);
            //宽度
            int maxGoW = mCellBean.images.get((i + num) % mCellBean.images.size()).width;
            int minGoW = (int) ((mCellBean.images.get((i + num + 1) % mCellBean.images.size()).width - maxGoW) * go);
            ObjectAnimator.ofInt(viewWrapper, "width", views[i].getWidth(), maxGoW + minGoW).setDuration(during).start();
            //高度

            int maxGoH = mCellBean.images.get((i + num) % mCellBean.images.size()).height;
            int minGoH = (int) ((mCellBean.images.get((i + num + 1) % mCellBean.images.size()).height - maxGoH) * go);
            ObjectAnimator.ofInt(viewWrapper, "height", views[i].getHeight(), maxGoH + minGoH).setDuration(during).start();
            FlyLog.d("countScrollX=%f,go=%f,maxGo=%d,minGo = %d", countScrollX, go, maxGoX, minGoX);

            bringAllViewToFront();

        }
//        } else {
//            FlyLog.d("no go=%f", go);
//        }
    }

    private void bringAllViewToFront() {
        //置前
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int j = 0; j < views.length; j++) {
            Map<String, Integer> map = new ArrayMap<>();
            map.put("sort", j);
            map.put("height", views[j].getHeight());
            list.add(map);
        }

        Collections.sort(list, new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                return o1.get("height") - o2.get("height");
            }

        });

        for (int j = 0; j < list.size(); j++) {
            views[list.get(j).get("sort")].bringToFront();
        }
    }

    @Override
    public void refresh(CellBean cellBean) {
        try {
            if (cellBean.images == null) return;
            for (int i = 0; i < views.length; i++) {
                String imageurl = UpdataVersion.getNativeFilePath(cellBean.images.get(i).url);
                Glide.with(getContext())
                        .load(imageurl)
                        .override(cellBean.images.get(i).width, cellBean.images.get(i).height)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .centerInside()
                        .into(views[i].imageView);
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        FlyLog.d("touch x=%f,y=%f", event.getX(), event.getY());
        if (event.getX() > (924*screenWidth/1024) || event.getX() < (100*screenWidth/1024)) {
            adjustPoint();
            return false;
        }
        if (event.getY() > (500*screenHeigh/600) || event.getY() < (100*screenHeigh/600)) {
            adjustPoint();
            return false;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mouseDownX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float move_X = event.getX() - mouseDownX;
                countScrollX += move_X;
                mouseDownX = event.getX();
                setViewPoint((int) countScrollX, 0);
                break;
            case MotionEvent.ACTION_UP:
                adjustPoint();
                break;
        }
        return true;
    }

    private void adjustPoint() {
        if (countScrollX % childWidth > (childWidth / 2)) {
            int pos = (int) (countScrollX - countScrollX % childWidth + childWidth);
            setViewPoint(pos, 300);
            FlyLog.d("setViewPoint sss r %d", pos);
        } else {
            int pos = (int) (countScrollX - countScrollX % childWidth);
            setViewPoint(pos, 300);
            FlyLog.d("setViewPoint sss l %d", pos);
        }
    }

    class MyView extends FrameLayout {

        public ImageView imageView;
        public TextView textView;

        public MyView(@NonNull Context context) {
            super(context);
        }

        public void addImageView(ImageView imageView, LayoutParams layoutParams) {
            this.imageView = imageView;
            addView(imageView, layoutParams);
        }

        public void addTextView(TextView textView, LayoutParams layoutParams) {
            this.textView = textView;
            addView(textView, layoutParams);
        }
    }

    private class ViewWrapper {

        private MyView rView;

        public ViewWrapper(MyView target) {
            rView = target;
        }

        public int getWidth() {
            return rView.getLayoutParams().width;
        }

        public void setWidth(int width) {
            rView.getLayoutParams().width = width;
            rView.imageView.getLayoutParams().width = width;
            rView.textView.getLayoutParams().width = width;
            rView.requestLayout();
        }

        public int getHeight() {
            return rView.getLayoutParams().height;
        }

        public void setHeight(int height) {
            rView.getLayoutParams().height = height;
            rView.imageView.getLayoutParams().height = height;
            try {
                LayoutParams layoutParams = (LayoutParams) rView.textView.getLayoutParams();
                layoutParams.topMargin = mCellBean.texts.get(0).top * height / mCellBean.images.get(2).height;
                rView.textView.setLayoutParams(layoutParams);
                rView.textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24 * height / mCellBean.images.get(2).height);
            }catch (Exception e){
                FlyLog.e(e.toString());
            }
            rView.requestLayout();
        }
    }
}
