package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.config.ActionKey;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;

import java.util.Locale;

import static android.graphics.drawable.ClipDrawable.HORIZONTAL;

/**
 * Author FlyZebra
 * 2019/4/11 13:32
 * Describ:
 **/
public class SeekbarCellView extends FrameLayout implements ICell, IAction, SeekBar.OnSeekBarChangeListener {
    private CellBean mCellBean;
    private SeekBar seekBar;

    private Drawable draw1 = null;
    private Drawable draw2 = null;
    private Drawable draw3 = null;
    private TextCellView startTV;
    private TextCellView endTV;

    public SeekbarCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
        FlyLog.d("seekbar");
        setClipChildren(false);
        seekBar = new SeekBar(context);
        seekBar.setVisibility(GONE);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(seekBar, lp);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            seekBar.setSplitTrack(false);
        }

        seekBar.setOnSeekBarChangeListener(this);

    }


    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean.subCells != null
                && mCellBean.subCells.size() == 4
                && mCellBean.subCells.get(2).celltype == CellType.TYPE_TEXT
                && mCellBean.subCells.get(3).celltype == CellType.TYPE_TEXT) {
            CellBean cell1 = mCellBean.subCells.get(0);
            CellBean cell2 = mCellBean.subCells.get(1);
            CellBean cell3 = mCellBean.subCells.get(2);
            CellBean cell4 = mCellBean.subCells.get(3);

            Glide.with(getContext()).load(cell1.imageurl1).into(new SimpleTarget<GlideDrawable>() {
                @Override
                public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                    draw1 = glideDrawable;
                    loadBitmapFinish();
                }
            });

            Glide.with(getContext()).load(cell2.imageurl1).into(new SimpleTarget<GlideDrawable>() {
                @Override
                public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                    draw2 = glideDrawable;
                    loadBitmapFinish();
                }
            });

            Glide.with(getContext()).load(cell2.imageurl2).into(new SimpleTarget<GlideDrawable>() {
                @Override
                public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                    draw3 = glideDrawable;
                    loadBitmapFinish();
                }
            });

            startTV = (TextCellView) CellViewFactory.createView(getContext(), cell3);
            LayoutParams lp1 = new LayoutParams(cell3.width, cell3.height);
            lp1.setMarginStart(0);
            addView(startTV, lp1);
            startTV.upData(cell3);

            endTV = (TextCellView) CellViewFactory.createView(getContext(), cell4);
            LayoutParams lp2 = new LayoutParams(cell4.width, cell4.height);
            lp2.setMarginStart(mCellBean.width - cell4.width);
            addView(endTV, lp2);
            endTV.upData(cell4);

            LayoutParams slp = (LayoutParams) seekBar.getLayoutParams();
            slp.setMarginStart(cell3.width);
            slp.setMarginEnd(cell4.width);
            slp.topMargin = (mCellBean.height - cell2.height) / 2;
            slp.bottomMargin = (mCellBean.height - cell2.height) / 2;
            seekBar.setLayoutParams(slp);
        } else {
            seekBar.setVisibility(VISIBLE);
        }

        onAction(ActionKey.MEDIA_TIME);

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
            seekBar.setVisibility(VISIBLE);
        }
    }

    @Override
    public void doEvent() {

    }

    @Override
    public void bindMirrorView(MirrorView mirrorView) {

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
            case ActionKey.MEDIA_TIME:
                if (obj instanceof long[]) {
                    long[] intarr = (long[]) obj;
                    if (intarr.length == 2) {
                        seekBar.setProgress((int) intarr[0]);
                        seekBar.setMax((int) intarr[1]);

                        if (startTV != null) {
                            startTV.setText(generateTime(intarr[0]));
                        }
                        if (endTV != null) {
                            endTV.setText(generateTime(intarr[1]));
                        }
                    }
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
        return hours > 0 ? String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds) : String.format(Locale.US, "%02d:%02d", minutes, seconds);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        FlyAction.notifyAction(ActionKey.MEDIA_SEEK, seekBar.getProgress());
    }
}
