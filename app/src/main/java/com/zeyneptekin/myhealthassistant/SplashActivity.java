package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 4000;
    ImageView imageView;
    TextView textView;
    Animation up,down;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView=findViewById(R.id.logoImage);
        up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);

        TextView textView=findViewById(R.id.appname);
        down=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);

        // Splash ekranını belirli bir süre gösterdikten sonra ana ekrana geçiş yapılacak
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Ana ekrana geçiş yap
                Intent getStartedIntent = new Intent(SplashActivity.this, NavigationActivity.class);
                startActivity(getStartedIntent);
                finish(); // Splash ekranını kapat
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}