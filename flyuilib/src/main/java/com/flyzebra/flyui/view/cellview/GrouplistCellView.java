package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.ArrayMap;
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
import java.util.concurrent.atomic.AtomicInteger;


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
    private ArrayMap<String, Integer> mResUrls = new ArrayMap<>();
    private ArrayMap<Integer, Drawable> mAllDrawable = new ArrayMap<>();
    private int maxColumn = 1;
    private Map<Integer, Object> mSelectMap = null;

    private List<List<CellBean>> groupSubList = new ArrayList<>();
    private List<ItemBean> itemBeans = new ArrayList<>();
    private AtomicInteger meLoading = new AtomicInteger(0);

    public GrouplistCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
    }

    @Override
    public void upData(CellBean mCellBean) {
        FlyLog.d("ListCellView x=%d,y=%d", mCellBean.x, mCellBean.y);
        this.mCellBean = mCellBean;

        List<CellBean> tempList = null;
        groupSubList.clear();
        itemBeans.clear();
        for (CellBean subcell : mCellBean.subCells) {
            if (subcell.celltype == CellType.TYPE_PAGE) {
                tempList = new ArrayList<>();
                tempList.add(subcell);
                groupSubList.add(tempList);
                ItemBean itemBean = new ItemBean();
                itemBean.groupNum = mCellBean.width / subcell.width;
                itemBean.cellBean = subcell;
                itemBeans.add(itemBean);
                maxColumn = Math.max(maxColumn, itemBean.groupNum);
            } else if (subcell.celltype == CellType.TYPE_IMAGE_RES) {
                mResUrls.put(subcell.resId, subcell.cellId);
            } else {
                if (tempList != null) {
                    tempList.add(subcell);
                }
            }

            loadImageUrl(subcell.imageurl1, subcell.cellId);
            loadImageUrl(subcell.imageurl2, subcell.cellId);
        }

        checkLoadingFinish();
    }

    private void loadImageUrl(String imageurl, final int key) {
        if (TextUtils.isEmpty(imageurl)) return;
        meLoading.incrementAndGet();
        Glide.with(getContext())
                .asDrawable()
                .load(UpdataVersion.getNativeFilePath(imageurl))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        meLoading.decrementAndGet();
                        checkLoadingFinish();
                    }

                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        mAllDrawable.put(key, resource);
                        meLoading.decrementAndGet();
                        checkLoadingFinish();
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    public void checkLoadingFinish() {
        if (meLoading.get() <= 0) {
            upView();
        }
    }

    public void upView() {
        FlyLog.d("upView");
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

        scrollToCurrent();
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
            return (int) mShowList.get(position).get(GROUP_ORDER);
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            FrameLayout rootView = new FrameLayout(getContext());
            if (groupSubList.size() < 2) {
                bindChildView(rootView, mCellBean.subCells);
            } else {
                if (viewType >= 0 && viewType < groupSubList.size()) {
                    bindChildView(rootView, groupSubList.get(viewType));
                } else {
                    bindChildView(rootView, mCellBean.subCells);
                }
            }
            return new ViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            Map<Integer, Object> map = mShowList.get(position);
            int type = (int) map.get(GROUP_ORDER);
            boolean isSelect = false;
            Object objselect = map.get(IS_SELECT);
            if (objselect instanceof Boolean) {
                isSelect = (boolean) objselect;
            }
            holder.itemView.setTag(position);
            {
                Drawable Drawable = getDrawableById(itemBeans.get(type).cellBean.cellId);
                if (Drawable != null) {
                    holder.itemView.setBackground(Drawable);
                }
            }
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v);
                    }
                    try {
                        int type = (int) mShowList.get(pos).get(GROUP_ORDER);
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
                            FlyAction.notifyAction(itemBean.cellBean.sendAction, mShowList.get(pos).get(itemBean.cellBean.recvAction));
                        }
                    } catch (Exception e) {
                        FlyLog.e(e.toString());
                    }
                }
            });
            if (type != 0) {
                holder.itemView.setEnabled(!isSelect);
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
                                case RES_URL:
                                    try {
                                        Object obj = mShowList.get(position).get(RES_URL);
                                        if (obj instanceof String) {
                                            int cellId = mResUrls.get(obj);
                                            FlyLog.d("res image string=%s,cellId=%d,imageView=" + imageView, obj, cellId);
                                            Drawable Drawable1 = mAllDrawable.get(cellId);
                                            imageView.setImageDrawable(Drawable1);
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
                                case VIDEO_URL:
                                    final Object videoUrl = mShowList.get(position).get(VIDEO_URL);
                                    FlyLog.d("video url=" + videoUrl);
                                    Drawable drawable1 = mAllDrawable.get(cellBean.cellId);
                                    imageView.setImageDrawable(drawable1);
                                    if (videoUrl instanceof String) {
                                        Glide.with(imageView)
                                                .load((String) videoUrl)
                                                .centerInside()
                                                .into(imageView);
                                    }
                                    break;
                                case IMAGE_URL:
                                    final Object imageUrl = mShowList.get(position).get(IMAGE_URL);
                                    FlyLog.d("video url=" + imageUrl);
                                    Drawable drawable2 = mAllDrawable.get(cellBean.cellId);
                                    imageView.setImageDrawable(drawable2);
                                    if (imageUrl instanceof String) {
                                        Glide.with(imageView)
                                                .load((String) imageUrl)
                                                .centerInside()
                                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                                .into(imageView);
                                    }
                                    break;
                                case MUSIC_URL:
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
                    int type = (int) mShowList.get(position).get(GROUP_ORDER);
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

    private Drawable getDrawableById(int cellId) {
        return mAllDrawable.isEmpty() ? null : mAllDrawable.get(cellId);
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
                flag = map.equals(mSelectMap);
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
        scrollToCurrent();
        return false;
    }

    private void scrollToCurrent() {
        if (mCellBean == null || mCellBean.subCells == null || mCellBean.subCells.isEmpty() || mAllList == null || mAllList.isEmpty())
            return;
        int key = mCellBean.subCells.get(0).recvAction;
        Object obj = FlyAction.getValue(key);
        if (!(obj instanceof String)) return;
        itemKey = (String) obj;
        int num = 0;
        int type = 0;
        for (int i = mAllList.size() - 1; i >= 0; i--) {
            if (itemKey.equals(mAllList.get(i).get(key))) {
                mAllList.get(i).put(IS_SELECT, true);
                num = i - 1;
                type = (int) mAllList.get(i).get(GROUP_ORDER);
            } else {
                mAllList.get(i).put(IS_SELECT, false);
            }
        }

        for (int j = num; j >= 0; j--) {
            if (type != (int) mAllList.get(j).get(GROUP_ORDER)) {
                mAllList.get(j).put(IS_SELECT, true);
                break;
            }
        }

        if (mShowList == null || mShowList.isEmpty()) return;
        for (int i = mShowList.size() - 1; i >= 0; i--) {
            if ((boolean) mShowList.get(i).get(IS_SELECT)) {
                getLayoutManager().scrollToPosition(i);
                break;
            }
        }
        FlyLog.d("refresh 2");
        refresh();
    }

    class ItemBean {
        public int groupNum;
        public CellBean cellBean;

        public ItemBean() {

        }
    }

}
