package com.example.petcarehome;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CareGiverActivity extends AppCompatActivity {

    EditText editRegNo, editUsername, editFullName, editEmail, editPassword, editExperience;
    Button btnEdit, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_giver);

        editRegNo = findViewById(R.id.editRegNo);
        editUsername = findViewById(R.id.editUsername);
        editFullName = findViewById(R.id.editFullName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editExperience = findViewById(R.id.editExperience);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        // Load caregiver details and populate the EditText fields

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the code to update caregiver details
                // Update the database with new details
                Toast.makeText(CareGiverActivity.this, "Details Updated", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the code to delete caregiver account
                // Delete the account from the database
                Toast.makeText(CareGiverActivity.this, "Account Deleted", Toast.LENGTH_SHORT).show();
                finish(); // Close the CareGiverActivity after deletion
            }
        });
    }
}
