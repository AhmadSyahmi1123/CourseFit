package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button signupButton;
    public Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String welcomeMessage = getString(R.string.welcome_message);
        TextView textView = findViewById(R.id.welcomeText);
        textView.setText(welcomeMessage);

        signupButton = findViewById(R.id.signupButton);
        loginButton = findViewById(R.id.loginButton);

        //signup button
        signupButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(MainActivity.this, SignupPage.class);
            startActivity(intent);
        });

        //login button
        loginButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(MainActivity.this, LoginPage.class);
            startActivity(intent);
        });
    }
}