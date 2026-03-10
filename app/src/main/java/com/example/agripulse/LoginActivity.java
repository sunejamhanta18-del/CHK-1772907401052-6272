package com.example.agripulse;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CardView loginCard = findViewById(R.id.login_card);
        TextView loginTitle = findViewById(R.id.login_title);
        EditText etName = findViewById(R.id.etFarmerName);
        EditText etId = findViewById(R.id.etFarmId);
        Button btnLogin = findViewById(R.id.btnLogin);

        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        loginCard.startAnimation(slideUp);
        loginTitle.startAnimation(fadeIn);

        btnLogin.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String id = etId.getText().toString();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("FARMER_NAME", name);
            intent.putExtra("FARM_ID", id);
            startActivity(intent);
        });
    }
}