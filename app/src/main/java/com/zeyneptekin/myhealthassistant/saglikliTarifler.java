package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class saglikliTarifler extends AppCompatActivity {

    private LinearLayout SaglikliTarif1;
    private LinearLayout SaglikliTarif2;
    private LinearLayout SaglikliTarif3;
    private LinearLayout SaglikliTarif4;
    private LinearLayout SaglikliTarif5;
    private LinearLayout SaglikliTarif6;
    private LinearLayout SaglikliTarif7;
    private LinearLayout SaglikliTarif8;
    private LinearLayout SaglikliTarif9;
    private LinearLayout SaglikliTarif10;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_saglikli_tarifler);

                // LinearLayout'leri bul ve tıklama olayını ayarla
                SaglikliTarif1 = findViewById(R.id.yesilBowlCard);
                SaglikliTarif1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif2.class);
                                System.out.println("Sağlıklı tarifler1 sayfasına geçti");
                                startActivity(intent);
                        }
                });

                // LinearLayout'leri bul ve tıklama olayını ayarla
                SaglikliTarif2 = findViewById(R.id.enerjiToplariCard);
                SaglikliTarif2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(saglikliTarifler.this, yesilBowlTarifi.class);
                                System.out.println("Sağlıklı tarifler2 sayfasına geçti");
                                startActivity(intent);
                        }
                });

                // LinearLayout'leri bul ve tıklama olayını ayarla
                SaglikliTarif3 = findViewById(R.id.granolaCard);
                SaglikliTarif3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(saglikliTarifler.this, saglikliTarif3.class);
                                System.out.println("Sağlıklı tarifler3 sayfasına geçti");
                                startActivity(intent);
                        }
                });


        }
}
