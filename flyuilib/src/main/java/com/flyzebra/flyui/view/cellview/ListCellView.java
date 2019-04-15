package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.module.RecycleViewDivider;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Author FlyZebra
 * 2019/4/12 16:13
 * Describ:
 **/
public class ListCellView extends RecyclerView implements ICell, IAction {
    private CellBean mCellBean;
    private List<Map<String, Object>> mList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private FlyAdapter adapter;
    private String playItem;

    public ListCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
    }

    @Override
    public void upData(CellBean cellBean) {
        FlyLog.d("ListCellView x=%d,y=%d", cellBean.x, cellBean.y);
        mCellBean = cellBean;
        adapter = new FlyAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(linearLayoutManager);
        addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, 0xFFFFFFFF));
        setAdapter(adapter);

        try {
            setBackgroundColor(Color.parseColor(mCellBean.backcolor));
        } catch (Exception e) {
            FlyLog.e("error! parseColor exception!" + e.toString());
        }
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

    class FlyAdapter extends RecyclerView.Adapter<FlyAdapter.ViewHolder> {
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView text1;

            ViewHolder(View itemView) {
                super(itemView);
                text1 = itemView.findViewById(android.R.id.text1);
            }
        }

        FlyAdapter() {
        }

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView view = new TextView(getContext());
            view.setId(android.R.id.text1);
            view.setTextColor(0xFF0000FF);
            view.setSingleLine();
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, mCellBean.textSize);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50);
            view.setLayoutParams(lp);
            view.setGravity(Gravity.START | Gravity.CENTER);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Map<String, Object> map = mList.get(position);
            String name = map.get("name") + "";
            String url = map.get("url") + "";
            holder.text1.setText(name);
            holder.text1.setTextColor(url.equals(playItem) ? 0xFF00FF00 : 0xFF00FFFF);
        }

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void refresh() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyAction.register(this);
        onAction(ActionKey.MEDIA_PLAYLIST);
        onAction(ActionKey.MEDIA_URL);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        Object obj = FlyAction.getValue(key);
        switch (key) {
            case ActionKey.MEDIA_PLAYLIST:
                if (obj instanceof List) {
                    mList.clear();
                    try {
                        mList.addAll((Collection<? extends Map<String, Object>>) obj);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                    refresh();
                }
                break;
            case ActionKey.MEDIA_URL:
                playItem = obj + "";
                for (int i = 0; i < mList.size(); i++) {
                    if (playItem.equals(mList.get(i).get("url"))) {
                        getLayoutManager().scrollToPosition(i);
                        break;
                    }
                }
                refresh();
                break;
        }
        return false;
    }

}
