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

        ImageButton imageButton4 = findViewById(R.id.im1);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton5 = findViewById(R.id.im2);


        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton6 = findViewById(R.id.im3);


        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton7 = findViewById(R.id.im4);


        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton8 = findViewById(R.id.im5);


        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton9 = findViewById(R.id.im6);


        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivationGazeteActivity.this, Gazete1Activity.class);
                startActivity(intent);
            }
        });

    }
}
