package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();

        // 创建Request对象，设置URL和请求方法
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .get()
                .build();

        // 使用OkHttpClient对象发送Request请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 请求失败，处理异常
                Log.e(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 请求成功，处理响应
                String responseBody = response.body().string();
                Log.d(TAG, "onResponse: " + responseBody);
            }
        });
    }
}





