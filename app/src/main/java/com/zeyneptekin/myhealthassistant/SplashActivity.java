package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Splash ekranını belirli bir süre gösterdikten sonra ana ekrana geçiş yapılacak
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Ana ekrana geçiş yap
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish(); // Splash ekranını kapat
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}