package com.example.petcarehome;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PetOwnerActivity extends AppCompatActivity {

    EditText editTextPetName, editTextAppointmentDate;
    Button btnMakeAppointment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_owner_activity);

        editTextPetName = findViewById(R.id.editTextPetName);
        editTextAppointmentDate = findViewById(R.id.editTextAppointmentDate);
        btnMakeAppointment = findViewById(R.id.btnMakeAppointment);

        btnMakeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String petName = editTextPetName.getText().toString();
                String appointmentDate = editTextAppointmentDate.getText().toString();

                if (petName.isEmpty() || appointmentDate.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    // Here you can save the appointment details to your database or perform other necessary actions
                    // For simplicity, let's just show a toast message
                    Toast.makeText(getApplicationContext(), "Appointment created for " + petName + " on " + appointmentDate, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
