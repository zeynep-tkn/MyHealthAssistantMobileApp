package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView; // Buraya eklenecek

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class saglikliTarifler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglikli_tarifler);


        // yesilBowlCard CardView
        CardView yesilBowlCard = findViewById(R.id.yesilBowlCard);
        yesilBowlCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // yesilBowlCard sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, yesilBowlTarifi.class);
                startActivity(intent);
            }
        });


        // enerjiToplariCard CardView
        CardView enerjiToplariCard = findViewById(R.id.enerjiToplariCard);
        enerjiToplariCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VeganTarifler2 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif2.class);
                startActivity(intent);
            }
        });

        // granolaCard CardView
        CardView granolaCard = findViewById(R.id.granolaCard);
        granolaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VeganTarifler3 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif3.class);
                startActivity(intent);
            }
        });

        // spagettiCard CardView
        CardView spagettiCard = findViewById(R.id.spagettiCard);
        spagettiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler4 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif4.class);
                startActivity(intent);
            }
        });


        // proteinBarCard CardView
        CardView proteinBarCard = findViewById(R.id.proteinBarCard);
        proteinBarCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler5 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif5.class);
                startActivity(intent);
            }
        });


        // kinoaCard CardView
        CardView kinoaCard = findViewById(R.id.kinoaCard);
        kinoaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler6 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif6.class);
                startActivity(intent);

            }
        });


        // nohutKofteCard CardView
        CardView nohutKofteCard = findViewById(R.id.nohutKofteCard);
        nohutKofteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler7 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif7.class);
                startActivity(intent);
            }
        });


        // pudingCard CardView
        CardView pudingCard = findViewById(R.id.pudingCard);
        pudingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler8 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif8.class);
                startActivity(intent);
            }
        });


        // bruschettaCard CardView
        CardView bruschettaCard = findViewById(R.id.bruschettaCard);
        bruschettaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler9 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarifler9.class);
                startActivity(intent);
            }
        });


        // meksikaCard CardView
        CardView parfeCard = findViewById(R.id.parfeCard);
        parfeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler10 sayfasına git
                Intent intent = new Intent(saglikliTarifler.this, saglikliTarifler10.class);
                startActivity(intent);
            }
        });


    }
}