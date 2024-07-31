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

        ImageButton imageButton1 = findViewById(R.id.im1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton2 = findViewById(R.id.im2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete2Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton3 = findViewById(R.id.im3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete3Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton4 = findViewById(R.id.im4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete4Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton5 = findViewById(R.id.im5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete5Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton6 = findViewById(R.id.im6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete6Activity.class);
                startActivity(intent);
            }
        });
    }
}
