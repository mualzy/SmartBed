package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class shakemodeActivity extends AppCompatActivity {

    Button level_smart;
    Button level_1;
    Button level_2;
    TextView now_shake_status;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shakemode);

        level_smart = findViewById(R.id.btn_shake_smart);
        level_1 = findViewById(R.id.btn_shake_level1);
        level_2 = findViewById(R.id.btn_shake_level2);
        now_shake_status = findViewById(R.id.text_shake_status);

        level_smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                now_shake_status.setText(R.string.shake_mode);
            }
        });
        level_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                now_shake_status.setText(R.string.slow);
            }
        });
        level_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                now_shake_status.setText(R.string.medium);
            }
        });
    }
}