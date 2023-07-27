package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class SignupPage extends AppCompatActivity {
    public Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(SignupPage.this, MainMenu.class);
            startActivity(intent);
        });
    }
}