package com.example.coursefitapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignupPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    db db = new db();
    private EditText username;
    private EditText email;
    private EditText password;
    private Button nextButton;
    boolean cond1 = false;
    boolean cond2 = false;
    boolean cond3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.usernameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        nextButton = findViewById(R.id.nextButton);
        //Button is disabled until all conditions are met
        nextButton.setEnabled(false);
        nextButton.setBackgroundResource(R.drawable.disabled_button);

        Intent intent = new Intent(SignupPage.this, MainMenu.class);
        if (mAuth.getCurrentUser() != null) {
            startActivity(intent);
            Toast.makeText(this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        }

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
                String inputEmail = email.getText().toString();

                // Check email format using regex
                Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$");
                Matcher matcher = pattern.matcher(inputEmail);

                // Check if email exists in the database
                ValueEventListener checkUser = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                String savedEmail = userSnapshot.child("email").getValue(String.class);

                                if (inputEmail.equals(savedEmail)) {
                                    email.setError("This email is already linked to an account.");
                                    cond2 = false;
                                    return;
                                }
                            }
                        }

                        if (!matcher.matches()) {
                            email.setError("Please insert a valid email address.");
                        } else {
                            cond2 = true;
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("DataCheck", "loadPost:onCancelled", databaseError.toException());
                    }
                };

                // Attach the ValueEventListener to the query
                Query emailQ = db.Users.orderByChild("email").equalTo(inputEmail);
                emailQ.addListenerForSingleValueEvent(checkUser);
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
                } else if (!str.toString().matches(".*[0-9].*") || !str.toString().matches(".*[!@#$%^&*()].*") && !str.toString().matches(".*[A-Z].*")) {
                    Snackbar.make(findViewById(android.R.id.content), "Password must contain a number, an Uppercase letter and a special character: \"!@#$%^&*()\"!", Snackbar.LENGTH_SHORT).show();
                    cond3 = false;
                } else {
                    cond3 = true;
                }
                nextButton.setEnabled(cond1 && cond2 && cond3);
                if (nextButton.isEnabled()) {
                    nextButton.setBackgroundResource(R.drawable.enabled_button);
                } else {
                    nextButton.setBackgroundResource(R.drawable.disabled_button);
                }
            }
        });

        nextButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            nextButton.setText("Loading...");
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            Log.d("Auth", "createUserWithEmail:success");
                            signIn(email.getText().toString(), password.getText().toString());
                            String key = db.Users.push().getKey();
                            db.saveData(key, "email", email.getText().toString());
                            db.saveData(key, "username", username.getText().toString());
                            db.saveData(key, "password", password.getText().toString());

                            if (mAuth.getCurrentUser() != null) {
                                startActivity(intent);
                                Toast.makeText(this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            nextButton.setText("Error");
                            Log.w("Auth", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupPage.this, "Authentication failed\n(SignUp)",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d("Auth", "signInWithEmail:success");
                        Toast.makeText(this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                    } else {
                        Log.w("Auth", "signInWithEmail:failure", task.getException());
                        Toast.makeText(SignupPage.this, "Authentication failed\n(SignIn)",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}