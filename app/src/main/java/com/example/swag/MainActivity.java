package com.example.swag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.swag.Intro.Introduction;

public class MainActivity extends AppCompatActivity {
    private Handler mWaitHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Intent i = new Intent(MainActivity.this, Introduction.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Remove all the callbacks otherwise navigation will execute even after activity is killed or closed.
        mWaitHandler.removeCallbacksAndMessages(null);
    }
}

