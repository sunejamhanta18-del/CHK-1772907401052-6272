package com.example.agripulse;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StatsActivity extends AppCompatActivity {
    private TextView tvTemp, tvHum, tvGas, tvTime;
    private Handler handler = new Handler();
    private int currentIndex = 0;

    private String[] times = {"10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM"};
    private String[] temps = {"24.2°C", "25.1°C", "26.8°C", "28.4°C", "27.5°C"};
    private String[] hums = {"55%", "56%", "58%", "62%", "60%"};
    private String[] gases = {"10 ppm", "11 ppm", "12 ppm", "15 ppm", "14 ppm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        tvTime = findViewById(R.id.tvTimeStat);
        tvTemp = findViewById(R.id.tvTempStat);
        tvHum = findViewById(R.id.tvHumStat);
        tvGas = findViewById(R.id.tvGasStat);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvTime.setText("Last Sync: " + times[currentIndex]);
                tvTemp.setText(temps[currentIndex]);
                tvHum.setText(hums[currentIndex]);
                tvGas.setText(gases[currentIndex]);
                currentIndex = (currentIndex + 1) % 5;
                handler.postDelayed(this, 5000);
            }
        }, 0);
    }
}