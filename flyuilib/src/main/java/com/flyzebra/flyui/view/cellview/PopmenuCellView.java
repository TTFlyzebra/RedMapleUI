package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.PageBean;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;
import com.flyzebra.flyui.view.pageview.SimplePageView;

/**
 * Author FlyZebra
 * 2019/4/2 16:15
 * Describ:
 **/
public class PopmenuCellView extends FrameLayout implements ICell {
    private CellBean mCellBean;

    public PopmenuCellView(Context context) {
        super(context);
    }

    @Override
    public void initView(Context context) {
        if (mCellBean == null || mCellBean.subCells == null || mCellBean.subCells.isEmpty()) return;
        PageBean pageBean = new PageBean();
        pageBean.cellList = mCellBean.subCells;
        SimplePageView simplePageView = new SimplePageView(context);
        addView(simplePageView);
        simplePageView.upData(pageBean);
        upView();
    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        initView(getContext());
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
