package com.example.petcarehome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerSignUp extends AppCompatActivity {

    EditText editName, editUsername, EditEmail, EditPhoneNo, EditAddress, EditPassword, EditConPassword;
    Button button;
    Button CgSignUp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);

        editName = findViewById(R.id.txtName);
        editUsername = findViewById(R.id.txtUserName);
        EditEmail = findViewById(R.id.txtEmail);
        EditPhoneNo = findViewById(R.id.txtPno);
        EditAddress = findViewById(R.id.txtAddress);
        EditPassword = findViewById(R.id.Password);
        EditConPassword = findViewById(R.id.txtConPassword);
        button = findViewById(R.id.btnSignUp);
        CgSignUp = findViewById(R.id.txtCGsignUp);

        // Set OnClickListener for CgSignUp TextView
        CgSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Sign In button click
                Intent signInIntent = new Intent(CustomerSignUp.this, CareGiverSignUp.class);
                startActivity(signInIntent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String username = editUsername.getText().toString();
                String email = EditEmail.getText().toString();
                String phoneNo = EditPhoneNo.getText().toString();
                String address = EditAddress.getText().toString();
                String password = EditPassword.getText().toString();
                String confirm = EditConPassword.getText().toString();

                DatabaseHelper DB = new DatabaseHelper(getApplicationContext());

                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All Details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirm)) {
                        if (isValid(password)) {
                            DB.CustomerSignUp(name, username, email, phoneNo, address, password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(CustomerSignUp.this, SigninUser.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Password format", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            return f1 == 1 && f2 == 1 && f3 == 1;
        }
    }
}
