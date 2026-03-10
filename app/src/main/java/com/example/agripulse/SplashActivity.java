package com.example.agripulse;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.app_logo);
        TextView title = findViewById(R.id.app_name_text);

        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        logo.startAnimation(scale);
        title.startAnimation(fade);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3500);
    }
}