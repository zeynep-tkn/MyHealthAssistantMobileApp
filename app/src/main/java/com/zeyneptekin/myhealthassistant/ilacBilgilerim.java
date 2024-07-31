package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.HashMap;
import java.util.Map;

public class ilacBilgilerim extends AppCompatActivity {

    private Button ilacEkleBtn;
    private Button ilacIsmiEkleBtn;
    private EditText editTextAlerjikIlacIsmiGirmeTxt;
    private EditText editTextIlacIsmiGirmeTxt;
    private EditText editTextDozajGirmeTxt;
    private EditText editTextAlmaSikligiGirmeTxt;
    private TableLayout ilaclarimTable;
    private TableLayout alerjilerimTable;
    private FirestoreHelper firestoreHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilac_bilgilerim);

        // FirestoreHelper sınıfını başlat
        firestoreHelper = new FirestoreHelper(this);

        // Gerekli bileşenleri bul
        ilacIsmiEkleBtn = findViewById(R.id.ilacEkleBtn);
        editTextIlacIsmiGirmeTxt = findViewById(R.id.ilacIsmiGirmeTxt);
        editTextDozajGirmeTxt = findViewById(R.id.dozajGirmeTxt);
        editTextAlmaSikligiGirmeTxt = findViewById(R.id.almaSikligiGirmeTxt);
        ilaclarimTable = findViewById(R.id.ilaçlarim_table);

        // İlaç ekleme butonuna tıklanınca işlem yap
        ilacIsmiEkleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten ilaç bilgilerini al
                String ilacIsmi = editTextIlacIsmiGirmeTxt.getText().toString().trim();
                String dozaj = editTextDozajGirmeTxt.getText().toString().trim();
                String almaSikligi = editTextAlmaSikligiGirmeTxt.getText().toString().trim();

                // FirestoreHelper üzerinden ilaç bilgisi eklemeyi çağır
                firestoreHelper.addIlacBilgisi(ilacIsmi, dozaj, almaSikligi);

                // Yeni bir satır oluştur
                TableRow newRow = new TableRow(ilacBilgilerim.this);

                // İlaç ismi EditText'i içeren yeni bir hücre oluştur
                EditText newEditTextIlacIsmi = new EditText(ilacBilgilerim.this);
                newEditTextIlacIsmi.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditTextIlacIsmi.setHint("İlaç İsmi");
                newEditTextIlacIsmi.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditTextIlacIsmi.setGravity(Gravity.CENTER_HORIZONTAL);

                // Dozaj EditText'i içeren yeni bir hücre oluştur
                EditText newEditTextDozaj = new EditText(ilacBilgilerim.this);
                newEditTextDozaj.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditTextDozaj.setHint("Dozaj");
                newEditTextDozaj.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditTextDozaj.setGravity(Gravity.CENTER_HORIZONTAL);

                // Alma Sıklığı EditText'i içeren yeni bir hücre oluştur
                EditText newEditTextAlmaSikligi = new EditText(ilacBilgilerim.this);
                newEditTextAlmaSikligi.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditTextAlmaSikligi.setHint("Alma Sıklığı");
                newEditTextAlmaSikligi.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditTextAlmaSikligi.setGravity(Gravity.CENTER_HORIZONTAL);

                // Hücreleri satıra ekle
                newRow.addView(newEditTextIlacIsmi);
                newRow.addView(newEditTextDozaj);
                newRow.addView(newEditTextAlmaSikligi);

                // Satırı tabloya ekle
                ilaclarimTable.addView(newRow);

                editTextIlacIsmiGirmeTxt = newEditTextIlacIsmi;
                editTextDozajGirmeTxt = newEditTextDozaj;
                editTextAlmaSikligiGirmeTxt = newEditTextAlmaSikligi;
            }
        });

        // SİL butonuna tıklandığında en son eklenen ilaç satırını kaldır
        Button deleteButtonIlaclarim = findViewById(R.id.ilacSilBtn);
        deleteButtonIlaclarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastRow(ilaclarimTable);
            }
        });
        ilacEkleBtn = findViewById(R.id.ilacAlerjisiEkleBtn);
        alerjilerimTable = findViewById(R.id.alerjilerim_table);
        editTextAlerjikIlacIsmiGirmeTxt = findViewById(R.id.alerjikIlacIsmiGirmeTxt);
        // Alerjik ilaç ekleme butonuna tıklanınca işlem yap
        ilacEkleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten ilaç bilgilerini al
                String alerjikIlacIsmi = editTextAlerjikIlacIsmiGirmeTxt.getText().toString().trim();

                // FirestoreHelper üzerinden ilaç bilgisi eklemeyi çağır
                firestoreHelper.addIlacAlerjisi(alerjikIlacIsmi);

                // Yeni bir satır oluştur
                TableRow newRow = new TableRow(ilacBilgilerim.this);

                // Alerjik ilaç ismi EditText'i içeren yeni bir hücre oluştur
                EditText newEditTextAlerjikIlacIsmi = new EditText(ilacBilgilerim.this);
                newEditTextAlerjikIlacIsmi.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditTextAlerjikIlacIsmi.setHint("Alerjik İlaç İsmi");
                newEditTextAlerjikIlacIsmi.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditTextAlerjikIlacIsmi.setGravity(Gravity.CENTER_HORIZONTAL);

                // Hücreleri satıra ekle
                newRow.addView(newEditTextAlerjikIlacIsmi);

                // Satırı tabloya ekle
                alerjilerimTable.addView(newRow);

                editTextAlerjikIlacIsmiGirmeTxt = newEditTextAlerjikIlacIsmi;
            }
        });

        // SİL butonuna tıklandığında en son eklenen alerjik ilaç satırını kaldır
        Button deleteButtonAlerji = findViewById(R.id.ilacAlerjisiSilBtn);
        deleteButtonAlerji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastRow(alerjilerimTable);
            }
        });
    }
    private void removeLastRow(TableLayout tableLayout) {
        int rowCount = tableLayout.getChildCount();
        if (rowCount > 0) {
            tableLayout.removeViewAt(rowCount - 1);
        }
    }
}
