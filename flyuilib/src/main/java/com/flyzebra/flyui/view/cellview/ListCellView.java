package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.module.RecycleViewDivider;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;

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
public class ListCellView extends RecyclerView implements ICell, IAction, ActionKey {
    private CellBean mCellBean;
    private List<Map<Integer, Object>> mList = new ArrayList<>();
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
            FlyLog.d("error! parseColor exception!" + e.toString());
        }

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int pos = (int) view.getTag();
                FlyAction.notifyAction(KEY_URL, mList.get(pos).get(MEDIA_URL));
            }
        });

        upView();
    }

    public void upView() {
        Object obj = FlyAction.getValue(mCellBean.recvAction);
        if (obj instanceof List) {
            mList.clear();
            try {
                mList.addAll((Collection<? extends Map<Integer, Object>>) obj);
            } catch (Exception e) {
                FlyLog.e(e.toString());
            }
            refresh();
        }
        if (mCellBean.recvAction == MEDIA_LIST) {
            obj = FlyAction.getValue(MEDIA_URL);
            if (obj instanceof String) {
                playItem = (String) obj;
                for (int i = 0; i < mList.size(); i++) {
                    if (playItem.equals(mList.get(i).get(MEDIA_URL))) {
                        getLayoutManager().scrollToPosition(i);
                        break;
                    }
                }
                refresh();
            }
        }
    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

    }

    class FlyAdapter extends RecyclerView.Adapter<FlyAdapter.ViewHolder> {
        class ViewHolder extends RecyclerView.ViewHolder {
            Hashtable<Integer, TextView> texts = new Hashtable<>();
            Hashtable<Integer, ImageView> images = new Hashtable<>();

            ViewHolder(View itemView) {
                super(itemView);
                for (CellBean cellBean : mCellBean.subCells) {
                    if (cellBean.celltype == CellType.TYPE_TEXT && cellBean.recvAction > 0) {
                        TextView textView = itemView.findViewById(cellBean.recvAction);
                        texts.put(cellBean.recvAction, textView);
                    }
                }
                for (CellBean cellBean : mCellBean.subCells) {
                    if ((cellBean.celltype == CellType.TYPE_IMAGE || cellBean.celltype == CellType.TYPE_ANIMTOR) && cellBean.recvAction > 0) {
                        ImageView imageView = itemView.findViewById(cellBean.recvAction);
                        images.put(cellBean.recvAction, imageView);
                    }
                }
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
            FrameLayout rootView = new FrameLayout(getContext());
            for (CellBean cellBean : mCellBean.subCells) {
                if (cellBean.celltype == CellType.TYPE_PAGE) {
                    ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(cellBean.width, cellBean.height);
                    rootView.setLayoutParams(lp);
                }
                if (cellBean.celltype == CellType.TYPE_TEXT && cellBean.recvAction > 0) {
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
                    TextView textView = new TextView(getContext());
                    textView.setId(cellBean.recvAction);
                    textView.setSingleLine();
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, cellBean.textSize);
                    textView.setGravity(Gravity.START | Gravity.CENTER);
                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
                    rootView.addView(textView, lp);
                }
                if ((cellBean.celltype == CellType.TYPE_IMAGE) && cellBean.recvAction > 0) {
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(cellBean.getImageGravity());
                    imageView.setId(cellBean.recvAction);
                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
                    rootView.addView(imageView, lp);
                }
                if (cellBean.celltype == CellType.TYPE_ANIMTOR) {
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(cellBean.getImageGravity());
                    imageView.setId(cellBean.recvAction);
                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
                    imageView.setVisibility(INVISIBLE);
                    rootView.addView(imageView, lp);
                }
            }
            return new ViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Map<Integer, Object> map = mList.get(position);
            String url = map.get(MEDIA_URL) + "";
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v);
                    }
                }
            });
            for (CellBean cellBean : mCellBean.subCells) {
                if (cellBean.celltype == CellType.TYPE_TEXT && cellBean.recvAction > 0) {
                    TextView textView = holder.texts.get(cellBean.recvAction);
                    try {
                        textView.setTextColor(url.equals(playItem) ? 0xFF00FF00 : 0xFF00FFFF);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                    String text = map.get(cellBean.recvAction) + "";
                    textView.setText(text);
                }
                if (cellBean.celltype == CellType.TYPE_ANIMTOR) {
                    ImageView imageView = holder.images.get(cellBean.recvAction);
                    try {
                        imageView.setVisibility(url.equals(playItem) ? VISIBLE : INVISIBLE);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                    String imgurl = UpdataVersion.getNativeFilePath(cellBean.imageurl1);
                    Glide.with(getContext()).load(imgurl).into(imageView);
//                    Object obj = map.get(cellBean.recvAction);
//                    if(obj instanceof Drawable){
//                        imageView.setImageDrawable((Drawable) obj);
//                    }
                }
            }
        }

    }

    public interface OnItemClickListener {
        void onItemClick(View view);
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
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        if (mCellBean == null) return false;
        Object obj = FlyAction.getValue(key);
        switch (key) {
            case MEDIA_LIST:
                if (obj instanceof List) {
                    mList.clear();
                    try {
                        mList.addAll((Collection<? extends Map<Integer, Object>>) obj);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                    refresh();
                }
                break;
            case MEDIA_URL:
                if(mCellBean.recvAction==MEDIA_LIST) {
                    playItem = obj + "";
                    for (int i = 0; i < mList.size(); i++) {
                        if (playItem.equals(mList.get(i).get(MEDIA_URL))) {
                            getLayoutManager().scrollToPosition(i);
                            break;
                        }
                    }
                    refresh();
                }
                break;
        }
        return false;
    }

}
