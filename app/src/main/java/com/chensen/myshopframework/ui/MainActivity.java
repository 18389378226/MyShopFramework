package com.chensen.myshopframework.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.chensen.myshopframework.R;
import com.chensen.myshopframework.common.base.BaseActivity;
import com.chensen.myshopframework.common.view.MyRadioButton;
import com.chensen.myshopframework.ui.fragment.CenterFragment;
import com.chensen.myshopframework.ui.fragment.HomeFragment;
import com.chensen.myshopframework.ui.fragment.SoftFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.fl_content)
    FrameLayout flContent;
    @Bind(R.id.rb_home)
    MyRadioButton rbHome;
    @Bind(R.id.rb_soft)
    MyRadioButton rbSoft;
    @Bind(R.id.rb_center)
    MyRadioButton rbCenter;
    @Bind(R.id.rg_navigation)
    RadioGroup rgNavigation;


    HomeFragment homeFragment;
    SoftFragment softFragment;
    CenterFragment centerFragment;

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        setCheckedItem(0);

        rgNavigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_home:
                        setCheckedItem(0);
                        break;
                    case R.id.rb_soft:
                        setCheckedItem(1);
                        break;
                    case R.id.rb_center:
                        setCheckedItem(2);
                        break;
                }

            }
        });
    }

    private void setCheckedItem(int i) {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideAllFragments(transaction);
        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment(mContext);
                    transaction.add(R.id.fl_content, homeFragment);
                }

                transaction.show(homeFragment);

                break;
            case 1:
                if (softFragment == null) {
                    softFragment = new SoftFragment(mContext);
                    transaction.add(R.id.fl_content, softFragment);
                }
                transaction.show(softFragment);

                break;
            case 2:
                if (centerFragment == null) {
                    centerFragment = new CenterFragment(mContext);
                    transaction.add(R.id.fl_content, centerFragment);
                }

                transaction.show(centerFragment);

                break;
        }
        transaction.commit();

    }

    private void hideAllFragments(FragmentTransaction transaction) {

        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (softFragment != null) {
            transaction.hide(softFragment);
        }
        if (centerFragment != null) {
            transaction.hide(centerFragment);
        }

    }
}
