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
            case CellType.TYPE_IMAGE:
                iCellView = new ImageCellView(context);
                break;
            case CellType.TYPE_APP_RADIO:
                iCellView = new SimpeCellView(context);
                break;
            case CellType.TYPE_APP_TIME:
                iCellView = new TimeCellView(context);
                break;
            case CellType.TYPE_APP_MEDIA:
                iCellView = new SimpeCellView(context);
                break;
            case CellType.TYPE_APP_MIRRORIMG:
                iCellView = new MirrorCellView(context);
                break;
            case CellType.TYPE_APP_NAV:
                iCellView = new PagesNavCellView(context);
                break;
            case CellType.TYPE_KEY_VIEW:
                iCellView = new SimpeCellView(context);
                break;
            case CellType.TYPE_POP_MENU:
                iCellView = new PopmenuCellView(context);
                break;
            case CellType.TYPE_SWITH_MENU:
                iCellView = new SimpeCellView(context);
                break;
            case CellType.TYPE_TEXT:
                iCellView = new TextCellView(context);
                break;
            case CellType.TYPE_APP_NORMAL:
            default:
                iCellView = new SimpeCellView(context);
                break;
        }
        iCellView.upData(cellBean);
        return iCellView;
    }

}
