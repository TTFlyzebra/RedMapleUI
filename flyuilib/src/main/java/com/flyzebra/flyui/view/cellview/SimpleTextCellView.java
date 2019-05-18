package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewGroup;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.TextBean;
import com.flyzebra.flyui.view.customview.FlyTextView;

/**
 * Author FlyZebra
 * 2019/4/3 16:22
 * Describ:
 **/
public class SimpleTextCellView extends FlyTextView implements ICell {
    public CellBean mCellBean;

    public SimpleTextCellView(Context context) {
        super(context);
    }

    @Override
    public void initView(Context context) {

    }

    @Override
    public void refreshView(CellBean cellBean) {

    }

    @Override
    public void setCellBean(CellBean cellBean) {
        this.mCellBean = cellBean;
        if(mCellBean.texts==null||mCellBean.texts.isEmpty()) return;
        TextBean textBean = mCellBean.texts.get(0);
        try {
            setTextColor(Color.parseColor(textBean.textColor));
        } catch (Exception e) {
            setTextColor(0xffffffff);
        }
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textBean.textSize);
        setPadding(textBean.left, textBean.top, textBean.right, textBean.bottom);
        if(textBean.textLines==0){
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
            setMarqueeRepeatLimit(1);
            setSingleLine(true);
        }else{
            setMaxLines(textBean.textLines);
            setEllipsize(TextUtils.TruncateAt.END);
        }
        setText(textBean.text.getText());
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return true;
    }

    @Override
    public void loadingRes(CellBean cellBean) {
    }

    @Override
    public void onClick() {
    }

    @Override
    public void bindMirrorView(ViewGroup viewGroup, ViewGroup.LayoutParams lpMirror) {
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text == null) {
            text = "";
        }
        super.setText(text, type);
    }

}
