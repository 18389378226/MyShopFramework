package com.chensen.myshopframework.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chensen.myshopframework.R;
import com.chensen.myshopframework.common.base.BaseFragment;

/**
 * author：chensen on 2016/11/17 15:17
 * desc：
 */
@SuppressWarnings("ValidFragment")
public class HomeFragment extends BaseFragment {

    public HomeFragment(Context mContext) {
        super(mContext);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_home, null);
        return view;
    }
}
