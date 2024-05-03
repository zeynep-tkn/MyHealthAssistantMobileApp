package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FoodActivity extends AppCompatActivity {

    private LinearLayout SaglikliTarif;
    private LinearLayout VeganTarif;
    private LinearLayout GlutensizTarif;

    //private LinearLayout KisiselAsistan;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        // LinearLayout'leri bul ve tıklama olayını ayarla
        SaglikliTarif = findViewById(R.id.SaglikliLayout);
        SaglikliTarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, saglikliTarifler.class);
                System.out.println("Sağlıklı tarifler sayfasına geçti");
                startActivity(intent);
            }
        });

        VeganTarif = findViewById(R.id.veganLayout);
        VeganTarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, veganTarifler.class);
                startActivity(intent);
            }
        });

        GlutensizTarif = findViewById(R.id.glutensizLayout);
        GlutensizTarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, glutensizTarifler.class);
                startActivity(intent);
            }
        });
        /*
        KisiselAsistan = findViewById(R.id.AsistanLayout);
        KisiselAsistan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this,KisiselAistan.class);
                startActivity(intent);
            }
        });
        */
    }

}