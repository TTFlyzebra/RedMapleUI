package com.flyzebra.flyui.view.cellview;

import android.content.Context;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.view.carcellview.MediaInfoCellView;
import com.flyzebra.flyui.view.carcellview.RadioCellView;


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
    public static ICell createView(Context context, CellBean appInfo) {
        ICell iCellView;
        switch (appInfo.celltype) {
            case CellType.TYPE_BACKGROUND:
                iCellView = new StaticCellView(context);
                break;
            case CellType.TYPE_APP_RADIO:
                iCellView = new RadioCellView(context);
                break;
            case CellType.TYPE_APP_TIME:
                iCellView = new TimeCellView(context);
                break;
            case CellType.TYPE_APP_MEDIA:
                iCellView = new MediaInfoCellView(context);
                break;
            case CellType.TYPE_APP_MIRRORIMG:
                iCellView = new MirrorCellView(context);
                break;
            case CellType.TYPE_APP_NAV:
                iCellView = new NavCellView(context);
                break;
            case CellType.TYPE_APP_NORMAL:
            default:
                iCellView = new SimpeCellView(context);
                break;
        }
        iCellView.upData(appInfo);
        return iCellView;
    }

}
