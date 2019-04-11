package com.flyzebra.flyui.view.cellview;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import com.flyzebra.flyui.ActionKey;
import com.flyzebra.flyui.IAction;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.module.FlyAction;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.view.customview.MirrorView;

import java.util.Locale;

/**
 * Author FlyZebra
 * 2019/4/11 13:32
 * Describ:
 **/
public class SeekbarCellView extends FrameLayout implements ICell, IAction {
    private CellBean mCellBean;
    private SeekBar seekBar;
    private TextCellView startTV, endTV;

    public SeekbarCellView(Context context) {
        super(context);
        initView(context);
    }

    @Override
    public void initView(Context context) {
        FlyLog.d("seekbar");
        seekBar = new SeekBar(context);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(seekBar, lp);
    }

    @Override
    public void upData(CellBean cellBean) {
        this.mCellBean = cellBean;
        if (mCellBean.subCells != null && mCellBean.subCells.size() >= 5) {
            CellBean startCell = mCellBean.subCells.get(3);
            CellBean endCell = mCellBean.subCells.get(4);
            if (startCell.celltype == CellType.TYPE_TEXT) {
                startTV = (TextCellView) CellViewFactory.createView(getContext(), startCell);
                LayoutParams lp1 = new LayoutParams(startCell.width, startCell.height);
                lp1.setMarginStart(0);
                addView(startTV, lp1);
                startTV.setGravity(Gravity.CENTER);
            }
            if (endCell.celltype == CellType.TYPE_TEXT) {
                endTV = (TextCellView) CellViewFactory.createView(getContext(), endCell);
                LayoutParams lp2 = new LayoutParams(endCell.width, endCell.height);
                lp2.setMarginStart(mCellBean.width - endCell.width);
                addView(endTV, lp2);
                endTV.setGravity(Gravity.CENTER);
            }

            LayoutParams slp = (LayoutParams) seekBar.getLayoutParams();
            slp.setMarginStart(startCell.width);
            slp.setMarginEnd(endCell.width);
            seekBar.setLayoutParams(slp);
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

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyAction.register(this, mCellBean.recvAction);
    }

    @Override
    protected void onDetachedFromWindow() {
        FlyAction.unregister(this);
        super.onDetachedFromWindow();
    }

    @Override
    public void onAction(int key, Object obj) {
        if (key == ActionKey.MEDIA_TIME) {
            FlyLog.d("key=%d,obj=" + obj, key);
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
        }
    }

    private String generateTime(long time) {
        time = Math.min(Math.max(time, 0), 359999000);
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return hours > 0 ? String.format(Locale.US,"%02d:%02d:%02d", hours, minutes, seconds) : String.format(Locale.US,"%02d:%02d", minutes, seconds);
    }
}
