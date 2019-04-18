package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.module.RecycleViewDivider;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
    private String itemKey;
    private Map<String,String> resurl = new HashMap<>();

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
        for(CellBean resCellBen:mCellBean.subCells){
            if(resCellBen.celltype==CellType.TYPE_IMAGE_RES){
                resurl.put(resCellBen.resId,resCellBen.imageurl1);
            }
        }
        int num = mCellBean.width / mCellBean.subCells.get(0).width;
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
            setBackgroundColor(Color.parseColor(mCellBean.backcolor));
        } catch (Exception e) {
            FlyLog.d("error! parseColor exception!" + e.toString());
        }

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int pos = (int) view.getTag();
                try {
                    FlyAction.notifyAction(mCellBean.sendAction, mList.get(pos).get(mCellBean.subCells.get(0).recvAction));
                } catch (Exception e) {
                    FlyLog.e(e.toString());
                }
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
        if (mCellBean.subCells != null && mCellBean.subCells.size() > 0) {
            obj = FlyAction.getValue(mCellBean.subCells.get(0).recvAction);
            if (obj instanceof String) {
                itemKey = (String) obj;
                for (int i = 0; i < mList.size(); i++) {
                    if (itemKey.equals(mList.get(i).get(mCellBean.subCells.get(0).recvAction))) {
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
                        if (textView != null) {
                            texts.put(cellBean.recvAction, textView);
                        } else {
                            FlyLog.e("find by id empty");
                        }
                    }
                }
                for (CellBean cellBean : mCellBean.subCells) {
                    if ((cellBean.celltype == CellType.TYPE_IMAGE || cellBean.celltype == CellType.TYPE_ANIMTOR) && cellBean.recvAction > 0) {
                        ImageView imageView = itemView.findViewById(cellBean.recvAction);
                        if (imageView != null) {
                            images.put(cellBean.recvAction, imageView);
                        } else {
                            FlyLog.e("find by id empty");
                        }
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
                    TextView textView = (TextView) CellViewFactory.createView(getContext(), cellBean);
                    ((ICell) textView).upData(cellBean);
                    textView.setId(cellBean.recvAction);
                    textView.setPadding(0, 0, 0, 0);
                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
                    rootView.addView(textView, lp);
                } else if (cellBean.celltype == CellType.TYPE_IMAGE && cellBean.recvAction > 0) {
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
                    ImageView imageView = (ImageView) CellViewFactory.createView(getContext(), cellBean);
                    ((ICell) imageView).upData(cellBean);
                    imageView.setId(cellBean.recvAction);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setPadding(0, 0, 0, 0);
                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
                    rootView.addView(imageView, lp);
                }
            }
            return new ViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Map<Integer, Object> map = mList.get(position);
            Object key =map.get(mCellBean.subCells.get(0).recvAction);
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v);
                    }
                }
            });
            try{
                holder.itemView.setEnabled(!key.equals(ListCellView.this.itemKey));
            }catch (Exception e){
                FlyLog.e(e.toString());
            }
            for (CellBean cellBean : mCellBean.subCells) {
                if (cellBean.celltype == CellType.TYPE_TEXT && cellBean.recvAction > 0) {
                    TextView textView = holder.texts.get(cellBean.recvAction);
                    try {
                        textView.setTextColor(key.equals(ListCellView.this.itemKey) ? ThemeBean.filterColor : ThemeBean.normalColor);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                    String text = map.get(cellBean.recvAction) + "";
                    textView.setText(text);
                }
                if (cellBean.celltype == CellType.TYPE_IMAGE && cellBean.recvAction > 0) {
                    final ImageView imageView = holder.images.get(cellBean.recvAction);
                    try {
                        Object obj = mList.get(position).get(cellBean.recvAction);
                        if(obj instanceof String) {
                            String imgurl = UpdataVersion.getNativeFilePath(resurl.get(obj));
                            Glide.with(getContext()).load(imgurl).asBitmap().into(imageView);
                        }else if(obj instanceof Drawable){
                            imageView.setImageDrawable((Drawable) obj);
                        }
                    }catch (Exception e){
                        FlyLog.e(e.toString());
                    }
                    try {
                        imageView.setColorFilter(key.equals(ListCellView.this.itemKey) ? ThemeBean.filterColor : ThemeBean.normalColor);
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
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
        if (key == mCellBean.recvAction) {
            if (obj instanceof List) {
                mList.clear();
                try {
                    mList.addAll((Collection<? extends Map<Integer, Object>>) obj);
                } catch (Exception e) {
                    FlyLog.e(e.toString());
                }
                refresh();
            }
        }

        if (mCellBean.subCells != null && mCellBean.subCells.size() > 0 && key == mCellBean.subCells.get(0).recvAction) {
            obj = FlyAction.getValue(mCellBean.subCells.get(0).recvAction);
            if (obj instanceof String) {
                itemKey = (String) obj;
                for (int i = 0; i < mList.size(); i++) {
                    if (itemKey.equals(mList.get(i).get(mCellBean.subCells.get(0).recvAction))) {
                        getLayoutManager().scrollToPosition(i);
                        break;
                    }
                }
                refresh();
            }
        }
        return false;
    }

}
