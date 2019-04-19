package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;

import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.config.ActionKey;
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
    }

    @Override
    public void upData(CellBean cellBean) {
        if (cellBean == null) {
            removeAllViews();
            return;
        }
        this.mCellBean = cellBean;
        resID = 0x4f000001 + mCellBean.cellId;
        setId(resID);
        if (mCellBean != null && mCellBean.cellpage != null && mCellBean.cellpage.cellList != null && mCellBean.cellpage.cellList.size() > 0) {
            Object obj = FlyAction.getValue(ActionKey.CHANGE_PAGER_WITH_RESID);
            if (obj != null) {
                for (CellBean subCell : mCellBean.cellpage.cellList) {
                    if (obj.equals(subCell.resId)) {
                        replaceFragment(subCell, resID);
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
        mHandler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        if (mCellBean == null || mCellBean.cellpage == null || mCellBean.cellpage.cellList == null || mCellBean.cellpage.cellList.isEmpty())
            return false;
        if (key == ActionKey.CHANGE_PAGER_WITH_RESID) {
            Object obj = FlyAction.getValue(key);
            for (CellBean cellBean : mCellBean.cellpage.cellList) {
                if (obj.equals(cellBean.resId)) {
                    replaceFragment(cellBean, resID);
                    break;
                }
            }
        }
        return false;
    }


    private Handler mHandler = new Handler(Looper.getMainLooper());
    public void replaceFragment(final CellBean cellBean, int resID) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                removeAllViews();
                ICell view = CellViewFactory.createView(getContext(), cellBean);
                addView((View) view);
                view.upData(cellBean);
            }
        });
//        try {
//            FragmentTransaction ft = ((Activity) getContext()).getFragmentManager().beginTransaction();
//            Fragment fragment = CellFragment.newInstance(cellBean);
//            ft.replace(resID, fragment).commit();
//        } catch (Exception e) {
//            FlyLog.e(e.toString());
//        }
    }

}
