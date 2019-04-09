package com.flyzebra.flyuitvlib.tvview.CellView;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;

/**
 * 每页中cell控件生成类
 * Created by lzy on 2016/6/15.
 */
public class TvPageViewItemFactory {
    /**
     * 根据传入的cellEntity构建对应的自定义pageItemView
     *
     * @param context
     * @param cell
     * @return
     */
    public static ITvPageItemView createView(Context context, IDiskCache iDiskCache, BitmapCache bitmapCache, CellEntity cell, @DrawableRes int resID) {
        ITvPageItemView base;
        switch (cell.getType()) {
            default:
                //默认返回基类
                base = new SimpleCellView(context);
                break;
        }
        base.setDiskCache(iDiskCache);
        base.setBitmapCache(bitmapCache);
        base.setLoadImageResId(resID);
        return base;
    }

    //解析备注中的值
    public static void handleExtend(Context context, CellEntity cell) {
        if (!TextUtils.isEmpty(cell.getExtendData())) {
            FlyBean flyBean = GsonUtils.json2Object(cell.getExtendData(), FlyBean.class);
            if (flyBean != null) {
                float scaleScreen = DisplayUtils.getMetrices((Activity) context).widthPixels / 1920f;
                if (flyBean.getType() != 0) {
                    cell.setType(flyBean.getType());
                }

//                if (flyBean.getWidth() != 0) {
//                    cell.setWidth((int) (flyBean.getWidth() * scaleScreen));
//                }
//
//                if (flyBean.getHeight() != 0) {
//                    cell.setHeight((int) (flyBean.getHeight()*scaleScreen));
//                }

                if (flyBean.getFocusScale() != 0) {
                    cell.setFocusScale(flyBean.getFocusScale());
                }

                if (flyBean.getFocusType() != 0) {
                    cell.setFocusType(flyBean.getFocusType());
                }

                if (flyBean.getShowImageNum() != 0) {
                    cell.setShowImageNum(flyBean.getShowImageNum());
                }

                if (flyBean.getShowRows() != 0) {
                    cell.setShowRows(flyBean.getShowRows());
                }

                if (flyBean.getMaxLine() != 0) {
                    cell.setMaxTextLine(flyBean.getMaxLine());
                }
                if (flyBean.getMinTextLine() != 0) {
                    cell.setMinTextLine(flyBean.getMinTextLine());
                }
                if (!TextUtils.isEmpty(flyBean.getMaskColor())) {
                    cell.setTextMaskColor(flyBean.getMaskColor());
                }

                if (!TextUtils.isEmpty(flyBean.getFont())) {
                    cell.setFont(flyBean.getFont());
                }

            }
        }
    }


}
