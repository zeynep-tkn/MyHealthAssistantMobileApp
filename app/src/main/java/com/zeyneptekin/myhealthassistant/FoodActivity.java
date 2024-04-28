package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodActivity extends AppCompatActivity {

    private Button SaglikliTarif;
    private Button VeganTarif;
    private Button GlutensizTarif;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        // Butonu bul ve tıklama olayını ayarla
        SaglikliTarif = findViewById(R.id.btnSaglik); // 'view' değişkeni kaldırıldı
        SaglikliTarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 'view' değişkeni 'v' olarak değiştirildi
                // Randevu ekleme formu sayfasına geçiş yap
                Intent intent = new Intent(FoodActivity.this, saglikliTarifler.class); // 'getActivity()' değiştirildi
                startActivity(intent);
            }
        });
        // Butonu bul ve tıklama olayını ayarla
        VeganTarif = findViewById(R.id.btnVegan); // 'view' değişkeni kaldırıldı
        VeganTarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 'view' değişkeni 'v' olarak değiştirildi
                // Randevu ekleme formu sayfasına geçiş yap
                Intent intent = new Intent(FoodActivity.this, veganTarifler.class); // 'getActivity()' değiştirildi
                startActivity(intent);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        GlutensizTarif = findViewById(R.id.btnGluten); // 'view' değişkeni kaldırıldı
        GlutensizTarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 'view' değişkeni 'v' olarak değiştirildi
                // Randevu ekleme formu sayfasına geçiş yap
                Intent intent = new Intent(FoodActivity.this, glutensizTarifler.class); // 'getActivity()' değiştirildi
                startActivity(intent);
            }
        });
    }
}