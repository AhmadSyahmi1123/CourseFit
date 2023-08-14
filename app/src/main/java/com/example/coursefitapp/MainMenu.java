package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    public Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        startButton = findViewById(R.id.startButton);

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
            // Perform sign-out logic here
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}