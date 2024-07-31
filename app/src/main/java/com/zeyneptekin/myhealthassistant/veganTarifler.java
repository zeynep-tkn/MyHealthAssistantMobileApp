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

public class veganTarifler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan_tarifler);



        // stirCard CardView
        CardView stirCard = findViewById(R.id.stirCard);
        stirCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // yesilBowlCard sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif1.class);
                startActivity(intent);
            }
        });


        // fasulyeCard CardView
        CardView fasulyeCard = findViewById(R.id.fasulyeCard);
        fasulyeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VeganTarifler2 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif2.class);
                startActivity(intent);
            }
        });

        // kabakCicegiCard CardView
        CardView kabakCicegiCard = findViewById(R.id.kabakCicegiCard);
        kabakCicegiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VeganTarifler3 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif3.class);
                startActivity(intent);
            }
        });

        // kuskusCard CardView
        CardView kuskusCard = findViewById(R.id.kuskusCard);
        kuskusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler4 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif4.class);
                startActivity(intent);
            }
        });


        // misirTacoCard CardView
        CardView misirTacoCard = findViewById(R.id.misirTacoCard);
        misirTacoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler5 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif5.class);
                startActivity(intent);
            }
        });


        // lazanyaCard CardView
        CardView lazanyaCard = findViewById(R.id.lazanyaCard);
        lazanyaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler6 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif6.class);
                startActivity(intent);

            }
        });


        // trufCard CardView
        CardView trufCard = findViewById(R.id.trufCard);
        trufCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler7 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif7.class);
                startActivity(intent);
            }
        });


        // kanatCard CardView
        CardView kanatCard = findViewById(R.id.kanatCard);
        kanatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler8 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif8.class);
                startActivity(intent);
            }
        });


        // risottoCard CardView
        CardView risottoCard = findViewById(R.id.risottoCard);
        risottoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler9 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif9.class);
                startActivity(intent);
            }
        });


        // crumbleCard CardView
        CardView crumbleCard = findViewById(R.id.crumbleCard);
        crumbleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler10 sayfasına git
                Intent intent = new Intent(veganTarifler.this, VeganTarif10.class);
                startActivity(intent);
            }
        });

    }
}