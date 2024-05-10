package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class randevuEkleme extends AppCompatActivity {

    private Button yeniRandevuEkle;
    private Button yeniRandevudanVazgec;
    private EditText bolumGirTxt;
    private EditText tarihGirTxt;
    private EditText saatGirTxt;
    private EditText doktorGirTxt;
    private EditText hastahaneGirTxt;

    private FirestoreHelper firestoreHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevu_ekleme);

        firestoreHelper = new FirestoreHelper(this);

        // EditText alanlarını tanımla
        bolumGirTxt = findViewById(R.id.bolumGirTxt);
        tarihGirTxt = findViewById(R.id.tarihGirTxt);
        saatGirTxt = findViewById(R.id.saatGirTxt);
        doktorGirTxt = findViewById(R.id.doktorGirTxt);
        hastahaneGirTxt = findViewById(R.id.hastahaneGİrTxt);

        yeniRandevuEkle = findViewById(R.id.yenirandevuEkleBtn);
        yeniRandevudanVazgec = findViewById(R.id.randevuEklemektenVazgecBtn);

        yeniRandevuEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bolum = bolumGirTxt.getText().toString().trim();
                String tarih = tarihGirTxt.getText().toString().trim();
                String saat = saatGirTxt.getText().toString().trim();
                String doktor = doktorGirTxt.getText().toString().trim();
                String hastahane = hastahaneGirTxt.getText().toString().trim();

                // Veritabanına veri ekleme metodunu çağır
                firestoreHelper.addRandevuBilgisi(bolum, tarih, saat, doktor, hastahane);

                // AlertDialog ile onay mesajı göster
                AlertDialog.Builder uyari = new AlertDialog.Builder(randevuEkleme.this);
                uyari.setTitle("ONAY");
                uyari.setMessage("Yeni randevu ekleme işlemi başarı ile gerçekleştirilmiştir.");
                uyari.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
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
                AlertDialog.Builder uyari = new AlertDialog.Builder(randevuEkleme.this);
                uyari.setTitle("DİKKAT");
                uyari.setMessage("Yeni randevu EKLENEMEDİ.");
                uyari.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
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
