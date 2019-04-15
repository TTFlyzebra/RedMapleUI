package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.view.customview.FlyTextView;
import com.flyzebra.flyui.view.customview.MirrorView;

/**
 * Author FlyZebra
 * 2019/4/3 16:22
 * Describ:
 **/
public class TextCellView extends FlyTextView implements ICell, IAction {
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
        setPadding(mCellBean.mLeft,mCellBean.mTop,mCellBean.mRight,mCellBean.mBottom);
        setGravity(mCellBean.getGravity());
        setSingleLine();
    }

    @Override
    public void upView() {
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
        onAction(mCellBean.recvAction);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        if (key == mCellBean.recvAction) {
            Object obj = FlyAction.getValue(mCellBean.recvAction);
            if(obj instanceof String){
                setText((String) obj);
            }
        }
        return false;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text == null) {
            text = "";
        }
        super.setText(text, type);
    }

}
