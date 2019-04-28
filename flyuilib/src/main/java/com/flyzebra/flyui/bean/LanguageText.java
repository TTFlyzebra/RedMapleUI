package com.flyzebra.flyui.bean;

import android.text.TextUtils;

import java.util.Locale;

public class LanguageText {
    public String zh;
    public String zh_TW;
    public String zh_HK;
    public String en;
    public String ru;
    public String el;
    public String pl;
    public String tr;
    public String ar;
    public String fa;
    public String ro;
    public String fr;
    public String hu;
    public String it;
    public String th;
    public String de;
    public String uk;
    public String es;
    public String pt;

    @Override
    public String toString() {
        return "Language{" +
                "zh='" + zh + '\'' +
                ", zh_TW='" + zh_TW + '\'' +
                ", zh_HK='" + zh_HK + '\'' +
                ", en='" + en + '\'' +
                ", ru='" + ru + '\'' +
                ", el='" + el + '\'' +
                ", pl='" + pl + '\'' +
                ", tr='" + tr + '\'' +
                ", ar='" + ar + '\'' +
                ", fa='" + fa + '\'' +
                ", ro='" + ro + '\'' +
                ", fr='" + fr + '\'' +
                ", hu='" + hu + '\'' +
                ", it='" + it + '\'' +
                ", th='" + th + '\'' +
                ", de='" + de + '\'' +
                ", uk='" + uk + '\'' +
                ", es='" + es + '\'' +
                ", pt='" + pt + '\'' +
                '}';
    }

    public String getText() {
        String text = "";
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        String type = language + "-" + country;
        type = type.toLowerCase();

        if(type.startsWith("zh-cn")){
            text = zh;
        }else if(type.startsWith("zh-")){
            text = zh_TW;
        }else if(type.startsWith("en")){
            text = en;
        }else if(type.startsWith("ru")){
            text = ru;
        }else if(type.startsWith("el")){
            text = el;
        }else if(type.startsWith("pl")){
            text = pl;
        }else if(type.startsWith("tr")){
            text = tr;
        }else if(type.startsWith("ar")){
            text = ar;
        }else if(type.startsWith("fa")){
            text = fa;
        }else if(type.startsWith("ro")){
            text = ro;
        }else if(type.startsWith("fr")){
            text = fr;
        }else if(type.startsWith("hu")){
            text = hu;
        }else if(type.startsWith("it")){
            text = it;
        }else if(type.startsWith("th")){
            text = th;
        }else if(type.startsWith("de")){
            text = de;
        }else if(type.startsWith("uk")){
            text = uk;
        }else if(type.startsWith("es")){
            text = es;
        }else if(type.startsWith("pt")){
            text = pt;
        }else{
            text = en;
        }

        text =  TextUtils.isEmpty(text)?zh:text;
        text = text.replace("\\n","\n");
        return text;
    }
}
