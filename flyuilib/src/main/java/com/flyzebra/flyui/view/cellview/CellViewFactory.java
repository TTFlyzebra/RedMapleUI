package com.flyzebra.flyui.view.cellview;

import android.content.Context;

import com.flyzebra.flyui.bean.CellBean;


/**
 * 每页中cell控件生成类
 * Created by FlyZebra on 2016/6/15.
 */
public class CellViewFactory {
    /**
     * 根据传入的AppInfo构建对应的自定义pageItemView
     *
     * @param context
     */
    public static ICell createView(Context context, CellBean cellBean) {
        ICell iCellView;
        switch (cellBean.celltype) {
            case CellType.TYPE_APP_NORMAL:
            default:
                boolean hasText = cellBean.texts != null && !cellBean.texts.isEmpty();
                boolean hasImage = cellBean.images != null && !cellBean.images.isEmpty();
                iCellView = hasImage && hasText ? new SimpleCellView(context)
                        : hasText ? new SimpleTextCellView(context)
                        : hasImage ? new SimpleImageCellView(context)
                        : new SimpleLayoutCellView(context);
                break;
            case CellType.TYPE_APP_NAV:
                iCellView = new SimpleNavCellView(context);
        }
        return iCellView;
    }

}
