package com.example.agripulse;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.ArrayList;

public class RateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        LineChart chart = findViewById(R.id.reportingChart);
        final String[] quarters = new String[] {"10:00", "10:30", "11:00", "11:30", "12:00"};

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 24.2f));
        entries.add(new Entry(1, 25.1f));
        entries.add(new Entry(2, 26.8f));
        entries.add(new Entry(3, 28.4f));
        entries.add(new Entry(4, 27.5f));

        LineDataSet dataSet = new LineDataSet(entries, "Temperature Trend (°C)");
        dataSet.setLineWidth(3f);
        dataSet.setCircleColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        dataSet.setColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                int index = (int) value;
                return (index >= 0 && index < quarters.length) ? quarters[index] : "";
            }
        });

        chart.setData(new LineData(dataSet));
        chart.animateX(1000);
        chart.invalidate();
    }
}