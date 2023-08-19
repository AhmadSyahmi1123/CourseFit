package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {
    private FirebaseAuth mAuth;

    public Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        startButton = findViewById(R.id.startButton);
        mAuth = FirebaseAuth.getInstance();

        startButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(MainMenu.this, bahagianA.class);
            startActivity(intent);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sign_out) {
            startActivity(new Intent(MainMenu.this, MainActivity.class));
            Toast.makeText(this, "User " + mAuth.getCurrentUser().getEmail() + " signed out.", Toast.LENGTH_LONG).show();
            mAuth.signOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}