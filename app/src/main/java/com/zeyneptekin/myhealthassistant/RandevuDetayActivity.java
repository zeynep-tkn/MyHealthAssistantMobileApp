package com.zeyneptekin.myhealthassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class RandevuDetayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevu_detay);
    }

    // Düzenle butonuna tıklandığında çalışacak metod
    // Düzenle butonuna tıklandığında çalışacak metod
    public void onDuzenleButtonClick() {
        // "Düzenle" butonuna tıklandığında randevu düzenleme sayfasına geçiş yap
        Intent intent = new Intent(this, randevuEkleme.class);
        // Düzenleme işlemini belirlemek için ekstra veri ekle
        intent.putExtra("islem", "duzenleme");
        startActivity(intent);
    }

    public void onKapatButtonClick() {
        // "Kapat" butonuna tıklandığında detay sayfasını kapat
        finish();
    }

}
