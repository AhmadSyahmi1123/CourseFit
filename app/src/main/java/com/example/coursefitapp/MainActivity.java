package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    db db = new db();
    Boolean cond1 = false;
    Boolean cond2 = false;
    private FirebaseAuth mAuth;
    private Button nextButton;
    private TextView linkToSignUp;
    private EditText email;
    private EditText password;
    private ProgressBar progress;
    private ImageView warnError;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        progress = findViewById(R.id.progressBar);
        warnError = findViewById(R.id.warnError);

        nextButton = findViewById(R.id.nextButton);
        linkToSignUp = findViewById(R.id.toSignUpLink);
        SpannableString spannableString = new SpannableString("Sign Up");
        spannableString.setSpan(new UnderlineSpan(), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        linkToSignUp.setText(spannableString);

        linkToSignUp.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SignupPage.class));
        });

        Intent intent = new Intent(MainActivity.this, MainMenu.class);
        if (mAuth.getCurrentUser() != null) {
            startActivity(intent);
            Toast.makeText(this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        }

        progress.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        warnError.setVisibility(View.INVISIBLE);
        nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);
        nextButton.setEnabled(false);


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
                                cond1 = true;
                                email.setError(null);
                                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                    String savedEmail = userSnapshot.child("email").getValue(String.class);

                                    if (inputEmail.equals(savedEmail)) {
                                        cond1 = true;
                                    } else {
                                        email.setError("This email isn't linked to any account.");
                                        cond1 = false;
                                    }
                                }
                            } else {
                                email.setError("This email isn't linked to any account.");
                                cond1 = false;
                            }

                            if (!matcher.matches()) {
                                email.setError("Please insert a valid email address.");
                            } else {
                                cond1 = true;
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
                        cond2 = false;
                    } else {
                        cond2 = true;
                        handler.removeCallbacksAndMessages(null);
                    }
                }, 1000);
                if (!str.toString().matches(".*[0-9].*") || !str.toString().matches(".*[!@#$%^&*()].*") && !str.toString().matches(".*[A-Z].*")) {
                    Snackbar.make(findViewById(android.R.id.content), "Password must contain a number and an Uppercase letter!", Snackbar.LENGTH_SHORT).show();
                    cond2 = false;
                } else {
                    cond2 = true;
                    handler.removeCallbacksAndMessages(null);
                }
                nextButton.setEnabled(cond1 && cond2);
                if (nextButton.isEnabled()) {
                    progress.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                    warnError.setVisibility(View.INVISIBLE);
                    nextButton.setBackgroundResource(R.drawable.circular_button_bg_enabled);
                } else {
                    nextButton.setBackgroundResource(R.drawable.circular_button_bg_disabled);

                }
            }
        });

        nextButton.setOnClickListener(v -> {
            progress.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            warnError.setVisibility(View.INVISIBLE);
            signIn(email.getText().toString(), password.getText().toString());
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                Log.d("Auth", "signInWithEmail:success");
                Toast.makeText(MainActivity.this, "Signed in as " + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MainMenu.class));
            } else {
                progress.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                warnError.setVisibility(View.VISIBLE);
                Log.w("Auth", "signInWithEmail:failure", task.getException());
                Toast.makeText(MainActivity.this, "Authentication failed\nTry checking your password.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}