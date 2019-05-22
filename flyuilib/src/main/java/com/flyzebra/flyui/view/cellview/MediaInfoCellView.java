package com.flyzebra.flyui.view.cellview;

import android.content.Context;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseViewFunc;


public class MediaInfoCellView extends SimpleCellView {

    public MediaInfoCellView(Context context) {
        super(context);
    }

    @Override
    public void init(CellBean cellBean) {
        super.init(cellBean);
        BaseViewFunc.sendRecvEvent(mCellBean.recv, this);
        for (int i= 0;i<imageViewList.size();i++) {
            BaseViewFunc.sendRecvEvent(mCellBean.images.get(i).recv,this);
        }
    }

    @Override
    public boolean recvEvent(byte[] key) {
        if (mCellBean == null || mCellBean.recv == null || mCellBean.recv.recvId == null) {
            return false;
        }
        FlyLog.d("handle event=" + mCellBean.recv.recvId);
        BaseViewFunc.handVisible(this, key, mCellBean.recv);
        for (int i= 0;i<imageViewList.size();i++) {
            BaseViewFunc.handVisible(imageViewList.get(i),key,mCellBean.images.get(i).recv);
        }
        FlyLog.d("finish handle event=" + mCellBean.recv.recvId);
        return false;
    }

}
