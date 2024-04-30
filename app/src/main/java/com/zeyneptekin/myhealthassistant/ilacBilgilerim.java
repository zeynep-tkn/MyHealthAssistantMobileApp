package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ilacBilgilerim extends AppCompatActivity {

    private Button ilacEkleBtn;
    private EditText alerjikIlacIsmiGirmeTxt;

    private FirestoreHelper firestoreHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilac_bilgilerim);

        // FirestoreHelper sınıfını başlat
        firestoreHelper = new FirestoreHelper(this);

        // Gerekli bileşenleri bul
        ilacEkleBtn = findViewById(R.id.ilacAlerjisiEkleBtn);
        alerjikIlacIsmiGirmeTxt = findViewById(R.id.alerjikIlacIsmiGirmeTxt);

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
    }
}
