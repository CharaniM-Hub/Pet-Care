package com.example.petcarehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CareGiverSignUp extends AppCompatActivity {

    EditText mRegno, mUsername, mFName, mEmail, mSPassword, mPassword, mExperience;
    Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver_sign_up);

        mRegno = findViewById(R.id.RegNo);
        mUsername = findViewById(R.id.UserName);
        mFName = findViewById(R.id.FullName);
        mEmail = findViewById(R.id.Email);
        mSPassword = findViewById(R.id.Password1);
        mPassword = findViewById(R.id.ConfirmPassword);
        mExperience = findViewById(R.id.Experience);
        mSignUp = findViewById(R.id.ButtonSignUp);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerCareGiver();
            }
        });
    }

    private void registerCareGiver() {
        String RegisterNo = mRegno.getText().toString().trim();
        String username = mUsername.getText().toString().trim();
        String Full_name = mFName.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String confirm = mSPassword.getText().toString().trim();
        String Experience = mExperience.getText().toString().trim();

        DatabaseHelper DB = new DatabaseHelper(this);

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill All Details", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals(confirm)) {
                if (DB.isValid(password)) {
                    DB.CareGiverSignUp(RegisterNo, username, Full_name, email, password, Experience);
                    Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CareGiverSignUp.this, SigninUser.class));
                    finish(); // close the activity after registration
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Password format", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
