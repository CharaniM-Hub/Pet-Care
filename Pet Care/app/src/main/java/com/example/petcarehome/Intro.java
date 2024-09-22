package com.example.petcarehome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Intro extends AppCompatActivity {

    Button  SignIn;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        TextView descriptionTextView = findViewById(R.id.editdes);
        SignIn = findViewById(R.id.btnsignIn);
        SignUp = findViewById(R.id.btnsignUp);

        descriptionTextView.setText("A pet booking app connecting owners with caregivers for seamless, trusted pet care. Simplify booking, enhance pet happiness.");

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Sign In button click
                Intent signInIntent = new Intent(Intro.this, SigninUser.class);
                startActivity(signInIntent);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Sign Up button click
                Intent signUpIntent = new Intent(Intro.this, CustomerSignUp.class);
                startActivity(signUpIntent);
            }
        });
    }
}
