package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.TextBean;
import com.flyzebra.flyui.view.base.BaseTextCellView;

/**
 * Author FlyZebra
 * 2019/4/3 16:22
 * Describ:
 **/
public class SimpleTextCellView extends BaseTextCellView {

    public SimpleTextCellView(Context context) {
        super(context);
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return !(cellBean == null ||
                cellBean.texts == null ||
                cellBean.texts.isEmpty());
    }

    @Override
    public void initView(Context context) {
        TextBean textBean = mCellBean.texts.get(0);
        try {
            setTextColor(Color.parseColor(textBean.textColor));
        } catch (Exception e) {
            setTextColor(0xffffffff);
        }
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textBean.textSize);
        setGravity(textBean.getGravity());
        if (textBean.textLines <= 0) {
            setLines(1);
        } else {
            setLines(textBean.textLines);
        }
        if (textBean.text != null) {
            setText(textBean.text.getText());
        }
    }

}
