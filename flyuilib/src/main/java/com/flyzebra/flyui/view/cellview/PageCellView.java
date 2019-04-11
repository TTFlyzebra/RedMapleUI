package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;
import com.flyzebra.flyui.view.pageview.SimplePageView;

/**
 * Author FlyZebra
 * 2019/4/2 16:15
 * Describ:
 **/
public class PageCellView extends FrameLayout implements ICell {
    private CellBean mCellBean;

    public PageCellView(Context context) {
        super(context);
    }

    @Override
    public void initView(Context context) {

    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean != null && mCellBean.page != null ) {
            SimplePageView simplePageView = new SimplePageView(getContext());
            addView(simplePageView);
            simplePageView.upData(mCellBean.page);
        }
    }

    @Override
    public void upView() {
        try {
            setBackgroundColor(Color.parseColor(mCellBean.backcolor));
        } catch (Exception e) {
            FlyLog.e("error! parseColor exception!" + e.toString());
        }
    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

    }
}
