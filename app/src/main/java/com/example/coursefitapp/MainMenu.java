package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    public Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(MainMenu.this, bahagianA.class);
            startActivity(intent);
        });
    }
}