package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SportsExerciseActivity extends AppCompatActivity {
    Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_exercise);
        Toolbar toolbar= findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        button1=findViewById(R.id.startP1);
        button2=findViewById(R.id.startP2);
        button3=findViewById(R.id.startP3);
        button4=findViewById(R.id.startP4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SportsExerciseActivity.this, P1SportActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SportsExerciseActivity.this, P2SportActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SportsExerciseActivity.this, P3SportActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SportsExerciseActivity.this, P4SportActivity.class);
                startActivity(intent);
            }
        });
    }


    public void exerciseP1(View view) {
     Intent intent =new Intent(SportsExerciseActivity.this, P1SportActivity.class);
     startActivity(intent);

    }

    public void exerciseP2(View view) {
        Intent intent =new Intent(SportsExerciseActivity.this, P2SportActivity.class);
        startActivity(intent);
    }

    public void exerciseP3(View view) {
        Intent intent =new Intent(SportsExerciseActivity.this, P3SportActivity.class);
        startActivity(intent);
    }

    public void exerciseP4(View view) {
        Intent intent =new Intent(SportsExerciseActivity.this, P4SportActivity.class);
        startActivity(intent);
    }
}