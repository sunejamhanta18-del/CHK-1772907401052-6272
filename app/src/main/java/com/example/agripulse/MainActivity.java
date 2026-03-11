package com.example.agripulse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private TextView tvMainTitle, tvHumidityLabel, tvShelfLabel;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        ImageButton btnOpenDrawer = findViewById(R.id.btnOpenDrawer);
        navigationView = findViewById(R.id.nav_view);
        CardView climateCard = findViewById(R.id.climateCard);

        // Find TextViews that need translation
        tvMainTitle = findViewById(R.id.tvMainTitle);
        tvHumidityLabel = findViewById(R.id.tvHumidityLabel);
        tvShelfLabel = findViewById(R.id.tvShelfLabel);

        btnOpenDrawer.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        climateCard.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, StatsActivity.class)));

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_stats) startActivity(new Intent(this, StatsActivity.class));
            else if (id == R.id.nav_rate) startActivity(new Intent(this, RateActivity.class));
            else if (id == R.id.nav_shelves) startActivity(new Intent(this, ShelvesActivity.class));
            else if (id == R.id.nav_translate) showLanguageDialog();

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void showLanguageDialog() {
        String[] languages = {"English", "Hindi (हिन्दी)", "Marathi (मराठी)"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Language / भाषा चुनें");
        builder.setItems(languages, (dialog, which) -> {
            updateLanguageUI(which);
        });
        builder.show();
    }

    private void updateLanguageUI(int langIndex) {
        // Find the Sidebar Menu to translate it too
        android.view.Menu menu = navigationView.getMenu();

        if (langIndex == 1) { // HINDI
            tvMainTitle.setText("मुख्य पृष्ठ");
            tvHumidityLabel.setText("नमी: 55%");
            tvShelfLabel.setText("प्याज भंडारण अलमारियां");

            menu.findItem(R.id.nav_stats).setTitle("आंकड़े");
            menu.findItem(R.id.nav_rate).setTitle("परिवर्तन की दर");
            menu.findItem(R.id.nav_shelves).setTitle("अलमारियां");
            menu.findItem(R.id.nav_notifications).setTitle("सूचनाएं");

        } else if (langIndex == 2) { // MARATHI
            tvMainTitle.setText("मुख्य पान");
            tvHumidityLabel.setText("आद्रता: 55%");
            tvShelfLabel.setText("कांदा साठवणूक कपाटे");

            menu.findItem(R.id.nav_stats).setTitle("आकडेवारी");
            menu.findItem(R.id.nav_rate).setTitle("बदलाचा दर");
            menu.findItem(R.id.nav_shelves).setTitle("कपाटे");
            menu.findItem(R.id.nav_notifications).setTitle("सूचना");

        } else { // ENGLISH
            tvMainTitle.setText("HOME");
            tvHumidityLabel.setText("Humidity: 55%");
            tvShelfLabel.setText("Onion Storage Shelves");

            menu.findItem(R.id.nav_stats).setTitle("Stats");
            menu.findItem(R.id.nav_rate).setTitle("Stats Over Time");
            menu.findItem(R.id.nav_shelves).setTitle("Shelves");
            menu.findItem(R.id.nav_notifications).setTitle("Notifications");
        }
    }
}