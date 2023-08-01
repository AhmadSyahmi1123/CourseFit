package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Field;

public class bahagianC extends AppCompatActivity {

    public Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bahagian_c);

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

        setRadioGroupListener(soalan1, "a");
        setRadioGroupListener(soalan2, "a");
        setRadioGroupListener(soalan3, "a");
        setRadioGroupListener(soalan4, "a");
        setRadioGroupListener(soalan5, "a");
        setRadioGroupListener(soalan6, "a");
        setRadioGroupListener(soalan7, "a");
        setRadioGroupListener(soalan8, "a");
        setRadioGroupListener(soalan9, "a");
        setRadioGroupListener(soalan10, "a");
        setRadioGroupListener(soalan11, "a");
        setRadioGroupListener(soalan12, "a");
        setRadioGroupListener(soalan13, "a");
        setRadioGroupListener(soalan14, "a");
        setRadioGroupListener(soalan15, "a");
        setRadioGroupListener(soalan16, "a");
        setRadioGroupListener(soalan17, "a");
        setRadioGroupListener(soalan18, "a");
        setRadioGroupListener(soalan19, "a");
        setRadioGroupListener(soalan20, "a");

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(bahagianC.this, bahagianD.class);
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