package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Field;

public class bahagianB extends AppCompatActivity {

    public Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bahagian_b);

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

        setRadioGroupListener(soalan1, "i");
        setRadioGroupListener(soalan2, "i");
        setRadioGroupListener(soalan3, "i");
        setRadioGroupListener(soalan4, "i");
        setRadioGroupListener(soalan5, "i");
        setRadioGroupListener(soalan6, "i");
        setRadioGroupListener(soalan7, "i");
        setRadioGroupListener(soalan8, "i");
        setRadioGroupListener(soalan9, "i");
        setRadioGroupListener(soalan10, "i");
        setRadioGroupListener(soalan11, "i");
        setRadioGroupListener(soalan12, "i");
        setRadioGroupListener(soalan13, "i");
        setRadioGroupListener(soalan14, "i");
        setRadioGroupListener(soalan15, "i");
        setRadioGroupListener(soalan16, "i");
        setRadioGroupListener(soalan17, "i");
        setRadioGroupListener(soalan18, "i");
        setRadioGroupListener(soalan19, "i");
        setRadioGroupListener(soalan20, "i");

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(bahagianB.this, bahagianC.class);
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