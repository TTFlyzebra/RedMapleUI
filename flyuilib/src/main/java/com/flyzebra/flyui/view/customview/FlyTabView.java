package com.flyzebra.flyui.view.customview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyzebra.flyui.R;
import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.utils.FlyLog;
import com.flyzebra.flyui.utils.RtlTools;


public class FlyTabView extends FrameLayout implements View.OnClickListener {
//    private String titles[] = null;
    private TextView textViews[] = null;
    private View focusView = null;
    private int focusPos = 0;
    private Context context;
    private int animDuration = 300;
    private int width = 0;
    private int height = 0;
    private int childWidth = 0;
    private int childHeight = 0;
    private int[][] states = new int[][]{{android.R.attr.state_enabled}, {}};
    private int[] colors = new int[]{0xFFFFFFFF, 0xFF0000FF};
    private ColorStateList colorStateList;
    private OnItemClickListener onItemClickListener;
    private int orientation = LinearLayout.VERTICAL;

    public FlyTabView(Context context) {
        this(context, null);
    }

    public FlyTabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlyTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
//        colors = new int[]{0xFFFFFFFF,0xFF0000FF};
        colorStateList = new ColorStateList(states, colors);
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void setTitles(CellBean mCellBean) {
        removeAllViews();
        if (mCellBean == null || mCellBean.subCells==null ||mCellBean.subCells.isEmpty()) return;
        textViews = new TextView[mCellBean.subCells.size()];
        for (int i = 0; i < textViews.length; i++) {
            CellBean subCell = mCellBean.subCells.get(i);
            LayoutParams lp = new LayoutParams(childWidth, height);
            lp.setMarginStart(i * childWidth);
            textViews[i] = new TextView(context);
            textViews[i].setGravity(Gravity.CENTER);
            textViews[i].setText(subCell.textTitle.getText());
            textViews[i].setTag(i);
            textViews[i].setTextSize(TypedValue.COMPLEX_UNIT_PX,subCell.textSize);
            textViews[i].setOnClickListener(FlyTabView.this);
            textViews[i].setTextColor(colorStateList);
            addView(textViews[i], lp);
        }
        focusView = new View(context);
        addView(focusView);
        switch (orientation) {
            case LinearLayout.HORIZONTAL:
                focusView.setBackgroundResource(R.drawable.bottom_line_blue);
                break;
            case LinearLayout.VERTICAL:
            default:
                focusView.setBackgroundResource(R.drawable.left_line_blue);
                break;
        }
        setSelectItem(0);
        post(new Runnable() {
            @Override
            public void run() {
                width = getMeasuredWidth();
                height = getMeasuredHeight();
                LayoutParams lpbak = (LayoutParams) focusView.getLayoutParams();
                switch (orientation) {
                    case LinearLayout.HORIZONTAL:
                        childWidth = width / textViews.length;
                        for (int i = 0; i < textViews.length; i++) {
                            LayoutParams lp = new LayoutParams(childWidth, height);
                            lp.setMarginStart(i * childWidth);
                            textViews[i].setLayoutParams(lp);
                        }
                        lpbak.width = childWidth;
                        lpbak.height = height - 5;
                        focusView.setLayoutParams(lpbak);
                        break;
                    case LinearLayout.VERTICAL:
                    default:
                        childHeight = height / textViews.length;
                        for (int i = 0; i < textViews.length; i++) {
                            LayoutParams lp = new LayoutParams(width, childHeight);
                            lp.topMargin = i * childHeight;
                            textViews[i].setLayoutParams(lp);
                        }
                        lpbak.width = width;
                        lpbak.height = childHeight;
                        focusView.setLayoutParams(lpbak);
                        break;
                }

                setSelectItem(0);
            }
        });
    }

    @Override
    public void onClick(View v) {
        FlyLog.d("onclick %d", v.getTag());
        focusPos = (int) v.getTag();
        setSelectItem(animDuration);
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(v);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlyLog.d("Tab width =%d", getMeasuredWidth());
    }


    private void setSelectItem(int duration) {
        try {
            if (focusView != null && textViews != null) {
                switch (orientation) {
                    case LinearLayout.HORIZONTAL:
                        int x = childWidth * focusPos;
                        if (RtlTools.isLayoutRtl(this)) {
                            x = -x;
                        }
                        focusView.animate().translationX(x).setDuration(duration).start();
                        for (int i = 0; i < textViews.length; i++) {
                            textViews[i].setEnabled(i != focusPos);
                        }
                        break;
                    case LinearLayout.VERTICAL:
                    default:
                        int y = childHeight * focusPos;
                        focusView.animate().translationY(y).setDuration(duration).start();
                        for (int i = 0; i < textViews.length; i++) {
                            textViews[i].setEnabled(i != focusPos);
                        }
                        break;
                }
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    public void setFocusPos(int pos) {
        FlyLog.d("setFocusPos=%d", pos);
        focusPos = pos;
        setSelectItem(0);
    }

    public void setNewTitles(String[] titles) {
        try {
            if (titles == null || textViews == null || titles.length != textViews.length) return;
            for (int i = 0; i < titles.length; i++) {
                textViews[i].setText(titles[i]);
            }
        } catch (Exception e) {
            FlyLog.e(e.toString());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
