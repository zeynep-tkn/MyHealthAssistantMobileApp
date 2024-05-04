package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class saglikGecmisim extends AppCompatActivity {

    private TableLayout hastaliklarimTable;
    private TableLayout alerjilerimTable;
    private TableLayout ameliyatlarimTable;
    private Button addRowButtonhastaliklarim;
    private Button addRowButtonameliyatlarim;
    private Button addRowButtonalerjilerim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglik_gecmisim);

        hastaliklarimTable = findViewById(R.id.hastaliklarim_table);
        addRowButtonhastaliklarim = findViewById(R.id.addRowButtonHastalik);

        addRowButtonhastaliklarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yeni bir satır oluştur
                TableRow newRow = new TableRow(saglikGecmisim.this);

                // EditText'i içeren yeni bir hücre oluştur
                EditText newEditText = new EditText(saglikGecmisim.this);
                newEditText.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditText.setHint("Hastalık ismi");
                newEditText.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditText.setGravity(Gravity.CENTER_HORIZONTAL);
                newEditText.setGravity(Gravity.CENTER); // Yazıyı ortala

                // Hücreyi satıra ekle
                newRow.addView(newEditText);

                // Satırı tabloya ekle
                hastaliklarimTable.addView(newRow);
            }
        });

        // SİL butonuna tıklandığında en son eklenen hastalık satırını kaldır
        Button deleteButtonHastalik = findViewById(R.id.deleteButtonHastalik);
        deleteButtonHastalik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastRow(hastaliklarimTable);
            }
        });

        alerjilerimTable = findViewById(R.id.alerjilerim_table);
        addRowButtonalerjilerim = findViewById(R.id.addRowButtonAlerji);

        addRowButtonalerjilerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yeni bir satır oluştur
                TableRow newRow = new TableRow(saglikGecmisim.this);

                // EditText'i içeren yeni bir hücre oluştur
                EditText newEditText = new EditText(saglikGecmisim.this);
                newEditText.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditText.setHint("Alerji ismi");
                newEditText.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditText.setGravity(Gravity.CENTER_HORIZONTAL);
                newEditText.setGravity(Gravity.CENTER); // Yazıyı ortala

                // Hücreyi satıra ekle
                newRow.addView(newEditText);

                // Satırı tabloya ekle
                alerjilerimTable.addView(newRow);
            }
        });

        // SİL butonuna tıklandığında en son eklenen alerji satırını kaldır
        Button deleteButtonAlerji = findViewById(R.id.deleteButtonAlerji);
        deleteButtonAlerji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastRow(alerjilerimTable);
            }
        });

        ameliyatlarimTable = findViewById(R.id.ameliyatlarim_table);
        addRowButtonameliyatlarim = findViewById(R.id.addRowButtonAmeliyat);

        addRowButtonameliyatlarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yeni bir satır oluştur
                TableRow newRow = new TableRow(saglikGecmisim.this);

                // Ameliyat ismi EditText'i içeren yeni bir hücre oluştur
                EditText newEditTextAmeliyatAdi = new EditText(saglikGecmisim.this);
                newEditTextAmeliyatAdi.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditTextAmeliyatAdi.setHint("Ameliyat İsmi");
                newEditTextAmeliyatAdi.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditTextAmeliyatAdi.setGravity(Gravity.CENTER_HORIZONTAL);

                // Ameliyat tarihi EditText'i içeren yeni bir hücre oluştur
                EditText newEditTextAmeliyatTarihi = new EditText(saglikGecmisim.this);
                newEditTextAmeliyatTarihi.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                newEditTextAmeliyatTarihi.setHint("Ameliyat Tarihi");
                newEditTextAmeliyatTarihi.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                newEditTextAmeliyatTarihi.setGravity(Gravity.CENTER_HORIZONTAL);

                // Hücreleri satıra ekle
                newRow.addView(newEditTextAmeliyatAdi);
                newRow.addView(newEditTextAmeliyatTarihi);

                // Satırı tabloya ekle
                ameliyatlarimTable.addView(newRow);
            }
        });

        // SİL butonuna tıklandığında en son eklenen hastalık satırını kaldır
        Button deleteButtonAmeliyat = findViewById(R.id.deleteButtonAmeliyat);
        deleteButtonAmeliyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastRow(ameliyatlarimTable);
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
