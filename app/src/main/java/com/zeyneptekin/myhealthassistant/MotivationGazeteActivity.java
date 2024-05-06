package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class MotivationGazeteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation_gazete);

        // ImageButton'u onCreate metodunun içine taşıyın
        ImageButton imageButton4 = findViewById(R.id.im1);

        // ImageButton için OnClickListener tanımını onCreate metodunun içine taşıyın
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });
        // ImageButton'u onCreate metodunun içine taşıyın
        ImageButton imageButton5 = findViewById(R.id.im2);

        // ImageButton için OnClickListener tanımını onCreate metodunun içine taşıyın
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });
        // ImageButton'u onCreate metodunun içine taşıyın
        ImageButton imageButton6 = findViewById(R.id.im3);

        // ImageButton için OnClickListener tanımını onCreate metodunun içine taşıyın
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });
        // ImageButton'u onCreate metodunun içine taşıyın
        ImageButton imageButton7 = findViewById(R.id.im4);

        // ImageButton için OnClickListener tanımını onCreate metodunun içine taşıyın
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });
        // ImageButton'u onCreate metodunun içine taşıyın
        ImageButton imageButton8 = findViewById(R.id.im5);

        // ImageButton için OnClickListener tanımını onCreate metodunun içine taşıyın
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });
        // ImageButton'u onCreate metodunun içine taşıyın
        ImageButton imageButton9 = findViewById(R.id.im6);

        // ImageButton için OnClickListener tanımını onCreate metodunun içine taşıyın
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });

    }
}
