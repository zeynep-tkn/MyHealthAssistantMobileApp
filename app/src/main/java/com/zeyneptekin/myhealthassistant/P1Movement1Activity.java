package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class P1Movement1Activity extends AppCompatActivity {
    String buttonvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_movement1);

        Intent intent=getIntent();
        buttonvalue=intent.getStringExtra("value");

        int intvalue=Integer.valueOf(buttonvalue);

        switch (intvalue){
            case 1:
                setContentView(R.layout.activity_bir);
            break;
            case 2:
                setContentView(R.layout.activity_iki);
                break;
            case 3:
                setContentView(R.layout.activity_uc);
                break;
            case 4:
                setContentView(R.layout.activity_dort);
                break;
            case 5:
                setContentView(R.layout.activity_bes);
                break;
            case 6:
                setContentView(R.layout.activity_alti);
                break;
            case 7:
                setContentView(R.layout.activity_yedi);
                break;
            case 8:
                setContentView(R.layout.activity_sekiz);
                break;
            case 9:
                setContentView(R.layout.activity_dokuz);
                break;
            case 10:
                setContentView(R.layout.activity_on);
                break;
        }

    }
}