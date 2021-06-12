package com.spider_inductions.spider_task_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Level1 extends AppCompatActivity implements View.OnClickListener{
    private EditText v;
    private final double c = 300000000d;
    private TextView answer;
    private String textv;
    private Button button;
    private double inputv;
    private double gamma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_level1);
        v = findViewById(R.id.valuev);
        answer = findViewById(R.id.answer);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        v.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               answer.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void getvalue()
    {
        textv = v.getText().toString();
        inputv = Double.parseDouble(textv);


    }
 private boolean isempty()
    {
        if(v.getText().toString().trim().length() <= 0 )
            return true ;
        else
            return false;
    }

    @Override
    public void onClick(View v) {

            if(!isempty()) {
                getvalue();
                if (inputv >= 300000000 ) {
                    Toast.makeText(Level1.this, "Invalid input of V", Toast.LENGTH_SHORT).show();
                } else {
                    gamma = 1 / (Math.sqrt(1 - (Math.pow(inputv, 2) / Math.pow(c, 2))));
                    gamma = (double)Math.round(gamma * 100000d) / 100000d;
                    answer.setText("\uD835\uDEFE = " + gamma);

                }
            }
            else
                Toast.makeText(this, "Enter the value of V ", Toast.LENGTH_SHORT).show();

    }
    


}