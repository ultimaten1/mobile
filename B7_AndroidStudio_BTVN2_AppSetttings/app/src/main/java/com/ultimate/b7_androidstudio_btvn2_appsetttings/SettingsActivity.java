package com.ultimate.b7_androidstudio_btvn2_appsetttings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();


    }

    private void setSelectedColor() {
        SettingsFragment settingsFragment = (SettingsFragment) getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (settingsFragment != null) {
            settingsFragment.setSelectedColor();
        }
    }
}

