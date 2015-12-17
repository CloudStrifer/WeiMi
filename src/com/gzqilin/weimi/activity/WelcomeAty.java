package com.gzqilin.weimi.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.gzqilin.weimi.R;
import com.gzqilin.weimi.utils.IntentUtils;
import com.gzqilin.weimi.utils.SplashImage;

/**
 * 启动闪屏
 *
 * @author lsh
 */
public class WelcomeAty extends BaseActivity implements SplashImage.Callback {
    protected boolean isInvalid = false;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        SplashImage splashImage = new SplashImage(this, R.drawable.welcome);
        splashImage.setCallback(this);
        setContentView(splashImage);
    }

    @Override
    public void onBackPressed() {
        //do nothing;
    }

    @Override
    public void onAnimationStart() {
    }

    @Override
    public void onAnimationEnd() {
        if (!isInvalid) {
            //进入主界面，通过Intent跳转
//            SharedPreferences sp = getPreferences(MODE_PRIVATE);
//            boolean isOpen = sp.getBoolean("open", false);
//            if (isOpen) {
//                IntentUtils.startActivity(WelcomeAty.this, MainActivity.class);
//                finish();
//            } else {
//                startActivity(new Intent(WelcomeAty.this,
//                        FirstUseAty.class));
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putBoolean("open", true);
//                editor.commit();
//                finish();
//            }
            IntentUtils.startActivity(WelcomeAty.this, MainActivity.class);
            finish();
        }
    }
}
