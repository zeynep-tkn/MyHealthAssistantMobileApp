package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Randevularim extends AppCompatActivity {

    private Button RandevuEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevularim);

        // Butonu bul ve tıklama olayını ayarla
        RandevuEkle = findViewById(R.id.RandevuEklebtn); // 'view' değişkeni kaldırıldı
        RandevuEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 'view' değişkeni 'v' olarak değiştirildi
                // Randevu ekleme formu sayfasına geçiş yap
                Intent intent = new Intent(Randevularim.this, randevuEkleme.class); // 'getActivity()' değiştirildi
                startActivity(intent);
            }
        });

    }
}
