package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.FlyTabView;
import com.flyzebra.flyui.view.customview.MirrorView;

/**
 * Author FlyZebra
 * 2019/4/16 15:01
 * Describ:
 **/
class FragmentNavCellView extends FrameLayout implements ICell {
    private CellBean mCellBean;

    public FragmentNavCellView(Context context) {
        super(context);
    }

    @Override
    public void initView(Context context) {

    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean != null && mCellBean.subCells.size() > 0) {
            FlyTabView flyTabView = new FlyTabView(getContext());
            flyTabView.setOrientation(mCellBean.width > mCellBean.height ? LinearLayout.HORIZONTAL : LinearLayout.VERTICAL);
            LayoutParams lp = new LayoutParams(mCellBean.width, mCellBean.height);
            addView(flyTabView, lp);
            flyTabView.setTitles(cellBean);
        }

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
