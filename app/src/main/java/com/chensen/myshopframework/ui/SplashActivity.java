package com.chensen.myshopframework.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.chensen.myshopframework.R;
import com.chensen.myshopframework.common.base.BaseActivity;
import com.chensen.myshopframework.common.utils.SharePreferenceUtil;

/**
 * author：chensen on 2016/8/23 17:31 desc：闪屏页
 */
public class SplashActivity extends BaseActivity {

    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 3000;
    private long lastTime = 0;



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            goHome();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_shop);
        handler.sendEmptyMessageDelayed(0, SPLASH_DELAY_MILLIS);
        mContext = this;


    }


    private void goHome() {

        if (sp.isFirst()) {
            Intent intent = new Intent(mContext, GuideActivity.class);
            mContext.startActivity(intent);
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        } else {
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
        }
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - lastTime > 2000) {
                Toast.makeText(mContext, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                lastTime = System.currentTimeMillis();
            } else {
                finish();
                // AppManager.getAppManager().AppExit(mContext);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


}
