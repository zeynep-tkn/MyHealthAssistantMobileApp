package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class EducationActivity extends AppCompatActivity {

    private ImageButton Sporplanlari;
   private ImageButton akilsagligi;
    private ImageButton beslenmetemelleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);


        Sporplanlari = findViewById(R.id.imageButton3);
        Sporplanlari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sağlık Geçmişim sayfasına geçiş yap
                Intent intent = new Intent(EducationActivity.this, SporPlanlariActivity.class);
                startActivity(intent);
            }
        });

        akilsagligi = findViewById(R.id.imageButton2);
        akilsagligi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sağlık Geçmişim sayfasına geçiş yap
                Intent intent = new Intent(EducationActivity.this, AkilSagligiActivity.class);
                startActivity(intent);
            }
        });


        beslenmetemelleri = findViewById(R.id.imageButton1);
        beslenmetemelleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sağlık Geçmişim sayfasına geçiş yap
                Intent intent = new Intent(EducationActivity.this, EgitimBeslenmeActivity.class);
                startActivity(intent);
            }
        });

    }
}