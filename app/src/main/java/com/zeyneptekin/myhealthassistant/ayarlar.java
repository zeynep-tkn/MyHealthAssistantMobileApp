package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ayarlar extends AppCompatActivity {

    private Button GizlilikVeGüvenlik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        // Butonu bul ve tıklama olayını ayarla
        GizlilikVeGüvenlik = findViewById(R.id.gizlilikVeGüvenlikBtn);
        GizlilikVeGüvenlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hakkında sayfasına geçiş yap
                Intent intent = new Intent(ayarlar.this, gizlilikVeGuvenlik.class);
                startActivity(intent);
            }
        });
    }
}
