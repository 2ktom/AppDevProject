package com.example.appdevprojext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class
CreatePage1 extends AppCompatActivity {
     Button nextBtn;

     EditText firstPass, confirmPw, txtUser;

    private storeUserPreferences storeUserPref;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountcreatep1);

        storeUserPref = new storeUserPreferences(this);
        nextBtn = findViewById(R.id.next_SignUpBtn);

        txtUser = findViewById(R.id.UserName_SignUp);
        firstPass = findViewById(R.id.firstPass);
        confirmPw = findViewById(R.id.ConfirmPass);




        nextBtn.setOnClickListener(view -> {
            String pass1 = firstPass.getText().toString();
            String pass2 = confirmPw.getText().toString();
            String usName = txtUser.getText().toString();
                if(pass1.equals(pass2)){
                    Intent createPage2 = new Intent(this, CreatePage2.class);
                    createPage2.putExtra("username", usName);
                    createPage2.putExtra("password", pass1);
                    startActivity(createPage2);
                }
                else{
                    Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}