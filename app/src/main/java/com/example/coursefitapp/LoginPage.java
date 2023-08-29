package com.example.coursefitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {

    db db = new db();
    private FirebaseAuth mAuth;
    private Button nextButton;
    private EditText username;
    private EditText password;
    Boolean cond1 = false;
    Boolean cond2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);

        nextButton = findViewById(R.id.nextButton);

        Intent intent = new Intent(LoginPage.this, MainMenu.class);
        if (mAuth.getCurrentUser() != null) {
            startActivity(intent);
            Toast.makeText(this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        }

        nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);
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
                    cond2 = false;
                } else if (!str.toString().matches(".*[0-9].*") || !str.toString().matches(".*[!@#$%^&*()].*") && !str.toString().matches(".*[A-Z].*")) {
                    Snackbar.make(findViewById(android.R.id.content), "Password must contain a number, an Uppercase letter and a special character: \"!@#$%^&*()\"!", Snackbar.LENGTH_SHORT).show();
                    cond2 = false;
                } else {
                    cond2 = true;
                }
                nextButton.setEnabled(cond1 && cond2);
                if (nextButton.isEnabled()) {
                    nextButton.setBackgroundResource(R.drawable.circular_button_bg_enabled);
                } else {
                    nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);

                }
            }
        });

        nextButton.setOnClickListener(v -> {
            db.Users.orderByChild("username").equalTo(username.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        cond1 = true;
                        for (DataSnapshot user : snapshot.getChildren()) {
                            if (user.child("username").getValue(String.class).equals(username.getText().toString())) {
                                if (user.child("password").getValue(String.class).equals(password.getText().toString())) {
                                    signIn(user.child("email").getValue(String.class), password.getText().toString());
                                } else {
                                    password.setText(null);
                                    password.setError("Incorrect Password");
                                    nextButton.setEnabled(false);
                                    nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);
                                }
                            }
                        }
                    } else {
                        username.setText(null);
                        password.setText(null);
                        username.setError("User not found.");
                        nextButton.setEnabled(false);
                        nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }
    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d("Auth", "signInWithEmail:success");
                        Toast.makeText(LoginPage.this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginPage.this, MainMenu.class));
                    } else {
                        Log.w("Auth", "signInWithEmail:failure", task.getException());
                        Toast.makeText(LoginPage.this, "Authentication failed\n(SignIn)",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}