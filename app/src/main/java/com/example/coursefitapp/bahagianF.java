package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Field;

public class bahagianF extends AppCompatActivity {

    public Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bahagian_f);

        RadioGroup soalan1 = findViewById(R.id.soalan1);
        RadioGroup soalan2 = findViewById(R.id.soalan2);
        RadioGroup soalan3 = findViewById(R.id.soalan3);
        RadioGroup soalan4 = findViewById(R.id.soalan4);
        RadioGroup soalan5 = findViewById(R.id.soalan5);
        RadioGroup soalan6 = findViewById(R.id.soalan6);
        RadioGroup soalan7 = findViewById(R.id.soalan7);
        RadioGroup soalan8 = findViewById(R.id.soalan8);
        RadioGroup soalan9 = findViewById(R.id.soalan9);
        RadioGroup soalan10 = findViewById(R.id.soalan10);
        RadioGroup soalan11 = findViewById(R.id.soalan11);
        RadioGroup soalan12 = findViewById(R.id.soalan12);
        RadioGroup soalan13 = findViewById(R.id.soalan13);
        RadioGroup soalan14 = findViewById(R.id.soalan14);
        RadioGroup soalan15 = findViewById(R.id.soalan15);
        RadioGroup soalan16 = findViewById(R.id.soalan16);
        RadioGroup soalan17 = findViewById(R.id.soalan17);
        RadioGroup soalan18 = findViewById(R.id.soalan18);
        RadioGroup soalan19 = findViewById(R.id.soalan19);
        RadioGroup soalan20 = findViewById(R.id.soalan20);

        setRadioGroupListener(soalan1, "k");
        setRadioGroupListener(soalan2, "k");
        setRadioGroupListener(soalan3, "k");
        setRadioGroupListener(soalan4, "k");
        setRadioGroupListener(soalan5, "k");
        setRadioGroupListener(soalan6, "k");
        setRadioGroupListener(soalan7, "k");
        setRadioGroupListener(soalan8, "k");
        setRadioGroupListener(soalan9, "k");
        setRadioGroupListener(soalan10, "k");
        setRadioGroupListener(soalan11, "k");
        setRadioGroupListener(soalan12, "k");
        setRadioGroupListener(soalan13, "k");
        setRadioGroupListener(soalan14, "k");
        setRadioGroupListener(soalan15, "k");
        setRadioGroupListener(soalan16, "k");
        setRadioGroupListener(soalan17, "k");
        setRadioGroupListener(soalan18, "k");
        setRadioGroupListener(soalan19, "k");
        setRadioGroupListener(soalan20, "k");

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(bahagianF.this, results.class);
            startActivity(intent);
        });
    }
    private void setRadioGroupListener(RadioGroup radioGroup, final String countVariable) {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            if (radioButton != null && radioButton.getText().toString().equals("Ya")) {
                try {
                    Field field = bahagianA.class.getDeclaredField(countVariable);
                    int count = (int) field.get(this);
                    count++;
                    field.set(this, count);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}