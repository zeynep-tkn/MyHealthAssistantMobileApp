package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class motivation_ipuclari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation_ipuclari);

        // Butonları doğru şekilde tanımla
        Button button1 = findViewById(R.id.b1);
        Button button2 = findViewById(R.id.b2);
        Button button3 = findViewById(R.id.b3);
        Button button4 = findViewById(R.id.b4);
        Button button5 = findViewById(R.id.b5);
        Button button6 = findViewById(R.id.b6);
        Button button7 = findViewById(R.id.b7);
        Button button8 = findViewById(R.id.b8);

        // Her buton için OnClickListener tanımla
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari2Activity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari3Activity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari4Activity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari5Activity.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari6Activity.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari7Activity.class);
                startActivity(intent);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari8Activity.class);
                startActivity(intent);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(motivation_ipuclari.this, MotivationIpuclari9Activity.class);
                startActivity(intent);
            }
        });
    }
}
