
package com.spider_inductions.spider_task_1;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Level2 extends AppCompatActivity implements View.OnClickListener {
    private EditText v, gammai;
    private View view;
    private int attempt = 0;
    private Vibrator vibrator;
    private final double c = 300000000d;
    private TextView answer;
    private String textv, textgamma;
    private Button button;
    private double inputv, inputgamma;
    private double gamma;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_level1);
        v = findViewById(R.id.valuev);
        view = this.getWindow().getDecorView();
        answer = findViewById(R.id.answer);
        button = findViewById(R.id.button);
        gammai = findViewById(R.id.inputgamma);
        gammai.setVisibility(View.VISIBLE);
        button.setOnClickListener(this);
        v.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                view.setBackgroundResource(R.color.white);
                attempt=0;
                answer.setText("");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        gammai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                view.setBackgroundResource(R.color.white);
                answer.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getvalue() {
        textv = v.getText().toString();
        inputv = Double.parseDouble(textv);
        textgamma = gammai.getText().toString();
        inputgamma = Double.parseDouble(textgamma);

    }

    private boolean isempty() {
        if (v.getText().toString().trim().length() <= 0 || gammai.getText().toString().trim().length() <= 0)
            return true;
        else
            return false;
    }

    @Override
    public void onClick(View v) {

        if (!isempty()) {
            getvalue();
            if (inputv >= 300000000) {
                Toast.makeText(Level2.this, "Invalid input of V", Toast.LENGTH_SHORT).show();
            }
            else {
                gamma = 1 / (Math.sqrt(1 - (Math.pow(inputv, 2) / Math.pow(c, 2))));
                gamma = (double) Math.round(gamma * 100000d) / 100000d;
                if (gamma != inputgamma) {
                    attempt++;
                    view.setBackgroundResource(R.color.light_red);
                    shakeIt(500, 250);
                    if (attempt > 3) {
                        answer.setText("\uD835\uDEFE = " + gamma);
                    } else {
                        answer.setText("Try again attempts left : " + (4 - attempt));

                    }
                } else {
                    answer.setText("Correct answer");
                    view.setBackgroundResource(R.color.light_green);
                }
            }

        } else
            Toast.makeText(this, "Enter the value of V & \uD835\uDEFE", Toast.LENGTH_SHORT).show();
    }


    private void shakeIt(int time, int amp) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(time, amp));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(time);
        }
    }
}



