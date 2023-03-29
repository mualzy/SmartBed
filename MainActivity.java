package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button shakemode;
    private Button funmode;
    private Button screencatch;
    private Button setting;
    private static final String TAG = MainActivity;
    private OkHttpClient okHttpClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpClient=new OkHttpClient();




        //找到控件
        shakemode=findViewById(R.id.btn_shakemode);
        funmode=findViewById(R.id.btn_funmode);
        setting=findViewById(R.id.btn_setting);
        screencatch=findViewById(R.id.btn_scrcatch);
        //实现跳转
        shakemode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,shakemodeActivity.class);
                startActivity(intent);
            }
        });

        funmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(MainActivity.this,funmodeActivity.class);
                startActivity(intent);
            }
        });


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(MainActivity.this,Setting.class);
                startActivity(intent);
            }
        });

        screencatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                intent = new Intent(MainActivity.this, ScreenCatchActivity.class);
                startActivity(intent);
            }
        });
    }
}