package com.flyzebra.flyui.view.base;

import android.text.TextUtils;
import android.view.View;

import com.flyzebra.flyui.bean.RecvBean;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.event.IFlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Author FlyZebra
 * 2019/5/22 14:26
 * Describ:
 **/
public class BaseViewFunc {
    public static void sendRecvEvent(RecvBean recv, IFlyEvent flyEvent) {
        if (recv != null && !TextUtils.isEmpty(recv.recvId)) {
            flyEvent.recvEvent(ByteUtil.hexString2Bytes(recv.recvId));
        }
    }

    public static void handVisible(View view, byte[] key, RecvBean recv) {
        if (recv != null && !TextUtils.isEmpty(recv.recvId) && recv.recvId.equals(ByteUtil.bytes2HexString(key))) {
            Object obj = FlyEvent.getValue(key);
            if (!TextUtils.isEmpty(recv.disVisibleContent)) {
                String str = null;
                if (obj instanceof byte[]) {
                    str = ByteUtil.bytes2HexString((byte[]) obj);
                } else if (obj instanceof String) {
                    str = (String) obj;
                }
                if (TextUtils.isEmpty(str)) {
                    view.setVisibility(GONE);
                } else {
                    if (recv.disVisibleContent.contains(str)) {
                        view.setVisibility(GONE);
                    } else {
                        view.setVisibility(VISIBLE);
                    }
                }
            } else if (!TextUtils.isEmpty(recv.visibleContent)) {
                String str = null;
                if (obj instanceof byte[]) {
                    str = ByteUtil.bytes2HexString((byte[]) obj);
                } else if (obj instanceof String) {
                    str = (String) obj;
                }
                if (TextUtils.isEmpty(str)) {
                    view.setVisibility(GONE);
                } else {
                    if (recv.visibleContent.contains(str)) {
                        view.setVisibility(VISIBLE);
                    } else {
                        view.setVisibility(GONE);
                    }
                }
            }
        }
    }
}
