package com.example.appdevprojext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
     Button loginBtn, createAccBtn;
     private storeUserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        loginBtn = findViewById(R.id.loginBtn);
        createAccBtn = findViewById(R.id.createaccBtn);

        loginBtn.setOnClickListener(view ->{
        String username = "aya";
        String password = "123";
        String vali1 = userPreferences.getUsername();
        String vali2 = userPreferences.getPassword();
        if(vali1.equals(username) && vali2.equals(password)){
            Intent goToHomepage = new Intent(this, HomePage.class);
            startActivity(goToHomepage);
            }
        else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
        });

        createAccBtn.setOnClickListener(view ->{
            Intent createAccPage = new Intent(this, CreatePage1.class);
            startActivity(createAccPage);
        });
    }
}