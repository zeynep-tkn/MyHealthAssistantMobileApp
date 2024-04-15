package com.zeyneptekin.myhealthassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class RegisterActivity extends AppCompatActivity {
   private EditText editEmail, editSifre;
   private String txtEmail, txtSifre;
   private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editEmail =(EditText)findViewById(R.id.emailEditText);
        editSifre =(EditText)findViewById(R.id.passwordEditText);
        mAuth =FirebaseAuth.getInstance();

        TextView btn=findViewById(R.id.loginTextView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public void kayitOl (View view){
        txtEmail=editEmail.getText().toString();
        txtSifre=editSifre.getText().toString();
        if(!TextUtils.isEmpty(txtEmail)&& !TextUtils.isEmpty(txtSifre)){
          mAuth.createUserWithEmailAndPassword(txtEmail,txtSifre)
                  .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Toast.makeText(RegisterActivity.this,"Kayıt işlemi başarılı.",Toast.LENGTH_SHORT).show();
                          }
                          else
                              Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                      }
                  });

        }else{
            Toast.makeText(this,"Email veya şifre boş olamaz!",Toast.LENGTH_SHORT).show();
        }
    }



}