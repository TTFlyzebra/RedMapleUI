package com.flyzebra.flyui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.PageBean;
import com.flyzebra.flyui.view.cellview.CellViewFactory;
import com.flyzebra.flyui.view.cellview.ICell;
import com.flyzebra.flyui.view.pageview.SimplePageView;

/**
 * Author FlyZebra
 * 2019/4/16 15:07
 * Describ:
 **/
public class CellFragment extends Fragment {
    public static String CELL = "cellbean";
    private PageBean mPageBean;
    public CellFragment(){
    }

    public static CellFragment newInstance(PageBean cellBean) {
        CellFragment cellFragment = new CellFragment();
        Bundle args = new Bundle();
        args.putParcelable(CELL,cellBean);
        cellFragment.setArguments(args);
        return cellFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        mPageBean = (PageBean) args.get(CELL);
        if(mPageBean !=null){
            SimplePageView simplePageView = new SimplePageView(getActivity());
            simplePageView.setPageBean(mPageBean);
            return simplePageView;
        }else{
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
}
