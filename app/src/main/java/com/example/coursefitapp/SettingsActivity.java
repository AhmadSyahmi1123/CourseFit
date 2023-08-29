package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.settings_page, rootKey);
            Preference signOutPreference = findPreference("pref_key_sign_out");

            signOutPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    // Handle the sign-out action here
                    signOutUser();
                    return true; // Indicate that the click event has been handled
                }
            });
        }
        private void signOutUser() {
            // Sign out the user here (e.g., using Firebase Authentication)
            // Redirect to the login or sign-in activity
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);

            // Optionally, display a toast message
            Toast.makeText(requireContext(), "You have been signed out", Toast.LENGTH_SHORT).show();
        }
    }
}