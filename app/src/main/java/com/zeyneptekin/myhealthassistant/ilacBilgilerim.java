package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ilacBilgilerim extends AppCompatActivity {

    private Button ilacEkleBtn;
    private Button ilacIsmiEkleBtn;
    private EditText alerjikIlacIsmiGirmeTxt;
    private EditText ilacIsmiGirmeTxt;
    private EditText dozajGirmeTxt;
    private EditText almaSikligiGirmeTxt;



    private FirestoreHelper firestoreHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilac_bilgilerim);

        // FirestoreHelper sınıfını başlat
        firestoreHelper = new FirestoreHelper(this);

        // Gerekli bileşenleri bul
        ilacEkleBtn = findViewById(R.id.ilacAlerjisiEkleBtn);
        ilacIsmiEkleBtn= findViewById(R.id.ilacEkleBtn);
        alerjikIlacIsmiGirmeTxt = findViewById(R.id.alerjikIlacIsmiGirmeTxt);
        ilacIsmiGirmeTxt = findViewById(R.id.ilacIsmiGirmeTxt);
        dozajGirmeTxt = findViewById(R.id.dozajGirmeTxt);
        almaSikligiGirmeTxt = findViewById(R.id.almaSikligiGirmeTxt);


        // Butona tıklanınca Firestore'a veri eklemek için onClickListener ekle
        ilacEkleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten ilaç ismini al
                String ilacIsmi = alerjikIlacIsmiGirmeTxt.getText().toString().trim();

                // FirestoreHelper üzerinden ilaç alerjisi eklemeyi çağır
                firestoreHelper.addIlacAlerjisi(ilacIsmi);
            }
        });

        ilacIsmiEkleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten ilaç ismi, dozaj ve alma sıklığını al
                String ilacIsmi = ilacIsmiGirmeTxt.getText().toString().trim();
                String dozaj = dozajGirmeTxt.getText().toString().trim();
                String almaSikligi = almaSikligiGirmeTxt.getText().toString().trim();

                // FirestoreHelper üzerinden ilaç bilgisi eklemeyi çağır
                firestoreHelper.addIlacBilgisi(ilacIsmi, dozaj, almaSikligi);
            }
        });

    }
}
