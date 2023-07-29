package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class bahagianA extends AppCompatActivity {

    public Button toPage_I_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bahagian_a);

        toPage_I_Button = findViewById(R.id.toNextPhaseButton);

        //toPage_I_Button.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            //Intent intent = new Intent(page_R.this, .class);
            //startActivity(intent);
        //});
    }
}