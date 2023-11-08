package com.example.appdevprojext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccount extends AppCompatActivity {
    private Button nextBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountcreatep1);

        nextBtn = (Button) findViewById(R.id.next_SignUpBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateAccount2();
            }
        });
    }

    public void openCreateAccount2() {
        Intent intent = new Intent(this, CreateAccount2.class);
        startActivity(intent);
    }
}