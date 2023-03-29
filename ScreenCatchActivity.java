package com.example.myapplication;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import java.io.IOException;

public class ScreenCatchActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    //获取地址
    private String videoUrl = "192.168.1.103";
    private Button playButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_catch);

        surfaceView = findViewById(R.id.view_baby);
        playButton = findViewById(R.id.btn_baby_view);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                playButton.setVisibility(View.GONE);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareMediaPlayer();
            }
        });
    }

    private void prepareMediaPlayer() {
        try {
            mediaPlayer.setDataSource(videoUrl);
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        prepareMediaPlayer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
