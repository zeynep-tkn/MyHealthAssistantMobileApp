package com.zeyneptekin.myhealthassistant;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

 public class saglikGecmisim extends AppCompatActivity {
    private TableLayout hastaliklarimTable;
    private EditText editText1;
    private EditText editTextAlerji;
    private EditText editTextAmeliyatAdi;
    private EditText editTextAmeliyatTarihi;
    private TableLayout alerjilerimTable;
    private TableLayout ameliyatlarimTable;
    private Button addRowButtonhastaliklarim;
    private Button addRowButtonameliyatlarim;
    private Button addRowButtonalerjilerim;
    private Button deleteButtonHastalik;

    private FirestoreHelper db = new FirestoreHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglik_gecmisim);
        // FirestoreHelper sınıfını başlat
        addRowButtonhastaliklarim = findViewById(R.id.addRowButtonHastalik);
        deleteButtonHastalik = findViewById(R.id.deleteButtonHastalik);
        editText1 = findViewById(R.id.editText1);
        hastaliklarimTable = findViewById(R.id.hastaliklarim_table);
        alerjilerimTable = findViewById(R.id.alerjilerim_table);
        ameliyatlarimTable = findViewById(R.id.ameliyatlarim_table);

        alerjilerimTable = findViewById(R.id.alerjilerim_table);
        addRowButtonalerjilerim = findViewById(R.id.addRowButtonAlerji);
        editTextAlerji = findViewById(R.id.editTextAlerji);

        //
        editText1.setVisibility(View.GONE);
        db.GetHastalıklarımTable(new FirestoreHelper.StringListFetchListener() {
            @Override
            public void onStringListFetched(List<String> stringList) {
                editText1.setVisibility(View.GONE);
                removeLastRow(hastaliklarimTable);
                editText1.setVisibility(View.GONE);
                int sayac = 0;
                while(stringList == null){

                }
                for (String hastalik : stringList) {
                    AddRowToTable(hastaliklarimTable, hastalik);
                }
                AddEditTextRowToTable(hastaliklarimTable,editText1);
                //editText1.setVisibility(View.VISIBLE);
            }
        });

        //Alerjilerim Kısmı Database çağrısı
        editTextAlerji.setVisibility(View.GONE);    //bunu iki defa yapıyorum, normalde tek sefer yapsam da olur ama ne olur ne olmaz 2 defa yaptım.
        db.GetAlerjilerimTable(new FirestoreHelper.AlerjilerimDatabaseListener() {
            @Override
            public void getAlerjilerim(List<String> stringList) {
                editTextAlerji.setVisibility(View.GONE);
                removeLastRow(alerjilerimTable);
                editTextAlerji.setVisibility(View.GONE);
                int sayac = 0;
                while(stringList == null){
                }   //Bekleme süresi oluşturması için
                for (String alerji : stringList) {
                    AddRowToTable(alerjilerimTable, alerji);
                }
                AddEditTextRowToTable(alerjilerimTable,editTextAlerji);
                //editTextAlerji.setVisibility(View.VISIBLE);
            }
        });

        deleteButtonHastalik.setVisibility(View.GONE);
        addRowButtonhastaliklarim.setVisibility(View.GONE);
        if(hastaliklarimTable.getChildCount() != 0 && alerjilerimTable.getChildCount() !=0){
            AddEditTextRowToTable(hastaliklarimTable,editText1);
            AddEditTextRowToTable(alerjilerimTable,editTextAlerji);

            //deleteButtonHastalik.setVisibility(View.VISIBLE);
            //addRowButtonhastaliklarim.setVisibility(View.VISIBLE);
        }



        addRowButtonhastaliklarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yeni bir Firestore belgesi oluştur
                Map<String, Object> hastalikIsmi = new HashMap<>();
                String hastalikBilgisi = ""; // Boş bir String oluşturun
                hastalikBilgisi = editText1.getText().toString();
                db.addHastalikBilgisi(hastalikBilgisi);
                // Yeni bir satır oluştur
                removeLastRowAndChangeToTextView(hastaliklarimTable);
                TableRow newRow = new TableRow(saglikGecmisim.this);

                // EditText'i içeren yeni bir hücre oluştur
                EditText hastalikGirisText = new EditText(saglikGecmisim.this);
                hastalikGirisText.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                hastalikGirisText.setHint("Hastalık ismi");
                hastalikGirisText.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                hastalikGirisText.setGravity(Gravity.CENTER_HORIZONTAL);
                hastalikGirisText.setGravity(Gravity.CENTER); // Yazıyı ortala
                // Hücreyi satıra ekle
                newRow.addView(hastalikGirisText);
                // Satırı tabloya ekle
                hastaliklarimTable.addView(newRow);
                editText1 = hastalikGirisText;
                // SİL butonuna tıklandığında en son eklenen hastalık satırını kaldır
                Button deleteButtonHastalik = findViewById(R.id.deleteButtonHastalik);
                deleteButtonHastalik.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeLastRow(hastaliklarimTable);
                    }
                });
            }
        });
<<<<<<< HEAD
=======
        alerjilerimTable = findViewById(R.id.alerjilerim_table);
        addRowButtonalerjilerim = findViewById(R.id.addRowButtonAlerji);
        editTextAlerji = findViewById(R.id.editTextAlerji);


