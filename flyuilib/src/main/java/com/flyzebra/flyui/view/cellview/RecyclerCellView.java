package com.flyzebra.flyui.view.cellview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.RecvBean;
import com.flyzebra.flyui.bean.TextBean;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.module.RecycleViewDivider;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseRecyclerCellView;
import com.flyzebra.flyui.view.pageview.SimplePageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


/**
 * Author FlyZebra
 * 2019/4/12 16:13
 * Describ:
 **/
public class RecyclerCellView extends BaseRecyclerCellView {
    private List<Map<String, Object>> mList = new ArrayList<>();
    private FlyAdapter adapter;
    private String itemKey;

    public RecyclerCellView(Context context) {
        super(context);
    }


    @Override
    public void init(CellBean cellBean) {
        int num = mCellBean.width / mCellBean.pages.get(0).width;
        if (num > 1) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), num);
            setLayoutManager(gridLayoutManager);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            setLayoutManager(linearLayoutManager);
            addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, 0x1FFFFFFF));
        }
        adapter = new FlyAdapter();
        setAdapter(adapter);

        try {
            setBackgroundColor(Color.parseColor(mCellBean.backColor));
        } catch (Exception e) {
            FlyLog.d("error! parseColor exception!" + e.toString());
        }

        recvEvent(ByteUtil.hexString2Bytes(mCellBean.recv.recvId));
        RecvBean recvBean = mCellBean.pages.get(0).recv;
        if (recvBean != null && !TextUtils.isEmpty(recvBean.recvId)) {
            recvEvent(ByteUtil.hexString2Bytes(recvBean.recvId));
        }
    }


    @Override
    public boolean verify(CellBean cellBean) {
        return mCellBean != null && mCellBean.pages != null && !mCellBean.pages.isEmpty();
    }

    @Override
    public void loadingRes(CellBean cellBean) {

    }


    @Override
    public boolean recvEvent(byte[] key) {
        if (mCellBean == null) return false;
        String strkey = ByteUtil.bytes2HexString(key);
        if (TextUtils.isEmpty(strkey)) return false;
        if (mCellBean.recv != null && !TextUtils.isEmpty(mCellBean.recv.recvId)) {
            Object obj = FlyEvent.getValue(key);
            if (strkey.equals(mCellBean.recv.recvId)) {
                if (obj instanceof List) {
                    mList.clear();
                    try {
                        mList.addAll((Collection<? extends Map<String, Object>>) obj);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                    refresh();
                }
            }
        }

        RecvBean recvBean = mCellBean.pages.get(0).recv;
        if (recvBean != null && !TextUtils.isEmpty(recvBean.recvId)) {
            if (strkey.equals(recvBean.recvId)) {
                Object obj = FlyEvent.getValue(recvBean.recvId);
                if (obj instanceof String) {
                    itemKey = (String) obj;
                    for (int i = 0; i < mList.size(); i++) {
                        if (itemKey.equals(mList.get(i).get(recvBean.recvId))) {
                            getLayoutManager().scrollToPosition(i);
                            break;
                        }
                    }
                    refresh();
                }
            }
        }
        return false;
    }


    private void refresh() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }


    class FlyAdapter extends RecyclerView.Adapter<ViewHolder> {

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            SimplePageView simplePageView = new SimplePageView(getContext());
            simplePageView.setPageBean(mCellBean.pages.get(0));
            return new ViewHolder(simplePageView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Object mainKey = mList.get(position).get(mCellBean.pages.get(0).recv.keyId);
            boolean isSelect = mainKey != null && mainKey.equals(RecyclerCellView.this.itemKey);
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String sendKey = mCellBean.pages.get(0).send.eventId;
                        Object sendObj = mList.get((Integer) v.getTag()).get(mCellBean.pages.get(0).recv.keyId);
                        FlyEvent.sendEvent(sendKey, sendObj);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }
            });
            holder.itemView.setEnabled(!isSelect);

            for (CellBean cellBean : mCellBean.pages.get(0).cellList) {
                if (cellBean.texts != null && !cellBean.texts.isEmpty()) {
                    for (TextBean textBean : cellBean.texts) {
                        if (textBean.recv == null || textBean.recv.keyId == null)
                            continue;
                        try {
                            int key = Integer.valueOf(textBean.recv.keyId, 16);
                            TextView textView = holder.texts.get(key);
                            if (textView != null) {
                                textView.setText(mList.get(position).get(textBean.recv.keyId) + "");
                                textView.setSelected(isSelect);
                            } else {
                                FlyLog.e("find by id empty");
                            }
                        } catch (Exception e) {
                            FlyLog.e(e.toString());
                        }
                    }
                }
                if (cellBean.celltype == CellType.TYPE_ANIMTOR) {
                    if (cellBean.recv == null || cellBean.recv.keyId == null)
                        continue;
                    try {
                        int key = Integer.valueOf(cellBean.recv.keyId, 16);
                        AnimtorCellView anim = holder.anims.get(key);
                        if (anim != null) {
                            anim.setSelected(isSelect);
                        } else {
                            FlyLog.e("find by id empty");
                        }
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }

                if (cellBean.celltype == CellType.TYPE_IMAGE_TEXT) {
                    if (cellBean.recv == null || cellBean.recv.keyId == null)
                        continue;
                    try {
                        int key = Integer.valueOf(cellBean.recv.keyId, 16);
                        ImageTextCellView imgtx = holder.imgtxs.get(key);
                        if (imgtx != null) {
                            imgtx.setDrawable(mList.get(position).get(cellBean.recv.keyId) + "");
                            imgtx.setSelected(isSelect);
                        } else {
                            FlyLog.e("find by id empty");
                        }
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }
            }
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Hashtable<Integer, TextView> texts = new Hashtable<>();
        Hashtable<Integer, ImageView> images = new Hashtable<>();
        Hashtable<Integer, AnimtorCellView> anims = new Hashtable<>();
        Hashtable<Integer, ImageTextCellView> imgtxs = new Hashtable<>();

        ViewHolder(View itemView) {
            super(itemView);
            for (CellBean cellBean : mCellBean.pages.get(0).cellList) {
                if (cellBean.texts != null && !cellBean.texts.isEmpty()) {
                    for (TextBean textBean : cellBean.texts) {
                        if (textBean.recv == null || textBean.recv.keyId == null)
                            continue;
                        try {
                            int key = Integer.valueOf(textBean.recv.keyId, 16);
                            TextView textView = itemView.findViewById(key);
                            if (textView != null) {
                                texts.put(key, textView);
                            } else {
                                FlyLog.e("find by id empty");
                            }
                        } catch (Exception e) {
                            FlyLog.e(e.toString());
                        }
                    }
                }
                if (cellBean.celltype == CellType.TYPE_ANIMTOR) {
                    if (cellBean.recv == null || cellBean.recv.keyId == null)
                        continue;
                    try {
                        int key = Integer.valueOf(cellBean.recv.keyId, 16);
                        AnimtorCellView anim = itemView.findViewById(key);
                        if (anim != null) {
                            anims.put(key, anim);
                        } else {
                            FlyLog.e("find by id empty");
                        }
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }

                if (cellBean.celltype == CellType.TYPE_IMAGE_TEXT) {
                    if (cellBean.recv == null || cellBean.recv.keyId == null)
                        continue;
                    try {
                        int key = Integer.valueOf(cellBean.recv.keyId, 16);
                        ImageTextCellView imgtx = itemView.findViewById(key);
                        if (imgtx != null) {
                            imgtxs.put(key, imgtx);
                        } else {
                            FlyLog.e("find by id empty");
                        }
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }
            }


        }
    }


}
