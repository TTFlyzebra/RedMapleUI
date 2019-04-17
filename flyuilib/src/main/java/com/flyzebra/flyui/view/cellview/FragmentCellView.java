package com.flyzebra.flyui.view.cellview;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;

import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.fragment.CellFragment;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;

/**
 * Author FlyZebra
 * 2019/4/16 14:41
 * Describ:
 **/
public class FragmentCellView extends FrameLayout implements ICell, IAction {
    private CellBean mCellBean;
    private int resID = 0x4f000001;

    public FragmentCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
        setId(resID);
    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean != null && mCellBean.cellpage != null && mCellBean.cellpage.cellList != null && mCellBean.cellpage.cellList.size() > 0) {
            Object obj = FlyAction.getValue(ActionKey.PAGER_RESID);
            if (obj != null) {
                for (CellBean subCell : mCellBean.cellpage.cellList) {
                    if (obj.equals(subCell.resId)) {
                        replaceFragment(subCell);
                        break;
                    }
                }
            }
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
        if (mCellBean == null || mCellBean.cellpage == null || mCellBean.cellpage.cellList == null || mCellBean.cellpage.cellList.isEmpty())
            return false;
        if (key == ActionKey.PAGER_RESID) {
            Object obj = FlyAction.getValue(key);
            for (CellBean cellBean : mCellBean.cellpage.cellList) {
                if (obj.equals(cellBean.resId)) {
                    replaceFragment(cellBean);
                    break;
                }
            }
        }
        return false;
    }


    public void replaceFragment(CellBean cellBean) {
        try {
            FragmentTransaction ft = ((Activity) getContext()).getFragmentManager().beginTransaction();
            Fragment fragment = CellFragment.newInstance(cellBean);
            ft.replace(resID, fragment).commitAllowingStateLoss();
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

}
