package com.chensen.myshopframework.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.chensen.myshopframework.R;


/**
 * author：chensen on 2016/8/24 11:30
 * desc： 引导页的适配器
 */
public class AdapterGuide extends PagerAdapter {
    private Context mContext;
    private int[] image;


    public AdapterGuide(Context context, int[] image) {
        this.image = image;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.item_guide, null);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
