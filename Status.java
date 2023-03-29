package com.example.myapplication;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;

// 定义一个  Status 类来存储解析后的数据
public class Status {
    private int temperture;
    private int humidity;
    private boolean bed_wet;
    private boolean baby_outbed;
    public Status(Map<String, Object> data) {
        this.temperture = (int) data.get("temperture");
        this.humidity = (int) data.get("humidity");
        this.bed_wet = (boolean) data.get("bed_wet");
        this.baby_outbed = (boolean) data.get("baby_outbed");
    }

    // getter 和 setter 方法
    public int getTemperture() {
        return temperture;
    }

    public void setTemperture(int temperture) {
        this.temperture = temperture;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setBed_wet(boolean bed_wet) {
        this.bed_wet = bed_wet;
    }

    public boolean isBed_wet() {
        return bed_wet;
    }

    public void setBaby_outbed(boolean baby_outbed) {
        this.baby_outbed = baby_outbed;
    }

    public boolean isBaby_outbed() {
        return baby_outbed;
    }
}


