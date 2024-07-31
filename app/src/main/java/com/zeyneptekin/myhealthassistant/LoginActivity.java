package com.zeyneptekin.myhealthassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText editEmail, editSifre;
    private String txtEmail,txtSifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail =(EditText)findViewById(R.id.emailEdit);
        editSifre =(EditText)findViewById(R.id.passwordEdit);
        mAuth =FirebaseAuth.getInstance();

        TextView btn=findViewById(R.id.registerTextView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void girisYap(){
        txtEmail=editEmail.getText().toString();
        txtSifre=editSifre.getText().toString();
        if(!TextUtils.isEmpty(txtEmail)&&!TextUtils.isEmpty(txtSifre)){
            mAuth.signInWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser=mAuth.getCurrentUser();
                            System.out.println("Kullanıcı email:"+mUser.getEmail());
                            System.out.println("Kullanıcı Uid:"+mUser.getUid());
                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this,"Email ve şifre boş olamaz",Toast.LENGTH_SHORT).show();
        }
    }
}