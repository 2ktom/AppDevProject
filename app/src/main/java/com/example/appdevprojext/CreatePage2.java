package com.example.appdevprojext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class CreatePage2 extends AppCompatActivity {


    private String selectedItem;
    private storeUserPreferences storePreferences;
    private AutoCompleteTextView autoCompleteTextView;
    private Button finishBtn;
    private EditText answer;



    String[] questions = {
            "What is your grandfather’s last name?",
            "What is your first pet's name?",
            "What color do you like the most?",
            "What year did you enter college?",
            "What is your child’s nickname?"
    };

    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountcreatep2);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        answer = findViewById(R.id.answer);
        finishBtn = findViewById(R.id.FinishBtn);


        String usName = getIntent().getStringExtra("username"); // Retrieve username from previous activity
        String pass1 = getIntent().getStringExtra("password"); // Retrieve password from previous activity
        storePreferences = new storeUserPreferences(this);

        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, questions);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                 selectedItem = (String) parent.getItemAtPosition(position);
            }
        });

        finishBtn.setOnClickListener(view ->{
            //Retrieve username and password from previous activity and then store it in the storeUserPreferences class.
            // usName = where username from previous activity is stored
            // pass1 is the password

            String username = usName;
            String password = pass1;
            String securityQuestion = selectedItem;
            String securityAnswer = answer.getText().toString();

            storePreferences.saveUserData(username, password, securityQuestion, securityAnswer);
            Intent endSignUp = new Intent(this, LoginPage.class);
            Toast.makeText(this, "Account successfully created", Toast.LENGTH_SHORT).show();
            startActivity(endSignUp);
        });
    }
}