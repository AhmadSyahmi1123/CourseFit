package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.text.Editable;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class SignupPage extends AppCompatActivity {

    public EditText username;
    public EditText email;
    public EditText password;
    public Button nextButton;
    boolean cond1 = false;
    boolean cond2 = false;
    boolean cond3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        username = findViewById(R.id.usernameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setEnabled(false);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable str) {
                if (str.toString().length() <= 3 || str.toString().length() >= 15) {
                    username.setError("Username must be more than 3 characters and less than 15 characters long!");
                    cond1 = false;
                } else {
                    cond1 = true;
                }
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable str) {
                if (!str.toString().contains("@")) {
                    email.setError("The email format is incorrect!");
                    cond2 = false;
                } else {
                    cond2 = true;
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable str) {
                if (str.toString().length() < 7) {
                    password.setError("Password must be atleast 7 characters long!");
                    cond3 = false;
                } else if (!str.toString().matches(".*[0-9].*") || !str.toString().matches(".*[!@#$%^&*()].*") || !str.toString().matches(".*[A-Z].*")) {
                    Snackbar.make(findViewById(android.R.id.content), "Password must contain a number, an Uppercase letter and a special character: \"!@#$%^&*()\"!", Snackbar.LENGTH_LONG).show();
                    cond3 = false;
                } else {
                    cond3 = true;
                }
                nextButton.setEnabled(cond1 && cond2 && cond3);
            }
        });


        nextButton.setOnClickListener(v -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance("https://coursefit-e05ca-default-rtdb.asia-southeast1.firebasedatabase.app/");
            DatabaseReference Users = database.getReference("Users");

            Users.child("username").setValue(username.getText());

            // This method will be called when the button is clicked
            Intent intent = new Intent(SignupPage.this, MainMenu.class);
            startActivity(intent);
        });
    }
}