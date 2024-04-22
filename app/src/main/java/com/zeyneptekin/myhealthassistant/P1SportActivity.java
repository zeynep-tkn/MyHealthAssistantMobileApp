package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class P1SportActivity extends AppCompatActivity {
    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_sport);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        newArray =new int[]{
                R.id.bir_pose,R.id.iki_pose,R.id.uc_pose,R.id.dort_pose,R.id.bes_pose,
                R.id.alti_pose,R.id.yedi_pose,R.id.sekiz_pose,R.id.dokuz_pose,R.id.on_pose,

        };
    }

    public void ImageButtonClicked(View view) {
      for(int i=0;i<newArray.length;i++){
       if(view.getId()==newArray[i]){
         int value=i+1;
           Log.i("First",String.valueOf(value));
           Intent intent=new Intent(P1SportActivity.this,P1Movement1Activity.class);
           intent.putExtra("value",String.valueOf(value));
           startActivity(intent);
          
       }
      }

    }

    
}