//package com.flyzebra.flyui.view.cellview;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.bumptech.glide.request.target.CustomTarget;
//import com.bumptech.glide.request.transition.Transition;
//import com.flyzebra.flyui.IAction;
//import com.flyzebra.flyui.bean.CellBean;
//import com.flyzebra.flyui.bean.ThemeBean;
//import com.flyzebra.flyui.chache.UpdataVersion;
//import com.flyzebra.flyui.config.ActionKey;
//import com.flyzebra.flyui.module.FlyAction;
//import com.flyzebra.flyui.module.RecycleViewDivider;
//import com.flyzebra.flyui.utils.FlyLog;
//import com.flyzebra.flyui.view.customview.MarqueeTextView;
//import com.flyzebra.flyui.view.customview.MirrorView;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.Map;
//
//
///**
// * Author FlyZebra
// * 2019/4/12 16:13
// * Describ:
// **/
//public class ListCellView extends RecyclerView implements ICell, IAction, ActionKey {
//    private CellBean mCellBean;
//    private List<Map<Integer, Object>> mList = new ArrayList<>();
//    private OnItemClickListener onItemClickListener;
//    private FlyAdapter adapter;
//    private String itemKey;
//    private Map<String, String> mResUrls = new Hashtable<>();
//    private Map<Integer, Drawable> mDefaultDrawables = new Hashtable<>();
//
//    public ListCellView(Context context) {
//        super(context);
//        initView(context);
//    }
//
//    @Override
//    public void initView(Context context) {
//    }
//
//    @Override
//    public void upData(CellBean cellBean) {
//        FlyLog.d("ListCellView x=%d,y=%d", cellBean.x, cellBean.y);
//        mCellBean = cellBean;
//        for (CellBean resCellBen : mCellBean.subCells) {
//            if (resCellBen.celltype == CellType.TYPE_IMAGE_RES) {
//                mResUrls.put(resCellBen.resId, resCellBen.imageurl1);
//            }
//        }
//
//        for (final CellBean subcell : mCellBean.subCells) {
//            if (subcell.celltype == CellType.TYPE_IMAGE && subcell.recvAction > 0) {
//                Glide.with(getContext()).load(subcell.imageurl2).into(new CustomTarget<Drawable>() {
//                    @Override
//                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
//                        mDefaultDrawables.put(subcell.cellId, resource);
//                        upView();
//                    }
//
//                    @Override
//                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
//                        upView();
//                    }
//
//                    @Override
//                    public void onLoadCleared(@Nullable Drawable placeholder) {
//                    }
//                });
//                break;
//            }
//            upView();
//        }
//    }
//
//    public void upView() {
//        int num = mCellBean.width / mCellBean.subCells.get(0).width;
//        if (num > 1) {
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), num);
//            setLayoutManager(gridLayoutManager);
//        } else {
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//            setLayoutManager(linearLayoutManager);
//            addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, 0x1FFFFFFF));
//        }
//        adapter = new FlyAdapter();
//        setAdapter(adapter);
//
//        try {
//            setBackgroundColor(Color.parseColor(mCellBean.backcolor));
//        } catch (Exception e) {
//            FlyLog.d("error! parseColor exception!" + e.toString());
//        }
//
//        setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view) {
//                int pos = (int) view.getTag();
//                try {
//                    FlyAction.notifyAction(mCellBean.subCells.get(0).sendAction, mList.get(pos).get(mCellBean.subCells.get(0).recvAction));
//                } catch (Exception e) {
//                    FlyLog.e(e.toString());
//                }
//            }
//        });
//
//        Object obj = FlyAction.getValue(mCellBean.recvAction);
//        if (obj instanceof List) {
//            mList.clear();
//            try {
//                mList.addAll((Collection<? extends Map<Integer, Object>>) obj);
//            } catch (Exception e) {
//                FlyLog.e(e.toString());
//            }
//            refresh();
//        }
//        if (mCellBean.subCells != null && mCellBean.subCells.size() > 0) {
//            obj = FlyAction.getValue(mCellBean.subCells.get(0).recvAction);
//            if (obj instanceof String) {
//                itemKey = (String) obj;
//                for (int i = 0; i < mList.size(); i++) {
//                    if (itemKey.equals(mList.get(i).get(mCellBean.subCells.get(0).recvAction))) {
//                        getLayoutManager().scrollToPosition(i);
//                        break;
//                    }
//                }
//                refresh();
//            }
//        }
//    }
//
//    @Override
//    public void doEvent() {
//
//    }
//
//    @Override
//    public void bindMirrorView(MirrorView mirrorView) {
//
//    }
//
//    class FlyAdapter extends RecyclerView.Adapter<FlyAdapter.ViewHolder> {
//        class ViewHolder extends RecyclerView.ViewHolder {
//            Hashtable<Integer, TextView> texts = new Hashtable<>();
//            Hashtable<Integer, ImageView> images = new Hashtable<>();
//
//            ViewHolder(View itemView) {
//                super(itemView);
//                for (CellBean cellBean : mCellBean.subCells) {
//                    if (cellBean.celltype == CellType.TYPE_TEXT) {
//                        TextView textView = itemView.findViewById(cellBean.cellId);
//                        if (textView != null) {
//                            texts.put(cellBean.cellId, textView);
//                        } else {
//                            FlyLog.e("find by id empty");
//                        }
//                    }
//                }
//                for (CellBean cellBean : mCellBean.subCells) {
//                    if (cellBean.celltype == CellType.TYPE_IMAGE) {
//                        ImageView imageView = itemView.findViewById(cellBean.cellId);
//                        if (imageView != null) {
//                            images.put(cellBean.cellId, imageView);
//                        } else {
//                            FlyLog.e("find by id empty");
//                        }
//                    }
//                }
//            }
//        }
//
//        FlyAdapter() {
//        }
//
//        @Override
//        public int getItemCount() {
//            return mList == null ? 0 : mList.size();
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            FrameLayout rootView = new FrameLayout(getContext());
//            for (CellBean cellBean : mCellBean.subCells) {
//                if (cellBean.celltype == CellType.TYPE_PAGE) {
//                    ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(cellBean.width, cellBean.height);
//                    rootView.setLayoutParams(lp);
//                }
//                if (cellBean.celltype == CellType.TYPE_TEXT) {
//                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
//                    TextView textView = (TextView) CellViewFactory.createView(getContext(), cellBean);
//                    ((ICell) textView).upData(cellBean);
//                    textView.setId(cellBean.cellId);
//                    textView.setPadding(0, 0, 0, 0);
//                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
//                    rootView.addView(textView, lp);
//                } else if (cellBean.celltype == CellType.TYPE_IMAGE) {
//                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(cellBean.width, cellBean.height);
//                    ImageView imageView = (ImageView) CellViewFactory.createView(getContext(), cellBean);
//                    ((ICell) imageView).upData(cellBean);
//                    imageView.setId(cellBean.cellId);
//                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                    imageView.setPadding(0, 0, 0, 0);
//                    lp.setMargins(cellBean.mLeft, cellBean.mTop, cellBean.mRight, cellBean.mBottom);
//                    rootView.addView(imageView, lp);
//                }
//            }
//            return new ViewHolder(rootView);
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, final int position) {
//            Map<Integer, Object> map = mList.get(position);
//            Object key = map.get(mCellBean.subCells.get(0).recvAction);
//            boolean isSelect = key != null && key.equals(ListCellView.this.itemKey);
//            holder.itemView.setTag(position);
//            holder.itemView.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (onItemClickListener != null) {
//                        onItemClickListener.onItemClick(v);
//                    }
//                }
//            });
//            try {
//                holder.itemView.setEnabled(!key.equals(ListCellView.this.itemKey));
//            } catch (Exception e) {
//                FlyLog.e(e.toString());
//            }
//            for (final CellBean cellBean : mCellBean.subCells) {
//                if (cellBean.celltype == CellType.TYPE_TEXT) {
//                    TextView textView = holder.texts.get(cellBean.cellId);
//                    if (textView != null) {
//                        try {
//                            textView.setTextColor(isSelect ? ThemeBean.filterColor : ThemeBean.normalColor);
//                            if (textView instanceof MarqueeTextView) {
//                                ((MarqueeTextView) textView).enableMarquee(isSelect);
//                            }
//                        } catch (Exception e) {
//                            FlyLog.e(e.toString());
//                        }
//                        if (cellBean.recvAction > 0) {
//                            String text = map.get(cellBean.recvAction) + "";
//                            textView.setText(text);
//                        } else {
//                            textView.setText(cellBean.textTitle.getText());
//                        }
//                    }
//                } else if (cellBean.celltype == CellType.TYPE_IMAGE) {
//                    final ImageView imageView = holder.images.get(cellBean.cellId);
//                    if (imageView != null) {
//                        if (cellBean.recvAction > 0) {
//                            switch (cellBean.recvAction) {
//                                case ActionKey.RES_URL:
//                                    try {
//                                        Object obj = mList.get(position).get(ActionKey.RES_URL);
//                                        if (obj instanceof String) {
//                                            String resUrl = mResUrls.get(obj);
//                                            FlyLog.d("res image string=%s,url=%s,imageView=" + imageView, obj, resUrl);
//                                            String imgurl = UpdataVersion.getNativeFilePath(mResUrls.get(obj));
//                                            Glide.with(imageView).load(imgurl).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
//                                        } else if (obj instanceof Drawable) {
//                                            FlyLog.d("set drawable");
//                                            imageView.setImageDrawable((Drawable) obj);
//                                        } else {
//                                            Glide.with(imageView).load(cellBean.imageurl1).into(imageView);
//                                        }
//                                    } catch (Exception e) {
//                                        FlyLog.e(e.toString());
//                                    }
//                                    try {
//                                        imageView.setColorFilter(key.equals(ListCellView.this.itemKey) ? ThemeBean.filterColor : ThemeBean.normalColor);
//                                    } catch (Exception e) {
//                                        FlyLog.e(e.toString());
//                                    }
//                                    break;
//                                case ActionKey.VIDEO_URL:
//                                    final Object videoUrl = mList.get(position).get(ActionKey.VIDEO_URL);
//                                    FlyLog.d("video url=" + videoUrl);
//                                    Drawable drawable1 = mDefaultDrawables.get(cellBean.cellId);
//                                    if (videoUrl instanceof String) {
//                                        Glide.with(imageView).load((String) videoUrl).placeholder(drawable1).error(drawable1).into(imageView);
//                                    }
//                                    break;
//                                case ActionKey.IMAGE_URL:
//                                    final Object imageUrl = mList.get(position).get(ActionKey.IMAGE_URL);
//                                    FlyLog.d("video url=" + imageUrl);
//                                    Drawable drawable2 = mDefaultDrawables.get(cellBean.cellId);
//                                    if (imageUrl instanceof String) {
//                                        Glide.with(imageView).load((String) imageUrl).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(drawable2).error(drawable2).into(imageView);
//                                    }
//                                    break;
//                                case ActionKey.MUSIC_URL:
//                                    break;
//                                default:
//                                    break;
//                            }
//                        } else {
//                            Glide.with(getContext()).load(isSelect ? cellBean.imageurl2 : cellBean.imageurl1).into(imageView);
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(View view);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
//
//    private void refresh() {
//        if (adapter != null) {
//            adapter.notifyDataSetChanged();
//        }
//    }
//
//    @Override
//    protected void onAttachedToWindow() {
//        FlyLog.d("onAttachedToWindow");
//        super.onAttachedToWindow();
//        FlyAction.register(this);
//    }
//
//    @Override
//    protected void onDetachedFromWindow() {
//        FlyLog.d("onDetachedFromWindow");
//        FlyAction.unregister(this);
//        super.onDetachedFromWindow();
//    }
//
//    @Override
//    public boolean onAction(int key) {
//        if (mCellBean == null) return false;
//        Object obj = FlyAction.getValue(key);
//        if (key == mCellBean.recvAction) {
//            if (obj instanceof List) {
//                mList.clear();
//                try {
//                    mList.addAll((Collection<? extends Map<Integer, Object>>) obj);
//                } catch (Exception e) {
//                    FlyLog.e(e.toString());
//                }
//                refresh();
//            }
//        }
//
//        if (mCellBean.subCells != null && mCellBean.subCells.size() > 0 && key == mCellBean.subCells.get(0).recvAction) {
//            obj = FlyAction.getValue(mCellBean.subCells.get(0).recvAction);
//            if (obj instanceof String) {
//                itemKey = (String) obj;
//                for (int i = 0; i < mList.size(); i++) {
//                    if (itemKey.equals(mList.get(i).get(mCellBean.subCells.get(0).recvAction))) {
//                        getLayoutManager().scrollToPosition(i);
//                        break;
//                    }
//                }
//                refresh();
//            }
//        }
//        return false;
//    }
//
//}
