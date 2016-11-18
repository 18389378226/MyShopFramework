package com.chensen.myshopframework.common.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.chensen.myshopframework.common.utils.SharePreferenceUtil;

/**
 * author：chensen on 2016/11/17 15:17
 * desc：
 */
@SuppressLint("ValidFragment")
public class BaseFragment extends Fragment {
    protected Context mContext;
    protected SharePreferenceUtil sp;


    public BaseFragment(Context mContext) {
        this.mContext = mContext;
        sp = new SharePreferenceUtil(mContext);
    }


}
