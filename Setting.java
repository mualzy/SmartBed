package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Setting extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Switch swAll;
    private Switch swVibrate;
    private Switch swRing;
    private Switch swEmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //初始化
        initUi();
    }

    private void initUi() {
        //找出控件
        swAll= findViewById(R.id.sw_vibrate);
        swVibrate= findViewById(R.id.sw_vibrate);
        swRing= findViewById(R.id.sw_ring);
        swEmer= findViewById(R.id.sw_emergency);

        //设置监听者
        swAll.setOnCheckedChangeListener(this);
        swVibrate.setOnCheckedChangeListener(this);
        swRing.setOnCheckedChangeListener(this);
        swEmer.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.getId() == R.id.sw_all){
            toggleSubSwitch(b);
        }else {
            toggleMainSwitchBySubSwitchStatus();
        }
    }

    private void toggleMainSwitchBySubSwitchStatus() {
        //振动提示
        boolean swVibrateStatus= swVibrate.isChecked();
        //声音提示
        boolean swRingStatus=swRing.isChecked();
        //紧急联系
        boolean swEmerStatus=swEmer.isChecked();
        if(swVibrateStatus == swRingStatus && swVibrateStatus == swEmerStatus && swAll.isChecked()!=swVibrateStatus ){
            swAll.setChecked(swVibrateStatus);
        }
    }

    private void toggleSubSwitch(boolean b) {
        if (swVibrate.isChecked()!=b){
            swVibrate.setChecked(b);
        }
        if (swRing.isChecked()!=b){
            swRing.setChecked(b);
        }
        if (swEmer.isChecked()!=b){
            swEmer.setChecked(b);
        }

    }
}