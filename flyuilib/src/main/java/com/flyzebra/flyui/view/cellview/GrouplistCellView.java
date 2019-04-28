package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.ThemeBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MarqueeTextView;
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
public class GrouplistCellView extends RecyclerView implements ICell, IAction, ActionKey {
    private CellBean mCellBean;
    private List<Map<Integer, Object>> mShowList = new ArrayList<>();
    private List<Map<Integer, Object>> mAllList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private FlyAdapter adapter;
    private String itemKey;
    private Map<String, String> mResUrls = new Hashtable<>();
    private Map<Integer, Drawable> mDefaultDrawables = new Hashtable<>();
    private int maxColumn = 1;
    private Map<Integer, Object> mSelectMap = null;

    private List<List<CellBean>> groupList = new ArrayList<>();
    private List<ItemBean> itemBeans = new ArrayList<>();

    public GrouplistCellView(Context context) {
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
        for (CellBean resCellBen : mCellBean.subCells) {
            if (resCellBen.celltype == CellType.TYPE_IMAGE_RES) {
                mResUrls.put(resCellBen.resId, resCellBen.imageurl1);
            }
        }

        for (final CellBean subcell : mCellBean.subCells) {
            if (subcell.celltype == CellType.TYPE_IMAGE && subcell.recvAction > 0) {
                Glide.with(getContext()).load(subcell.imageurl2).into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        mDefaultDrawables.put(subcell.cellId, resource);
                        upView();
                    }

                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        upView();
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });
                break;
            }
            upView();
        }
    }

    public void upView() {
        List<CellBean> tempList = null;
        groupList.clear();
        itemBeans.clear();
        for (CellBean cellBean : mCellBean.subCells) {
            if (cellBean.celltype == CellType.TYPE_PAGE) {
                tempList = new ArrayList<>();
                groupList.add(tempList);
                ItemBean itemBean = new ItemBean();
                itemBean.groupNum = mCellBean.width / cellBean.width;
                itemBean.recvAction = cellBean.recvAction;
                itemBean.sendAction = cellBean.sendAction;
                itemBeans.add(itemBean);
                maxColumn = Math.max(maxColumn, itemBean.groupNum);
            }
            if (tempList != null) {
                tempList.add(cellBean);
            }
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), maxColumn);
        setLayoutManager(gridLayoutManager);
        adapter = new FlyAdapter();
        setAdapter(adapter);

        try {
            setBackgroundColor(Color.parseColor(mCellBean.backcolor));
        } catch (Exception e) {
            FlyLog.d("error! parseColor exception!" + e.toString());
        }

        Object obj = FlyAction.getValue(mCellBean.recvAction);
        if (obj instanceof List) {
            mAllList.clear();
            try {
                mAllList.addAll((Collection<? extends Map<Integer, Object>>) obj);

            } catch (Exception e) {
                FlyLog.e(e.toString());
            }
            FlyLog.d("refresh 1");
            refresh();
        }
        if (mCellBean.subCells != null && mCellBean.subCells.size() > 0) {
            obj = FlyAction.getValue(mCellBean.subCells.get(0).recvAction);
            if (obj instanceof String) {
                itemKey = (String) obj;
                for (int i = 0; i < mShowList.size(); i++) {
                    if (itemKey.equals(mShowList.get(i).get(mCellBean.subCells.get(0).recvAction))) {
                        getLayoutManager().scrollToPosition(i);
                        break;
                    }
                }
                FlyLog.d("refresh 2");
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

    class FlyAdapter extends Adapter<FlyAdapter.ViewHolder> {
        class ViewHolder extends RecyclerView.ViewHolder {
            Hashtable<Integer, TextView> texts = new Hashtable<>();
            Hashtable<Integer, ImageView> images = new Hashtable<>();

            ViewHolder(View itemView) {
                super(itemView);
                for (CellBean cellBean : mCellBean.subCells) {
                    if (cellBean.celltype == CellType.TYPE_TEXT) {
                        TextView textView = itemView.findViewById(cellBean.cellId);
                        if (textView != null) {
                            texts.put(cellBean.cellId, textView);
                        } else {
                            FlyLog.i("find by id empty");
                        }
                    }
                }
                for (CellBean cellBean : mCellBean.subCells) {
                    if (cellBean.celltype == CellType.TYPE_IMAGE) {
                        ImageView imageView = itemView.findViewById(cellBean.cellId);
                        if (imageView != null) {
                            images.put(cellBean.cellId, imageView);
                        } else {
                            FlyLog.i("find by id empty");
                        }
                    }
                }
            }
        }

        FlyAdapter() {
        }

        @Override
        public int getItemCount() {
            return mShowList == null ? 0 : mShowList.size();
        }

        @Override
        public int getItemViewType(int position) {
            return (int) mShowList.get(position).get(ActionKey.GROUP_ORDER);
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            FrameLayout rootView = new FrameLayout(getContext());
            if (groupList.size() < 2) {
                bindChildView(rootView, mCellBean.subCells);
            } else {
                if (viewType >= 0 && viewType < groupList.size()) {
                    bindChildView(rootView, groupList.get(viewType));
                } else {
                    bindChildView(rootView, mCellBean.subCells);
                }
            }
            return new ViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.itemView.setTag(position);
            Map<Integer, Object> map = mShowList.get(position);
            final boolean isSelect;
            int type = (int) mShowList.get(position).get(ActionKey.GROUP_ORDER);
            if (type == 0) {
                boolean flag = false;
                int start = 0;
                if (start < mShowList.size()) {
                    for (int i = start; i < mShowList.size(); i++) {
                        Object key = mShowList.get(i).get(mCellBean.subCells.get(0).recvAction);
                        if ((int) mShowList.get(i).get(GROUP_ORDER) == 0) {
                            FlyLog.d("Group end position=%d", position);
                            break;
                        }
                        flag = key != null && key.equals(GrouplistCellView.this.itemKey);
                        if (flag) {
                            FlyLog.d("find group position=%d", position);
                            break;
                        }
                    }
                }
                isSelect = flag;
            } else {
                Object key = map.get(mCellBean.subCells.get(0).recvAction);
                isSelect = key != null && key.equals(GrouplistCellView.this.itemKey);
            }
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v);
                    }
                    try {
                        int type = (int) mShowList.get(pos).get(ActionKey.GROUP_ORDER);
                        ItemBean itemBean = itemBeans.get(type);
                        if (type == 0) {
                            if (mSelectMap == null) {
                                mSelectMap = mShowList.get(pos);
                            } else {
                                if (mSelectMap.equals(mShowList.get(pos))) {
                                    mSelectMap = null;
                                } else {
                                    mSelectMap = mShowList.get(pos);
                                }
                            }
                            refresh();
                            //TODO::跳转到合适位置
                        } else {
                            FlyAction.notifyAction(itemBean.sendAction, mShowList.get(pos).get(itemBean.recvAction));
                        }
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }
            });
            try {
                if (type != 0) {
                    holder.itemView.setEnabled(!isSelect);
                }
            } catch (Exception e) {
                FlyLog.e(e.toString());
            }
            for (final CellBean cellBean : mCellBean.subCells) {
                if (cellBean.celltype == CellType.TYPE_TEXT) {
                    TextView textView = holder.texts.get(cellBean.cellId);
                    if (textView != null) {
                        try {
                            textView.setTextColor(isSelect ? ThemeBean.filterColor : ThemeBean.normalColor);
                            if (textView instanceof MarqueeTextView) {
                                ((MarqueeTextView) textView).enableMarquee(isSelect);
                            }
                        } catch (Exception e) {
                            FlyLog.e(e.toString());
                        }
                        if (cellBean.recvAction > 0) {
                            String text = map.get(cellBean.recvAction) + "";
                            textView.setText(text);
                        } else {
                            textView.setText(cellBean.textTitle.getText());
                        }
                    }
                } else if (cellBean.celltype == CellType.TYPE_IMAGE) {
                    final ImageView imageView = holder.images.get(cellBean.cellId);
                    if (imageView != null) {
                        if (cellBean.recvAction > 0) {
                            switch (cellBean.recvAction) {
                                case ActionKey.RES_URL:
                                    try {
                                        Object obj = mShowList.get(position).get(ActionKey.RES_URL);
                                        if (obj instanceof String) {
                                            String resUrl = mResUrls.get(obj);
                                            FlyLog.d("res image string=%s,url=%s,imageView=" + imageView, obj, resUrl);
                                            String imgurl = UpdataVersion.getNativeFilePath(mResUrls.get(obj));
                                            Glide.with(imageView).load(imgurl).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
                                        } else if (obj instanceof Drawable) {
                                            FlyLog.d("set drawable");
                                            imageView.setImageDrawable((Drawable) obj);
                                        } else {
                                            Glide.with(imageView).load(cellBean.imageurl1).into(imageView);
                                        }
                                    } catch (Exception e) {
                                        FlyLog.e(e.toString());
                                    }
                                    try {
                                        imageView.setColorFilter(isSelect ? ThemeBean.filterColor : ThemeBean.normalColor);
                                    } catch (Exception e) {
                                        FlyLog.e(e.toString());
                                    }
                                    break;
                                case ActionKey.VIDEO_URL:
                                    final Object videoUrl = mShowList.get(position).get(ActionKey.VIDEO_URL);
                                    FlyLog.d("video url=" + videoUrl);
                                    Drawable drawable1 = mDefaultDrawables.get(cellBean.cellId);
                                    if (videoUrl instanceof String) {
                                        Glide.with(imageView)
                                                .load((String) videoUrl)
                                                .centerInside()
                                                .placeholder(drawable1)
                                                .error(drawable1)
                                                .into(imageView);
                                    }
                                    break;
                                case ActionKey.IMAGE_URL:
                                    final Object imageUrl = mShowList.get(position).get(ActionKey.IMAGE_URL);
                                    FlyLog.d("video url=" + imageUrl);
                                    Drawable drawable2 = mDefaultDrawables.get(cellBean.cellId);
                                    if (imageUrl instanceof String) {
                                        Glide.with(imageView)
                                                .load((String) imageUrl)
                                                .centerInside()
                                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                                .placeholder(drawable2)
                                                .error(drawable2)
                                                .into(imageView);
                                    }
                                    break;
                                case ActionKey.MUSIC_URL:
                                    Glide.with(getContext())
                                            .load(cellBean.imageurl1)
                                            .centerInside()
                                            .into(imageView);
                                    if (isSelect) {
                                        imageView.setColorFilter(ThemeBean.filterColor);
                                    } else {
                                        imageView.clearColorFilter();
                                    }
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            Glide.with(getContext())
                                    .load(cellBean.imageurl1)
                                    .centerInside()
                                    .into(imageView);
                            if (isSelect) {
                                imageView.setColorFilter(ThemeBean.filterColor);
                            } else {
                                imageView.clearColorFilter();
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = (int) mShowList.get(position).get(ActionKey.GROUP_ORDER);
                    if (type >= 0 && type < itemBeans.size()) {
                        return maxColumn / itemBeans.get(type).groupNum;
                    } else {
                        return maxColumn;
                    }
                }
            });
        }

        private void bindChildView(ViewGroup rootView, List<CellBean> subCells) {
            for (CellBean cellBean : subCells) {
                if (cellBean.celltype == CellType.TYPE_PAGE) {
                    ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(cellBean.width, cellBean.height);
                    rootView.setLayoutParams(lp);
                }
                if (cellBean.celltype == CellType.TYPE_TEXT) {
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
                    TextView textView = (TextView) CellViewFactory.createView(getContext(), cellBean);
                    ((ICell) textView).upData(cellBean);
                    textView.setId(cellBean.cellId);
                    textView.setPadding(0, 0, 0, 0);
                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
                    rootView.addView(textView, lp);
                } else if (cellBean.celltype == CellType.TYPE_IMAGE) {
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
                    ImageView imageView = (ImageView) CellViewFactory.createView(getContext(), cellBean);
                    ((ICell) imageView).upData(cellBean);
                    imageView.setId(cellBean.cellId);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setPadding(0, 0, 0, 0);
                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
                    rootView.addView(imageView, lp);
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
        FlyLog.d("refresh");
        mShowList.clear();
        boolean flag = false;
        for (int i = 0; i < mAllList.size(); i++) {
            Map map = mAllList.get(i);
            if ((int) map.get(GROUP_ORDER) == 0) {
                mShowList.add(map);
                if (mSelectMap != null) {
                    flag = mSelectMap.get(mCellBean.subCells.get(0).recvAction).equals(map.get(mCellBean.subCells.get(0).recvAction));
                } else {
                    flag = false;
                }
            } else {
                if (flag) {
                    mShowList.add(map);
                }
            }
        }
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        FlyLog.d("onAttachedToWindow");
        super.onAttachedToWindow();
        FlyAction.register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyLog.d("onDetachedFromWindow");
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public boolean onAction(int key) {
        if (mCellBean == null) return false;
        Object obj = FlyAction.getValue(key);
        if (key == mCellBean.recvAction) {
            if (obj instanceof List) {
                mAllList.clear();
                try {
                    mAllList.addAll((Collection<? extends Map<Integer, Object>>) obj);
                } catch (Exception e) {
                    FlyLog.e(e.toString());
                }
                FlyLog.d("refresh 3");
                refresh();
            }
        }

        if (mCellBean.subCells != null && mCellBean.subCells.size() > 0 && key == mCellBean.subCells.get(0).recvAction) {
            obj = FlyAction.getValue(mCellBean.subCells.get(0).recvAction);
            if (obj instanceof String) {
                itemKey = (String) obj;
                for (int i = 0; i < mShowList.size(); i++) {
                    if (itemKey.equals(mShowList.get(i).get(mCellBean.subCells.get(0).recvAction))) {
                        getLayoutManager().scrollToPosition(i);
                        break;
                    }
                }
                FlyLog.d("key = %d,refresh 4", key);
                refresh();
            }
        }
        return false;
    }

    class ItemBean {
        public int groupNum;
        public int sendAction;
        public int recvAction;

        public ItemBean() {

        }
    }

}
