package com.flyzebra.flyuitvlib.tvview;

import android.content.Context;
import android.text.TextUtils;

import com.flyzebra.flyui.chache.IDiskCache;
import com.flyzebra.flyuitvlib.data.CellBean;
import com.flyzebra.flyuitvlib.data.ControlBean;
import com.flyzebra.flyuitvlib.data.TemplateEntity;
import com.flyzebra.flyuitvlib.tvview.PPfunsTV.PPfunsTvView;

import java.util.List;

/**
 *
 * Created by FlyZebra on 2016/8/31.
 */
public class TvViewFactory {
    public static BaseTvView create(Context context, IDiskCache iDiskCache, TemplateEntity templateEntity, List<CellBean> cellBeanList, ControlBean controlBean) {
        BaseTvView mTvView = null;
        String TYPE = TextUtils.isEmpty(templateEntity.getTemplateDetail())?"":templateEntity.getTemplateDetail();
        switch (TYPE) {
            case "阿里版":
            case "酷炫版":
            case "炫酷版":
            case "flywithme":
//                mTvView = new PopupTvView(context);
//                break;
            default:
                mTvView = new PPfunsTvView(context);
                break;
        }
        mTvView.setDiskCache(iDiskCache)
                .setTvPageData(cellBeanList)
                .setNavData(templateEntity)
                .setControlData(controlBean);
        return mTvView;
    }

    public static BaseTvView create(Context context, TemplateEntity templateEntity){
        BaseTvView mTvView = null;
        String TYPE = TextUtils.isEmpty(templateEntity.getTemplateDetail())?"":templateEntity.getTemplateDetail();
        switch (TYPE) {
            case "阿里版":
            case "酷炫版":
            case "炫酷版":
            case "flywithme":
                mTvView = new PopupTvView(context);
                break;
            default:
                mTvView = new PPfunsTvView(context);
                break;
        }
        return mTvView;
    }

    public static ITvView create(Context context, String TYPE){
        ITvView mITvView = null;
        switch (TYPE) {
            case "阿里版":
            case "酷炫版":
            case "炫酷版":
            case "flywithme":
            default:
                mITvView = new SimpleTvView(context);
                break;
        }
        return mITvView;
    }
}
