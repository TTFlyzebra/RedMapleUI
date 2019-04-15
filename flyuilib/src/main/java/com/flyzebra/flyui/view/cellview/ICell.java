package com.flyzebra.flyui.view.cellview;

import android.content.Context;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.view.customview.MirrorView;


public interface ICell {

    /**
     * 初始化布局
     * @param context
     */
    void initView(Context context);

    /**
     * 更新数据
     * @param cellBean
     */
    void upData(CellBean cellBean);

    /**
     * 执行事件
     */
    void doEvent();

    /**
     * 绑定设置镜像图片
     * @param mirrorView
     */
    void bindMirrorView(MirrorView mirrorView);
}
