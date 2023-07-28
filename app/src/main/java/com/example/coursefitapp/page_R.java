package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class page_R extends AppCompatActivity {

    public Button toPage_I_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_r);

        toPage_I_Button = findViewById(R.id.toNextPhaseButton);

        //toPage_I_Button.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            //Intent intent = new Intent(page_R.this, .class);
            //startActivity(intent);
        //});
    }
}