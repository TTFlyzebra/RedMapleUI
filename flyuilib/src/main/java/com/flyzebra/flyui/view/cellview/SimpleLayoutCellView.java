package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.flyzebra.flyui.bean.CellBean;

public class SimpleLayoutCellView extends FrameLayout implements ICell, View.OnClickListener {
    private CellBean mCellBean;

    public SimpleLayoutCellView(Context context) {
        super(context);
    }

    @Override
    public void setCellBean(CellBean cellBean) {
        this.mCellBean = cellBean;
        verify(cellBean);
    }

    @Override
    public boolean verify(CellBean cellBean) {
        if(cellBean==null) return false;
        loadingRes(cellBean);
        return true;
    }

    @Override
    public void loadingRes(CellBean cellBean) {
        initView(getContext());
    }

    @Override
    public void initView(Context context) {
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
    public void onClick(View v) {
        onClick();
    }

}
