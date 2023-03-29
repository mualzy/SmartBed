package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class funmodeActivity extends AppCompatActivity {

    Button musicmode;
    Button storymode;
    Button voicemode;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funmode);

        musicmode = findViewById(R.id.btn_music);
        storymode = findViewById(R.id.btn_story);
        voicemode = findViewById(R.id.btn_voice);
        status= findViewById(R.id.funmode_status);

        musicmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status.setText(R.string.playmusic);
            }
        });
        storymode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status.setText(R.string.playstory);
            }
        });
        voicemode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status.setText(R.string.playvoice);
            }
        });
    }
}