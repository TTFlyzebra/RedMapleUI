package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.FlyTabView;
import com.flyzebra.flyui.view.customview.MirrorView;

/**
 * Author FlyZebra
 * 2019/4/16 15:01
 * Describ:
 **/
class FragmentNavCellView extends FrameLayout implements ICell,IAction {
    private CellBean mCellBean;
    private FlyTabView flyTabView;

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
            flyTabView = new FlyTabView(getContext());
            flyTabView.setOrientation(mCellBean.width > mCellBean.height ? LinearLayout.HORIZONTAL : LinearLayout.VERTICAL);
            LayoutParams lp = new LayoutParams(mCellBean.width, mCellBean.height);
            addView(flyTabView, lp);
            flyTabView.setTitles(cellBean);
            flyTabView.setOnItemClickListener(new FlyTabView.OnItemClickListener() {
                @Override
                public void onItemClick(View v) {
                    FlyAction.notifyAction(ActionKey.PAGER_RESID,mCellBean.subCells.get((Integer) v.getTag()).resId);
                }
            });
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

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyAction.register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        if(mCellBean == null || mCellBean.subCells.isEmpty()) return false;
        if(key==ActionKey.PAGER_RESID){
            Object obj = FlyAction.getValue(key);
            if(obj instanceof String) {
                for (int i = 0; i < mCellBean.subCells.size(); i++) {
                    if (obj.equals(mCellBean.subCells.get(i).resId)) {
                        flyTabView.setFocusPos(i);
                        break;
                    }
                }
            }
        }
        return false;
    }
}
