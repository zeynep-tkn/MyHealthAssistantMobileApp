package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

public class MotivationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);

        //MaterialToolbar toolbar = findViewById(R.id.materialToolbar);
        ImageView motivationButton = findViewById(R.id.button6);
        ImageView activitiesButton = findViewById(R.id.button4);
        ImageView tipsButton = findViewById(R.id.button11);
        ImageView entertainmentButton = findViewById(R.id.button12);
        ImageView inspiringStoriesButton = findViewById(R.id.button13);
        ImageView motivationCalendarButton = findViewById(R.id.button14);

        // Motivasyon butonuna tıklama işlemi eklenebilir
        motivationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Motivasyon butonuna tıklandığında yapılacak işlemler buraya yazılabilir
                Intent intent=new Intent(MotivationActivity.this, MotivationGazeteActivity.class);
                startActivity(intent);
            }
        });

        // Etkinlikler butonuna tıklama işlemi eklenebilir
        activitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Etkinlikler butonuna tıklandığında yapılacak işlemler buraya yazılabilir
                Intent intent=new Intent(MotivationActivity.this, MotivationEtkinlikActivity.class);
                startActivity(intent);
            }
        });

        // Hayatı Kolaylaştırıcı İpuçları butonuna tıklama işlemi eklenebilir
        tipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hayatı Kolaylaştırıcı İpuçları butonuna tıklandığında yapılacak işlemler buraya yazılabilir
                Intent intent=new Intent(MotivationActivity.this, motivation_ipuclari.class);
                startActivity(intent);
            }
        });

        // Eğlence butonuna tıklama işlemi eklenebilir
        entertainmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eğlence butonuna tıklandığında yapılacak işlemler buraya yazılabilir
                Intent intent=new Intent(MotivationActivity.this, MotivationEglenceActivity.class);
                startActivity(intent);
            }
        });

        // İlham Veren Hikayeler butonuna tıklama işlemi eklenebilir
        inspiringStoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // İlham Veren Hikayeler butonuna tıklandığında yapılacak işlemler buraya yazılabilir
                Intent intent=new Intent(MotivationActivity.this, motivation_ilhamveren.class);
                startActivity(intent);
            }
        });

        // Motivasyon Takvimi butonuna tıklama işlemi eklenebilir
        motivationCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Motivasyon Takvimi butonuna tıklandığında yapılacak işlemler buraya yazılabilir
                Intent intent=new Intent(MotivationActivity.this, MotivationTakvimActivity.class);
                startActivity(intent);
            }
        });

        // Metin ve düğmelerin yerleşimini ve özelliklerini XML'den aldık, bu yüzden burada başka bir şey gerekmiyor.
        // Gerekirse, her bir görünüm için belirli özellikler ayarlanabilir veya dinamik olarak değiştirilebilir.
    }
}
