package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;

import com.flyzebra.flyui.FlyuiAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.FlyTextView;
import com.flyzebra.flyui.view.customview.MirrorView;

/**
 * Author FlyZebra
 * 2019/4/3 16:22
 * Describ:
 **/
public class TextCellView extends FlyTextView implements ICell, FlyuiAction {
    public CellBean mCellBean;

    public TextCellView(Context context) {
        super(context);
    }

    @Override
    public void initView(Context context) {

    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        try {
            setTextColor(Color.parseColor(cellBean.textColor));
        } catch (Exception e) {
            setTextColor(0xffffffff);
        }
        setTextSize(TypedValue.COMPLEX_UNIT_PX, cellBean.textSize);
        setGravity(Gravity.START | Gravity.CENTER);
        setSingleLine();
    }

    @Override
    public void upView() {
        setText(mCellBean.textTitle.getText());
    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyAction.register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public void onAction(int key, Object obj) {
        FlyLog.d("key=%d,obj=" + obj, key);
        if (key == mCellBean.recvAction) {
            setText("" + obj);
        }
    }
}
