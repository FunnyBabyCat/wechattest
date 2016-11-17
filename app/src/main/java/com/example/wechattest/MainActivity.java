package com.example.wechattest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextPaint;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by saber on 2016/11/17.
 */

public class MainActivity extends Activity {

    private TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        logo = (TextView) findViewById(R.id.logo);

        TextPaint tp = logo.getPaint();
        tp.setFakeBoldText(true);
        CountDownTimer cdt = new CountDownTimer(2000, 2000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        cdt.start();
    }

}
