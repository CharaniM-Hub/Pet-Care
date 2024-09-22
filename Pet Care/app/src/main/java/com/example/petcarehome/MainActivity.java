package com.example.petcarehome;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button emergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonLetGo);
        emergency = findViewById(R.id.buttonEmergency);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message="Welcome to Pet Care Home.We protect your pet like you do.";
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

                Intent go = new Intent(getApplicationContext(),Intro.class);
                startActivity(go);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEmergencyDialog();
            }
        });
    }

    private void showEmergencyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Emergency Service")
                .setMessage("To access our emergency service:")
                .setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle "Call" button click
                        makeEmergencyCall();
                    }
                })
                .setNegativeButton("Location", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle "Location" button click
                        openLocationMap();
                    }
                })
                .show();
    }

    private void makeEmergencyCall() {
        String phoneNumber = "0702283050";
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }

    private void openLocationMap() {
        String locationLink = "https://www.google.com/maps/dir//PetsVcare+Animal+Hospitals,+506%2F7+Elvitigala+Mawatha,+Colombo+5/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x3ae25914d29f535d:0x1fa9d21b23109656?sa=X&ved=2ahUKEwiaweSayd-CAxUYxDgGHe4JD94Q48ADegQICxAA";
        Uri mapUri = Uri.parse(locationLink);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(mapIntent);
    }
}
