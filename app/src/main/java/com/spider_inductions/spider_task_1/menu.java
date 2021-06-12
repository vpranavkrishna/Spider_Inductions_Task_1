package com.spider_inductions.spider_task_1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class menu extends AppCompatActivity {
    private Button level1,level2;
    private TextView heading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level3);
        level1.setText("Level 1");
        level2.setText("Level 2");
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,Level1.class);
                startActivity(intent);

            }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,Level2.class);
                startActivity(intent);
            }
        });


    }
}