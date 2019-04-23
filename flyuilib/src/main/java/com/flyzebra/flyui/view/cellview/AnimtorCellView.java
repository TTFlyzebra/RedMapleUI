package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.chache.UpdataVersion;
import com.flyzebra.flyui.view.customview.FlyImageView;
import com.flyzebra.flyui.view.customview.MirrorView;

/**
 * Author FlyZebra
 * 2019/4/13 14:35
 * Describ:
 **/
public class AnimtorCellView extends FlyImageView implements ICell {
    private Drawable drawable[];

    public AnimtorCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
        setScaleType(ScaleType.CENTER);
    }

    @Override
    public void upData(CellBean cellBean) {
        drawable = new Drawable[cellBean.subCells.size()];
        for (int i = 0; i < drawable.length; i++) {
            final int num = i;
            String url = UpdataVersion.getNativeFilePath(cellBean.subCells.get(i).imageurl1);
            Glide.with(getContext())
                    .load(url)
                    .override(cellBean.subCells.get(i).width, cellBean.subCells.get(i).height)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(new DrawableImageViewTarget(this){
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            drawable[num] = resource;
                            boolean flag = true;
                            for(Drawable draw:drawable){
                                if(draw==null){
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag){
                                runLoadingFinish();
                            }
                        }
                    });
        }
    }

    private void runLoadingFinish() {
        AnimationDrawable frameAnim =new AnimationDrawable();
        for(Drawable draw:drawable){
            frameAnim.addFrame(draw,100);
        }
        setImageDrawable(frameAnim);
        frameAnim.start();
    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

    }
}
