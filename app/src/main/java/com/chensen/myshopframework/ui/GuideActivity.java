package com.chensen.myshopframework.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chensen.myshopframework.R;
import com.chensen.myshopframework.adapter.AdapterGuide;
import com.chensen.myshopframework.common.base.BaseActivity;
import com.chensen.myshopframework.common.utils.ScreenUtil;

/**
 * author：chensen on 2016/8/23 17:31 desc：引导页
 */
public class GuideActivity extends BaseActivity implements View.OnClickListener {

    private static int[] mImage = new int[]{R.drawable.pic_guide_1, R.drawable.pic_guide_2};// 图片

    ViewPager vpGuide;
    LinearLayout llPointContent;
    View viewRedPoint;// 红色的点
    Button btnEnter;
    Button btnSkip;

    private int mLenth;// 圆点离左边的间距

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initWidget();
    }


    public void initWidget() {

        vpGuide = (ViewPager) findViewById(R.id.vp_guide);
        llPointContent = (LinearLayout) findViewById(R.id.ll_point_content);
        viewRedPoint = (View) findViewById(R.id.view_red_point);
        btnEnter = (Button) findViewById(R.id.btn_enter);
        btnEnter.setOnClickListener(this);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnSkip.setOnClickListener(this);
        // btnSkip.getBackground().setAlpha(20);
        // 初始化3个引导页
        for (int i = 0; i < mImage.length; i++) {
            // RelativeLayout relativeLayout = new RelativeLayout(mContext);
            // ImageView imageView = new ImageView(mContext);
            // imageView.setBackgroundResource(mImage[i]);
            //
            // relativeLayout.addView(imageView);
            // RelativeLayout.LayoutParams layoutParams =
            // (android.widget.RelativeLayout.LayoutParams) imageView
            // .getLayoutParams();
            // //layoutParams.topMargin = ScreenUtil.dip2px(mContext, 15);
            // layoutParams.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
            // layoutParams.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
            // layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            //
            // imageView.setLayoutParams(layoutParams);

        }

        AdapterGuide adapterGuide = new AdapterGuide(mContext, mImage);
        vpGuide.setAdapter(adapterGuide);
        // 初始化3个圆点
        for (int i = 0; i < mImage.length; i++) {
            View point = new View(mContext);
            point.setBackgroundResource(R.drawable.point_gray);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ScreenUtil.dip2px(mContext, 7),
                    ScreenUtil.dip2px(mContext, 7));
            if (i > 0) {
                params.leftMargin = ScreenUtil.dip2px(mContext, 13);// 设置圆点的间隔
            }
            point.setLayoutParams(params);//// 设置圆点的大小
            llPointContent.addView(point);

        }
        // 获取视图树, 对layout结束事件进行监听
        llPointContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            // 当layout执行结束后回调此方法
            @Override
            public void onGlobalLayout() {

                llPointContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mLenth = llPointContent.getChildAt(1).getLeft() - llPointContent.getChildAt(0).getLeft();

            }
        });
        vpGuide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // System.out.println("当前位置:" + position + ";百分比:" +
                // positionOffset
                // + ";移动距离:" + positionOffsetPixels);
                int lenth = (int) (mLenth * positionOffset) + position * mLenth;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewRedPoint.getLayoutParams();// 获取当前红点的布局参数
                params.leftMargin = lenth;
                viewRedPoint.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == mImage.length - 1) {
                    btnEnter.setVisibility(View.VISIBLE);
                    btnSkip.setVisibility(View.GONE);
                } else {
                    btnEnter.setVisibility(View.GONE);
                    btnSkip.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_enter) {
            sp.setIsFirst(false);
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (view.getId() == R.id.btn_skip) {
            sp.setIsFirst(false);
            Intent intent = new Intent(mContext, MainActivity.class);
            mContext.startActivity(intent);
            finish();
        }

    }
}
