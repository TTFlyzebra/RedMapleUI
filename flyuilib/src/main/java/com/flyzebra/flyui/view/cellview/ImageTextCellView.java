package com.flyzebra.flyui.view.cellview;

import android.content.Context;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.view.base.BaseTextCellView;

public class ImageTextCellView extends BaseTextCellView {

    public ImageTextCellView(Context context) {
        super(context);
    }


    @Override
    public boolean verify(CellBean cellBean) {
        return !(cellBean == null ||
                cellBean.texts == null ||
                cellBean.texts.isEmpty() ||
                cellBean.images == null ||
                cellBean.images.isEmpty());
    }

    @Override
    public void initView(Context context) {
    }

    @Override
    public void refreshView(CellBean cellBean) {
    }


}
