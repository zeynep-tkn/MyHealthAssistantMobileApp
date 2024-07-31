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

public class glutensizTarifler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glutensiz_tarifler);

        // Balık Tacos CardView
        CardView balikTacoCard = findViewById(R.id.BalikTacoCard);
        balikTacoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Balık Tacos sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif1.class);
                startActivity(intent);
            }
        });


        // karides CardView
        CardView karidesCard = findViewById(R.id.karidesCard);
        karidesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler2 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif2.class);
                startActivity(intent);
            }
        });

        // mucverCard CardView
        CardView mucverCard = findViewById(R.id.mucverCard);
        mucverCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler3 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif3.class);
                startActivity(intent);
            }
        });

        // brownieCard CardView
        CardView brownieCard = findViewById(R.id.brownieCard);
        brownieCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler4 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif4.class);
                startActivity(intent);
            }
        });


        // KabakPureCard CardView
        CardView KabakPureCard = findViewById(R.id.KabakPureCard);
        KabakPureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler5 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif5.class);
                startActivity(intent);
            }
        });


        // karabugdayCard CardView
        CardView karabugdayCard = findViewById(R.id.karabugdayCard);
        karabugdayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler6 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif6.class);
                startActivity(intent);

            }
        });


                // karniyarikCard CardView
                CardView karniyarikCard = findViewById(R.id.karniyarikCard);
                karniyarikCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // GlutensizTarifler7 sayfasına git
                        Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif7.class);
                        startActivity(intent);
                    }
                });


        // incirCard CardView
        CardView incirCard = findViewById(R.id.incirCard);
        incirCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler8 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif8.class);
                startActivity(intent);
            }
        });


        // cheesecakeCard CardView
        CardView cheesecakeCard = findViewById(R.id.cheesecakeCard);
        cheesecakeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler9 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif9.class);
                startActivity(intent);
            }
        });


        // meksikaCard CardView
        CardView meksikaCard = findViewById(R.id.meksikaCard);
        meksikaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GlutensizTarifler10 sayfasına git
                Intent intent = new Intent(glutensizTarifler.this, GlutensizTarif10.class);
                startActivity(intent);
            }
        });



    }
}
