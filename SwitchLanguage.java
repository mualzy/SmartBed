package com.example.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
public class SwitchLanguage extends AppCompatActivity {
    private Button btnSwitchLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSwitchLang = findViewById(R.id.sw_language);
        btnSwitchLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取当前应用的 Configuration 对象
                Configuration config = getResources().getConfiguration();

                // 创建新的 Locale 对象，用于设置新的语言环境
                Locale newLocale = new Locale("en");

                // 设置 Locale 对象到 Configuration 中
                config.setLocale(newLocale);

                // 更新当前 Activity 的 Configuration
                getResources().updateConfiguration(config, null);

                // 重新加载当前 Activity
                recreate();
            }
        });
    }
}
