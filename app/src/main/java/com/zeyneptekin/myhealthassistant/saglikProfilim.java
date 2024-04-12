package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class saglikProfilim extends AppCompatActivity {

    private Button SaglikGecmisim;
    private Button IlacBilgilerim;
    private Button IlerlemeTakibi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglik_profilim);

        // Butonu bul ve tıklama olayını ayarla
        SaglikGecmisim = findViewById(R.id.saglikGecmisimBtn);
        SaglikGecmisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sağlık Geçmişim sayfasına geçiş yap
                Intent intent = new Intent(saglikProfilim.this, saglikGecmisim.class);
                startActivity(intent);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        IlacBilgilerim = findViewById(R.id.ilacBilgilerimBtn);
        IlacBilgilerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // İlaç Bilgilerim sayfasına geçiş yap
                Intent intent = new Intent(saglikProfilim.this, ilacBilgilerim.class);
                startActivity(intent);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        IlerlemeTakibi = findViewById(R.id.ilerlemeTakibiBtn);
        IlerlemeTakibi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // İlerleem takibi sayfasına geçiş yap
                Intent intent = new Intent(saglikProfilim.this, ilerlemeTakibi.class);
                startActivity(intent);
            }
        });


    }
}
