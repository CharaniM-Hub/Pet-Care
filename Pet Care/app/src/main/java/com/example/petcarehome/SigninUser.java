package com.example.petcarehome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninUser extends AppCompatActivity {

    EditText edituserName, editPassword,editusertye;
    Button btn;
    TextView Signup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinuser);

        edituserName = findViewById(R.id.editTxtUserName);
        editPassword = findViewById(R.id.editTxtPassword);
        editusertye=findViewById(R.id.usertype);
        btn = findViewById(R.id.signIn);
        Signup = findViewById(R.id.textView);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String message="Welcome to Pet Care Home.We protect your pet like you do.";
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

                    Intent go = new Intent(getApplicationContext(), CustomerSignUp.class);
                    startActivity(go);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edituserName.getText().toString();
                String password = editPassword.getText().toString();
                String usertye=editusertye.getText().toString();
                DatabaseHelper DB = new DatabaseHelper(getApplicationContext());
                if (username.length() == 0 || password.length() == 0 || usertye.length() == 0 ) {
                    Toast.makeText(getApplicationContext(), "Please fill All Details", Toast.LENGTH_SHORT).show();
                } else {
                    int signInResult = DB.Signin(username, password,usertye);
                    if (signInResult == 1) {


                        if ("Pet Owner".equals(usertye)) {
                           Intent intent = new Intent(SigninUser.this, PetOwnerActivity.class);
                           startActivity(intent);// Change to the appropriate Pet Owner activity
                        } else if ("Care giver".equals(usertye)) {
                            Intent intent = new Intent(SigninUser.this, CareGiverActivity.class);
                            startActivity(intent);// Change to the appropriate Care Giver activity
                        } else {
                            // Handle other user types or scenarios
                            Toast.makeText(getApplicationContext(), "Unknown User Type", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        finish(); // Finish the current activity
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid User Name and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}