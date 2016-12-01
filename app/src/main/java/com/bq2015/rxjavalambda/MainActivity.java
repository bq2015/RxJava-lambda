package com.bq2015.rxjavalambda;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;
    private Button mFuck;
    private String mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFuck = (Button) findViewById(R.id.btn_main_ui);
        mString = mFuck.getText().toString();
        mHandler = new Handler();
        new Thread(() -> {
            int i = 7;
            while (i > 0) {
                SystemClock.sleep(800);
                int finalI = i;
                mHandler.postDelayed(() -> {
                    mFuck.setText(String.valueOf(mString + finalI));
                    if (finalI == 1) {
                        Toast.makeText(MainActivity.this, getString(R.string.massage_main_ui), Toast.LENGTH_SHORT).show();
                    }
                }, 800);
                i--;
            }
        }).start();

    }
}
