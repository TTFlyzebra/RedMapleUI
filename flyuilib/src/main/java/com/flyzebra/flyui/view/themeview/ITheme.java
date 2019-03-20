package com.flyzebra.flyui.view.themeview;


import com.flyzebra.flyui.bean.CellBean;
import com.flyzebra.flyui.bean.ThemeBean;

public interface ITheme {
    void setData(ThemeBean themeBean);

    void selectPage(int page);

    //TV
    void selectCell(CellBean cell);
}
