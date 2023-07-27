package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {

    public Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(LoginPage.this, MainMenu.class);
            startActivity(intent);
        });
    }
}