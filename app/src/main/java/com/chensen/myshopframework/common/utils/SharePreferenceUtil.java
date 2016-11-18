package com.chensen.myshopframework.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharePreferenceUtil(Context context) {
        sp = context.getSharedPreferences("myshop", context.MODE_PRIVATE);
        editor = sp.edit();

    }

    public void clearData() {
        editor.clear();
        editor.commit();
    }

    public void setIsFirst(boolean isFirst) {
        editor.putBoolean("isFirst", isFirst);
        editor.commit();
    }

    public boolean isFirst() {
       return sp.getBoolean("isFirst", true);
    }


}
