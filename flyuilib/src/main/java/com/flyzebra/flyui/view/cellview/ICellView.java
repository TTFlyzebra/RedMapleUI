package com.flyzebra.flyui.view.cellview;

import android.content.Context;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.view.flyview.MirrorView;


public interface ICellView {

    void initView(Context context);

    void setData(CellBean appInfo);

    void notifyView();

    void runAction();

    void setMirrorView(MirrorView mirrorView);
}
