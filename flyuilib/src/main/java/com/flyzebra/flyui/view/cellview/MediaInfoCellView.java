package com.flyzebra.flyui.view.cellview;

import android.content.Context;

import com.flyzebra.flyui.utils.ByteUtil;


public class MediaInfoCellView extends SimpleCellView {

    public MediaInfoCellView(Context context) {
        super(context);
    }

    @Override
    public boolean recvEvent(byte[] key) {
        if (mCellBean == null || mCellBean.recv == null || mCellBean.recv.recvId == null) {
            return false;
        }
        if (!mCellBean.recv.recvId.equals(ByteUtil.bytes2HexString(key))) {
            return false;
        }
        switch (mCellBean.recv.recvId) {
            case "100201":
                break;

        }
        return false;
    }
}
