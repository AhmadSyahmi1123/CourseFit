package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Field;

public class bahagianA extends AppCompatActivity {

    public Button nextButton;
    public static int r, i, a, s, e, k = 0;
    boolean[] isQuestionAnswered = new boolean[20]; // Assuming you have 20 questions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bahagian_a);

        for (int i = 0; i < isQuestionAnswered.length; i++) {
            isQuestionAnswered[i] = false;
        }

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

        setRadioGroupListener(soalan1, 0);
        setRadioGroupListener(soalan2, 1);
        setRadioGroupListener(soalan3, 2);
        setRadioGroupListener(soalan4, 3);
        setRadioGroupListener(soalan5, 4);
        setRadioGroupListener(soalan6, 5);
        setRadioGroupListener(soalan7, 6);
        setRadioGroupListener(soalan8, 7);
        setRadioGroupListener(soalan9, 8);
        setRadioGroupListener(soalan10, 9);
        setRadioGroupListener(soalan11, 10);
        setRadioGroupListener(soalan12, 11);
        setRadioGroupListener(soalan13, 12);
        setRadioGroupListener(soalan14, 13);
        setRadioGroupListener(soalan15, 14);
        setRadioGroupListener(soalan16, 15);
        setRadioGroupListener(soalan17, 16);
        setRadioGroupListener(soalan18, 17);
        setRadioGroupListener(soalan19, 18);
        setRadioGroupListener(soalan20, 19);

        nextButton = findViewById(R.id.nextButton);
        nextButton.setBackgroundResource(R.drawable.disabled_button);
        nextButton.setEnabled(false);

        nextButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(bahagianA.this, bahagianB.class);
            startActivity(intent);
        });
    }
    private void setRadioGroupListener(RadioGroup radioGroup, final int questionIndex) {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            if (radioButton != null && radioButton.getText().toString().equals("Ya")) {
                try {
                    Field field = bahagianA.class.getDeclaredField("r");
                    int count = (int) field.get(this);
                    count++;
                    field.set(this, count);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            isQuestionAnswered[questionIndex] = true; // Mark the question as answered

            // Check if all questions are answered
            boolean allQuestionsAnswered = true;
            for (boolean answered : isQuestionAnswered) {
                if (!answered) {
                    allQuestionsAnswered = false;
                    break;
                }
            }

            // Enable or disable the submit button based on whether all questions are answered
            if (allQuestionsAnswered) {
                nextButton.setBackgroundResource(R.drawable.enabled_button);
                nextButton.setEnabled(true);
            } else {
                nextButton.setBackgroundResource(R.drawable.disabled_button);
                nextButton.setEnabled(false);
            }
        });
    }
}