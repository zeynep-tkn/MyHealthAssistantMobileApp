package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;

public class saglikProfilim extends AppCompatActivity {

    private Button SaglikGecmisim;
    private Button IlacBilgilerim;
    private Spinner spinnerKilo, spinnerGender, spinnerBlood, spinnerLength, spinnerDogumTarihi;
    private DatePicker datePicker;
    private ArrayAdapter<CharSequence> adapterGender;
    private ArrayAdapter<CharSequence> adapterBlood;
    private ArrayList<Integer> kiloList;
    private ArrayList<Integer> lengthList;
    private TextView vucutKitleIndeksiTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglik_profilim);

        init();

        datePicker = findViewById(R.id.dogumTarihiDatePicker);

        datePicker.init(2000, 0, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Burada tarih seçimi ile ilgili işlemleri yapabilirsiniz, eğer gerekliyse.
            }
        });

        SaglikGecmisim = findViewById(R.id.saglikGecmisimBtn);
        SaglikGecmisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(saglikProfilim.this, saglikGecmisim.class);
                startActivity(intent);
            }
        });

        IlacBilgilerim = findViewById(R.id.ilacBilgilerimBtn);
        IlacBilgilerim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(saglikProfilim.this, ilacBilgilerim.class);
                startActivity(intent);
            }
        });
        vucutKitleIndeksiTxt = findViewById(R.id.vucutKitleİndeksiHesaplamaTxt);

    }
    public void hesaplaVKI(View view) {
        hesaplaVeGoster();
    }

    private void init() {
        spinnerGender = findViewById(R.id.cinsiyetSpinner);
        adapterGender = ArrayAdapter.createFromResource(this, R.array.GenderList, android.R.layout.simple_spinner_item);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapterGender);

        spinnerBlood = findViewById(R.id.kanGrubuSpinner);
        adapterBlood = ArrayAdapter.createFromResource(this, R.array.BloodTypeList, android.R.layout.simple_spinner_item);
        adapterBlood.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBlood.setAdapter(adapterBlood);

        spinnerKilo = findViewById(R.id.kiloSpinner);
        kiloList = new ArrayList<>();
        for (int i = 30; i <= 150; i++)
            kiloList.add(i);
        ArrayAdapter<Integer> adapterKilo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kiloList);
        spinnerKilo.setAdapter(adapterKilo);

        spinnerLength = findViewById(R.id.boySpinner);
        lengthList = new ArrayList<>();
        for (int i = 110; i <= 210; i++)
            lengthList.add(i);
        ArrayAdapter<Integer> adapterLength = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengthList);
        spinnerLength.setAdapter(adapterLength);
    }

    public void showDatePicker(View view) {
        showDatePickerDialog();
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(saglikProfilim.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        EditText editText = findViewById(R.id.dogumTarihiEditText);
                        editText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    private void hesaplaVeGoster() {
        int kilo = Integer.parseInt(spinnerKilo.getSelectedItem().toString());
        int boy = Integer.parseInt(spinnerLength.getSelectedItem().toString());
        double vki = kilo / ((boy / 100.0) * (boy / 100.0));
        vucutKitleIndeksiTxt.setText(String.format("%.2f", vki) + " kg/m²");
    }

}
