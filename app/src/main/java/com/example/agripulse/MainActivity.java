package com.example.agripulse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String farmerName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        farmerName = getIntent().getStringExtra("FARMER_NAME");
        TextView tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText("Namaste, " + farmerName);

        ImageButton btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(v -> showProfile());

        setupShelf(R.id.shelf1, "Shelf 1", "HEALTHY");
        setupShelf(R.id.shelf2, "Shelf 2", "ROT");
        setupShelf(R.id.shelf3, "Shelf 3", "HEALTHY");
        setupShelf(R.id.shelf4, "Shelf 4", "MOISTURE");
        setupShelf(R.id.shelf5, "Shelf 5", "HEALTHY");
        setupShelf(R.id.shelf6, "Shelf 6", "HEALTHY");
    }

    private void setupShelf(int id, String name, String status) {
        Button shelf = findViewById(id);
        shelf.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(name + " Diagnosis");
            String msg = status.equals("ROT") ? "Warning: High Ammonia detected. Rotting suspected." :
                    status.equals("MOISTURE") ? "Warning: High Humidity. Mold risk." : "Status: Onions are healthy.";
            builder.setMessage(msg);
            builder.setPositiveButton("OK", null);
            builder.show();
        });
    }

    private void showProfile()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Farmer Profile");
        builder.setMessage("Name: " + farmerName + "\nProject: AgriPulse\nStatus: Monitoring Active");
        builder.setPositiveButton("Close", null);
        builder.show();
    }
}