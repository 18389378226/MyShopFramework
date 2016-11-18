package com.chensen.myshopframework.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chensen.myshopframework.common.utils.SharePreferenceUtil;


/**
 * author：chensen on 2016/11/16 15:45
 * desc：
 */

public class BaseActivity extends AppCompatActivity {
    protected   Context mContext;
    protected SharePreferenceUtil sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        sp = new SharePreferenceUtil(mContext);
    }
}
