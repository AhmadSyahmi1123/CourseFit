package com.example.coursefitapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    db db = new db();
    boolean cond1 = false;
    boolean cond2 = false;
    boolean cond3 = false;
    private FirebaseAuth mAuth;
    private TextView linkToSignIn;
    private EditText username;
    private EditText email;
    private EditText password;
    private Button nextButton;
    private ProgressBar progress;
    private ImageView warnError;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        linkToSignIn = findViewById(R.id.toSignInLink);
        SpannableString spannableString = new SpannableString("Sign In");
        spannableString.setSpan(new UnderlineSpan(), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        linkToSignIn.setText(spannableString);

        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.usernameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        nextButton = findViewById(R.id.nextButton);
        progress = findViewById(R.id.progressBar);
        warnError = findViewById(R.id.warnError);
        //Button is disabled until all conditions are met
        nextButton.setEnabled(false);
        nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);

        Intent intent = new Intent(SignupPage.this, MainMenu.class);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                username.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                username.setError(null);
                handler.removeCallbacksAndMessages(null);
            }

            @Override
            public void afterTextChanged(Editable str) {
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(() -> {
                    if (str.toString().length() <= 3 || str.toString().length() >= 15) {
                        username.setError("Username must be more than 3 characters and less than 15 characters long!");
                        cond1 = false;
                    } else {
                        cond1 = true;
                    }

                }, 1000);
            }
        });
        email.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                email.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                email.setError(null);
                handler.removeCallbacksAndMessages(null);
            }

            @Override
            public void afterTextChanged(Editable str) {
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(() -> {
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
                                    } else {
                                        cond2 = true;
                                        email.setError(null);
                                    }
                                }
                            }
                            if (!matcher.matches()) {
                                email.setError("Please insert a valid email address.");
                                cond2 = false;
                            } else {
                                handler.removeCallbacksAndMessages(null);
                                cond2 = true;
                                email.setError(null);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.w("DataCheck", "loadPost:onCancelled", databaseError.toException());
                            Toast.makeText(SignupPage.this, "Database Error", Toast.LENGTH_SHORT).show();
                        }
                    };
                    // Attach the ValueEventListener to the query
                    Query emailQ = db.Users.orderByChild("email").equalTo(inputEmail);
                    emailQ.addListenerForSingleValueEvent(checkUser);
                }, 1000);
            }
        });


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password.setError(null);
                handler.removeCallbacksAndMessages(null);
            }

            @Override
            public void afterTextChanged(Editable str) {
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(() -> {
                    if (str.toString().length() < 7) {
                        password.setError("Password must be atleast 7 characters long!");
                        cond3 = false;
                    } else {
                        cond3 = true;
                        handler.removeCallbacksAndMessages(null);
                    }
                }, 1000);
                if (!str.toString().matches(".*[0-9].*") || !str.toString().matches(".*[!@#$%^&*()].*") && !str.toString().matches(".*[A-Z].*")) {
                    Snackbar.make(findViewById(android.R.id.content), "Password must contain a number and an Uppercase letter!", Snackbar.LENGTH_SHORT).show();
                    cond3 = false;
                } else {
                    cond3 = true;
                    handler.removeCallbacksAndMessages(null);
                }
                nextButton.setEnabled(cond1 && cond2 && cond3);
                if (nextButton.isEnabled()) {
                    warnError.setVisibility(View.INVISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                    nextButton.setBackgroundResource(R.drawable.circular_button_bg_enabled);
                } else {
                    nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);
                }


            }
        });

        nextButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            progress.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            warnError.setVisibility(View.INVISIBLE);
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    Log.d("Auth", "createUserWithEmail:success");
                    signIn(email.getText().toString(), password.getText().toString());
                    String key = mAuth.getCurrentUser().getUid();
                    db.saveData(key, "email", null, email.getText().toString());
                    db.saveData(key, "username", null, username.getText().toString());
                    db.saveData(key, "password", null, password.getText().toString());

                    if (mAuth.getCurrentUser() != null) {
                        startActivity(intent);
                        Toast.makeText(this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    warnError.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(View.INVISIBLE);
                    Log.w("Auth", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(SignupPage.this, "Authentication failed\n(SignUp)", Toast.LENGTH_SHORT).show();
                }
            });
        });

        linkToSignIn.setOnClickListener(v -> {
            startActivity(new Intent(SignupPage.this, MainActivity.class));
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                Log.d("Auth", "signInWithEmail:success");
                Toast.makeText(this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
            } else {
                Log.w("Auth", "signInWithEmail:failure", task.getException());
                Toast.makeText(SignupPage.this, "Authentication failed\n(SignIn)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}