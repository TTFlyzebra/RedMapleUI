package com.flyzebra.flyui.view.base;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

import com.flyzebra.flyui.bean.TextBean;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.FlyTextView;

/**
 * Author FlyZebra
 * 2019/5/20 16:08
 * Describ:
 **/
public class BaseTextBeanView extends FlyTextView implements IFlyEvent {
    private TextBean textBean;

    public BaseTextBeanView(Context context) {
        super(context);
    }

    @Override
    protected void onAttachedToWindow() {
        FlyLog.v("onAttachedToWindow");
        super.onAttachedToWindow();
        FlyEvent.register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyLog.v("onDetachedFromWindow");
        FlyEvent.unregister(this);
        super.onDetachedFromWindow();
    }

    public void setTextBean(TextBean textBean) {
        this.textBean = textBean;
        if (textBean == null) return;
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
            FlyLog.d("Set text="+textBean.text.getText());
        }
        if (textBean.recv == null || textBean.recv.recvId == null) {
            return;
        }
        Object obj = FlyEvent.getValue(textBean.recv.recvId);
        if(obj instanceof String){
            FlyLog.d("Set recv text="+obj);
            setText((String) obj);
        }
    }

    @Override
    public boolean recvEvent(byte[] key) {
        if (textBean == null || textBean.recv == null || textBean.recv.recvId == null) {
            return false;
        }
        if (!textBean.recv.recvId.equals(ByteUtil.bytes2HexString(key))) {
            return false;
        }
        Object obj = FlyEvent.getValue(key);
        if(obj instanceof String){
            FlyLog.d("Set recv text="+obj);
            setText((String) obj);
        }
        return false;
    }
}
