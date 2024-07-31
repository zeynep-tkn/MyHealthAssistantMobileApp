package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.Serializable;
import java.util.List;

public class Randevularim extends AppCompatActivity {
    private Button randevuEkleBtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevularim);

        context = this;
        FirestoreHelper firestoreHelper = new FirestoreHelper(this);

        // Firestore'dan randevu verilerini çekmek için metodu çağırın
        firestoreHelper.getRandevular(new FirestoreHelper.RandevuFetchListener() {
            @Override
            public void onRandevuFetchListener(List<String> stringList) {

            }

            @Override
            public void onRandevuFetch(List<Randevu> randevuList) {
                // Çekilen randevu verilerini kullanarak UI'da butonlar olarak görüntülemek için metodu çağırın
                showRandevular(randevuList);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        randevuEkleBtn = findViewById(R.id.RandevuEklebtn);
        randevuEkleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Randevu ekleme formu sayfasına geçiş yap
                Intent intent = new Intent(Randevularim.this, randevuEkleme.class);
                startActivity(intent);
            }
        });
    }

    public void showRandevular(List<Randevu> randevuList) {
        // LinearLayout veya başka bir layout kullanarak randevuların görüntülendiği bir konteyner oluşturun
        LinearLayout container = findViewById(R.id.randevuContainer);
        container.removeAllViews(); // Önceki butonları temizle

        // Her bir randevu için bir buton oluşturun ve konteynere ekleyin
        for (final Randevu randevu : randevuList) {
            // Inflate edilmiş button_layout.xml dosyasından bir View oluşturun
            View buttonLayout = getLayoutInflater().inflate(R.layout.button_layout, container, false);

            // Oluşturulan View içindeki custom_button'u bulun
            Button button = buttonLayout.findViewById(R.id.custom_button);

            // Butonun metnini bölüm, tarih, saat, doktor ve hastane bilgileri olarak ayarlayın
            String buttonText = "Bölüm: " + randevu.getBolum() + "\n" +
                    "Tarih: " + randevu.getTarih() + "\n" +
                    "Saat: " + randevu.getSaat() + "\n" +
                    "Doktor: " + randevu.getDoktor() + "\n" +
                    "Hastane: " + randevu.getHastahane();

            // Butona metni ayarlayın
            button.setText(buttonText);

            // Buton tıklama olayını ayarlayın
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, RandevuDetayActivity.class);
                    intent.putExtra("randevu", (Serializable) randevu);
                    startActivity(intent);
                }
            });
            // Butonu konteynere ekleyin
            container.addView(buttonLayout);
        }

    }
}
