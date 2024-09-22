package com.example.petcarehome;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaregiverDetails extends AppCompatActivity {

    private TextView regNoTextView, unameTextView, fnameTextView, emailTextView,
            pnoTextView, passwordTextView, skillsTextView, priceTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver_detaills);

        // Initialize TextViews
        regNoTextView = findViewById(R.id.RegNo);
        unameTextView = findViewById(R.id.Uname);
        fnameTextView = findViewById(R.id.FullName);
        emailTextView = findViewById(R.id.Email);
        pnoTextView = findViewById(R.id.Pno);
        passwordTextView = findViewById(R.id.Password1);
        skillsTextView = findViewById(R.id.Experience);

        // Retrieve Caregiver data from Intent
        Caregiver selectedCaregiver = getIntent().getParcelableExtra("selectedCaregiver");

        // Display Caregiver details
        if (selectedCaregiver != null) {
            regNoTextView.setText(selectedCaregiver.getRegNo());
            unameTextView.setText(selectedCaregiver.getUName());
            fnameTextView.setText(selectedCaregiver.getFName());
            emailTextView.setText(selectedCaregiver.getEmail());
            pnoTextView.setText(selectedCaregiver.getPno());
            passwordTextView.setText(selectedCaregiver.getPassword());
            skillsTextView.setText(selectedCaregiver.getExperience());
            priceTextView.setText(selectedCaregiver.getPrice());
        }
    }
}
