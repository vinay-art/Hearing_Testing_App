package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class startActivity extends AppCompatActivity {

    ImageView logo;
    Intent intent;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        logo = findViewById(R.id.imageView5);
        new CountDownTimer(4500,4500){
            @Override
            public void onTick(long l) {
                logo.animate().alpha(1).setDuration(3000);
            }
            @Override
            public void onFinish() {
                intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        }.start();
    }
}