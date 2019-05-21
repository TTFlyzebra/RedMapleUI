package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.event.FlyEvent;
import com.flyzebra.flyui.utils.ByteUtil;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.base.BaseLayoutCellView;

import java.util.Locale;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;

/**
 * Author FlyZebra
 * 2019/4/11 13:32
 * Describ:
 **/
public class SeekbarCellView extends BaseLayoutCellView implements SeekBar.OnSeekBarChangeListener {
    private SeekBar seekBar;
    private Drawable draw1 = null;
    private Drawable draw2 = null;
    private Drawable draw3 = null;

    public SeekbarCellView(Context context) {
        super(context);
    }

    @Override
    public boolean verify(CellBean cellBean) {
        return true;
    }

    @Override
    public void initView(Context context) {
        FlyLog.d("seekbar");
//        setClipChildren(false);
        seekBar = new SeekBar(context);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(seekBar, lp);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            seekBar.setSplitTrack(false);
        }
        seekBar.setOnSeekBarChangeListener(this);
    }


    @Override
    public void loadingRes(CellBean cellBean) {
        Glide.with(getContext()).load(mCellBean.images.get(0).url).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                draw1 = resource;
                loadBitmapFinish();
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });
        Glide.with(getContext()).load(mCellBean.images.get(1).url).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                draw2 = resource;
                loadBitmapFinish();
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }

        });
        Glide.with(getContext()).load(mCellBean.images.get(2).url).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                draw3 = resource;
                loadBitmapFinish();
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });

    }

    private void loadBitmapFinish() {
        if (draw1 != null && draw2 != null && draw3 != null) {
            seekBar.setThumb(draw1);
            Drawable[] drawables = new Drawable[3];
            drawables[0] = draw2;
            ClipDrawable clipDrawable = new ClipDrawable(draw2, Gravity.START, HORIZONTAL);
            drawables[1] = clipDrawable;
            clipDrawable = new ClipDrawable(draw3, Gravity.START, HORIZONTAL);
            drawables[2] = clipDrawable;
            LayerDrawable layerDrawable = new LayerDrawable(drawables);
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            seekBar.setProgressDrawable(layerDrawable);
        }
    }


    @Override
    public boolean recvEvent(byte[] key) {
        if (seekBar == null || mCellBean == null) return false;
        switch (ByteUtil.bytes2HexString(key)) {
            case "100226":
                Object obj = FlyEvent.getValue(key);
                if (obj instanceof byte[]) {
                    FlyLog.d("SeekBar recv=%s", ByteUtil.bytes2HexString((byte[]) obj));
                    int c = ByteUtil.bytes2Int((byte[]) obj, 0);
                    int t = ByteUtil.bytes2Int((byte[]) obj, 4);
                    FlyLog.d("SeekBar c=%d,t=%d", c, t);
                    seekBar.setMax(t);
                    seekBar.setProgress(c);
                }
                return false;
            default:
                return false;
        }
    }

    private String generateTime(long time) {
        time = Math.min(Math.max(time, 0), 359999000);
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return hours > 0 ?
                String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds) :
                String.format(Locale.US, "%02d:%02d", minutes, seconds);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
