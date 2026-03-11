package com.example.agripulse;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ShelvesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelves);

        findViewById(R.id.cardShelf1).setOnClickListener(v -> showDiagnosis("Shelf 1", "Status: Healthy. No rot detected."));
        findViewById(R.id.cardShelf2).setOnClickListener(v -> showDiagnosis("Shelf 2", "Status: Healthy. Optimal ventilation."));

        // Red Shelf Diagnosis
        findViewById(R.id.cardShelf3).setOnClickListener(v -> showDiagnosis("Shelf 3 ALERT",
                "Cause: Bacterial Soft Rot detected.\n" +
                        "Reason: Excess humidity (85%) + high local temperature.\n" +
                        "Action: Remove infected onions immediately."));

        findViewById(R.id.cardShelf4).setOnClickListener(v -> showDiagnosis("Shelf 4", "Status: Healthy."));

        // Yellow Shelf Diagnosis
        findViewById(R.id.cardShelf5).setOnClickListener(v -> showDiagnosis("Shelf 5 WARNING",
                "Status: Sprouting danger.\n" +
                        "Reason: Temperature higher than 28°C.\n" +
                        "Action: Increase exhaust fan speed."));

        findViewById(R.id.cardShelf6).setOnClickListener(v -> showDiagnosis("Shelf 6", "Status: Healthy."));
    }

    private void showDiagnosis(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}