>>>>>>> d5022a3be801ca7f80c619f36c928cf6fb7324d9

        addRowButtonalerjilerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yeni bir Firestore belgesi oluştur
                Map<String, Object> alerjiIsmi = new HashMap<>();
                String alerjiBilgisi = ""; // Boş bir String oluşturun
                alerjiBilgisi = editTextAlerji.getText().toString();
                db.addAlerjiBilgisi(alerjiBilgisi);
                // Yeni bir satır oluştur
                removeLastRowAndChangeToTextView(alerjilerimTable);
                TableRow newRow = new TableRow(saglikGecmisim.this);
                // EditText'i içeren yeni bir hücre oluştur
                EditText alerjiGirisText = new EditText(saglikGecmisim.this);
                alerjiGirisText.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1f));
                alerjiGirisText.setHint("Alerji ismi");
                alerjiGirisText.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
                alerjiGirisText.setGravity(Gravity.CENTER_HORIZONTAL);
                alerjiGirisText.setGravity(Gravity.CENTER); // Yazıyı ortala
                // Hücreyi satıra ekle
                newRow.addView(alerjiGirisText);
                // Satırı tabloya ekle
                alerjilerimTable.addView(newRow);
                editTextAlerji = alerjiGirisText;
                // SİL butonuna tıklandığında en son eklenen hastalık satırını kaldır
                Button deleteButtonAlerji = findViewById(R.id.deleteButtonAlerji);
                deleteButtonAlerji.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeLastRow(alerjilerimTable);
                    }
                });
            }
        });

        ameliyatlarimTable = findViewById(R.id.ameliyatlarim_table);
        editTextAmeliyatAdi = findViewById(R.id.editTextAmeliyatAdi);
        editTextAmeliyatTarihi = findViewById(R.id.editTextAmeliyatTarihi);
        addRowButtonameliyatlarim = findViewById(R.id.addRowButtonAmeliyat);

        addRowButtonameliyatlarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Yeni bir Firestore belgesi oluştur
                Map<String, Object> ameliyatIsmi = new HashMap<>();

                String ameliyatBilgisi = ""; // Boş bir String oluşturun

                ameliyatBilgisi = editTextAmeliyatAdi.getText().toString();

                String ameliyatTarihi = ""; // Boş bir String oluşturun

                ameliyatTarihi = editTextAmeliyatTarihi.getText().toString();

                db.addAmeliyatBilgisi(ameliyatBilgisi, ameliyatTarihi);


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

                editTextAmeliyatAdi = newEditTextAmeliyatAdi;
                editTextAmeliyatTarihi = newEditTextAmeliyatTarihi;
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
     private void removeLastRowAndChangeToTextView(TableLayout tableLayout) {
         int rowCount = tableLayout.getChildCount();
         if (rowCount > 0) {
             TableRow lastRow = (TableRow) tableLayout.getChildAt(rowCount - 1);
             if (lastRow != null && lastRow.getChildCount() > 0) {
                 TextView textView = new TextView(this); // Yeni bir TextView oluştur
                 EditText lastEditText = (EditText) lastRow.getChildAt(0); // Son EditText'i al
                 String text = lastEditText.getText().toString(); // EditText'ten metni al
                 textView.setText(text); // TextView'e metni ata
                 // İhtiyacınıza göre TextView'i özelleştirin (boyut, renk, vs.)
                 textView.setLayoutParams(new TableRow.LayoutParams(
                         TableRow.LayoutParams.MATCH_PARENT,
                         TableRow.LayoutParams.WRAP_CONTENT, 1f));
                 textView.setTextSize(14);
                 textView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER);
                 // Yeni TextView'i içeren yeni bir satır oluştur
                 TableRow newRow = new TableRow(this);
                 removeLastRow(tableLayout);
                 newRow.addView(textView); // TextView'i satıra ekle
                 tableLayout.addView(newRow); // Yeni satırı tabloya ekle
             }
         }
     }

     private void AddRowToTable(TableLayout tableLayout,String data){
        TableRow newRow = new TableRow(saglikGecmisim.this);
        TextView oldHastalikInfoText = new TextView(saglikGecmisim.this);
        oldHastalikInfoText.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT, 1f));
        oldHastalikInfoText.setHint("Hastalık ismi");
        oldHastalikInfoText.setText(data);
        oldHastalikInfoText.setTextSize(14); // Yazı boyutunu 14sp olarak ayarla
        oldHastalikInfoText.setGravity(Gravity.CENTER_HORIZONTAL);
        oldHastalikInfoText.setGravity(Gravity.CENTER); // Yazıyı ortala

        // Hücreyi satıra ekle
        newRow.addView(oldHastalikInfoText);
        // Satırı tabloya ekle
         tableLayout.addView(newRow);
    }

     private void AddEditTextRowToTable(TableLayout tableLayout,EditText _editText) {
         // Yeni bir satır oluştur
         TableRow newRow = new TableRow(this);

         // EditText içeren hücre oluştur
         EditText editText = new EditText(this);
         editText.setLayoutParams(new TableRow.LayoutParams(
                 0,
                 TableRow.LayoutParams.WRAP_CONTENT, 1f));
         editText.setHint("Alerji İsmi");
         editText.setTextSize(14);
         editText.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER);
         _editText = editText;
         // Hücreyi satıra ekle
         newRow.addView(editText);

         // Satırı tabloya ekle
         tableLayout.addView(newRow);
     }
}