package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class randevuEkleme extends AppCompatActivity {

    private Button yeniRandevuEkle;
    private Button yeniRandevudanVazgec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevu_ekleme);

        // Butonları bul ve tıklama olaylarını ayarla
        yeniRandevuEkle = findViewById(R.id.yenirandevuEkleBtn);
        yeniRandevudanVazgec = findViewById(R.id.randevuEklemektenVazgecBtn);

        yeniRandevuEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "Ekle" butonuna tıklandığında ekrana uygun uyarı mesajını göster
                AlertDialog.Builder uyari = new AlertDialog.Builder(randevuEkleme.this);
                uyari.setTitle("ONAY");
                uyari.setMessage("Yeni randevu ekleme işlemi başarı ile gerçekleştirilmiştir.");
                uyari.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Randevularim sayfasına geçiş yap
                        Intent intent = new Intent(randevuEkleme.this, Randevularim.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = uyari.create();
                alertDialog.show();
            }
        });

        yeniRandevudanVazgec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "Vazgeç" butonuna tıklandığında ekrana uygun uyarı mesajını göster
                AlertDialog.Builder uyari = new AlertDialog.Builder(randevuEkleme.this);
                uyari.setTitle("DİKKAT");
                uyari.setMessage("Randevu ekleme işlemi gerçekleştirilmemiştir.");
                uyari.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Randevularim sayfasına geçiş yap
                        Intent intent = new Intent(randevuEkleme.this, Randevularim.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = uyari.create();
                alertDialog.show();
            }
        });
    }
}
