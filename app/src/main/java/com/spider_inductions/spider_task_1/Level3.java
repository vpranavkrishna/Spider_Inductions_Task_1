package com.spider_inductions.spider_task_1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.time.OffsetTime;

public class Level3 extends AppCompatActivity {
    private TextView textView, spiout;
    private int hour;
    private int minute;
    private int second;
    private double spi;
    private ProgressBar progressBar;
    private static final String TAG = "Level3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_level3);
        textView = findViewById(R.id.time);
        spiout = findViewById(R.id.spi);
        progressBar= findViewById(R.id.progressbar);
        progressBar.setMax(1);
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              progressBar.setVisibility(View.INVISIBLE);
            }
        },1000);

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
//                        progressBar.setVisibility(View.VISIBLE);
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                    OffsetTime offset = OffsetTime.now();
                                    if (offset.getHour() > 12)
                                        hour = offset.getHour() - 12;
                                    else
                                        hour = offset.getHour();

                                    minute = offset.getMinute();
                                    second = offset.getSecond();
                                    textView.setText(hour + " : " + offset.getMinute() + " : " + offset.getSecond());
                                    calculate();

                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }

        };
        t.start();


    }

    private void calculate() {

        spi = (double) (factorial(hour) / (Math.pow(minute, 3) + second));
        Log.d(TAG, "calculate: deno" + (Math.pow(minute, 3) + second));
        spiout.setText("spi = " + ((double)Math.round(spi*100000000d)/100000000d));

    }

    private int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
//        Log.d(TAG, "factorial: "+ fact);
        return fact;

    }


    }

