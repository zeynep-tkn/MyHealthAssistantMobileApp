package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class P3SportActivity extends AppCompatActivity {
    int[] newArray;
    List<TextView> successTextList;
    FirestoreHelper db = new FirestoreHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_sport);
        successTextList = new ArrayList<TextView>();

        for(int j = 1;j<=10;j++){
            String textName = "testText" + j;
            int resID = getResources().getIdentifier(textName, "id", getPackageName());
            TextView successText = findViewById(resID);
            successTextList.add(successText);
        }
        String exerciseName = "egzersiz3";
        FirestoreHelper.ProgressFetchListener listener = new FirestoreHelper.ProgressFetchListener() {
            @Override
            public void onProgressFetch(int progress) {
                // Firestore'dan alınan egzersiz değerini kullanarak istediğiniz işlemleri gerçekleştirin
                int progressNum = progress;
                for (TextView oneTextView:successTextList) {
                    oneTextView.setVisibility(View.GONE);
                }
                for (int i = 0;i<progressNum;i++) {
                    TextView selectedTextView = successTextList.get(i);
                    selectedTextView.setVisibility(View.VISIBLE);
                }
            }
        };
        db.showProgressForSportPage(exerciseName, listener);
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
                Intent intent=new Intent(P3SportActivity.this,P3Movement1Activity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);

            }
        }

    }


}