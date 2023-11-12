package com.example.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button black_button;
    Button red_button;
    Button blue_button;
    Button green_button;
    Button count_button;
    Button bt_Clear;
    TextView tv_number;
    Button bt_Setting;
    int count;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String backgroundColor;

    private void initPreferences()
    {
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=sharedPreferences.edit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        black_button=findViewById(R.id.black_button);
        red_button=findViewById(R.id.red_button);
        blue_button=findViewById(R.id.blue_button);
        green_button=findViewById(R.id.green_button);
        count_button=findViewById(R.id.count_button);
        bt_Clear=findViewById(R.id.bt_Clear);
        tv_number=findViewById(R.id.number);
        bt_Setting=findViewById(R.id.bt_Setting);

        black_button.setOnClickListener(this);
        red_button.setOnClickListener(this);
        blue_button.setOnClickListener(this);
        green_button.setOnClickListener(this);
        count_button.setOnClickListener(this);
        bt_Clear.setOnClickListener(this);
        bt_Setting.setOnClickListener(this);

        initPreferences();
        count = Integer.parseInt(sharedPreferences.getString("Data", "0"));
        tv_number.setText(String.valueOf(count));
        String color_ = sharedPreferences.getString("BackgroundColor", "#BDB0B0");
        tv_number.setBackgroundColor(Color.parseColor(color_));
    }
    @Override
    public void onClick(View view) {
        if (view == black_button) {
            tv_number.setBackgroundColor(Color.parseColor("#000000"));
            backgroundColor= "#000000";
        } else if (view == red_button) {
            tv_number.setBackgroundColor(Color.parseColor("#F44336"));
            backgroundColor= "#F44336";
        } else if (view == blue_button) {
            tv_number.setBackgroundColor(Color.parseColor("#03A9F4"));
            backgroundColor= "#03A9F4";
        } else if (view == green_button) {
            tv_number.setBackgroundColor(Color.parseColor("#4CAF50"));
            backgroundColor= "#4CAF50";
        } else if (view == count_button) {
            count++;
            tv_number.setText(String.valueOf(count));
        } else if (view==bt_Clear) {
            tv_number.setText("");
            tv_number.setBackgroundColor(Color.parseColor("#BDB0B0"));
            count=0;
            editor.clear();
        } else if (view==bt_Setting) {
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);
        }
        editor.putString("BackgroundColor", backgroundColor);
        editor.putString("Data", String.valueOf(count));
        editor.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateBackgroundColor();
    }

    private void updateBackgroundColor() {
        SharedPreferences mainActivityPreferences = getSharedPreferences("MainActivityPrefs", Context.MODE_PRIVATE);
        String backgroundColor = mainActivityPreferences.getString("background_color", "#FFFFFF"); // Giá trị mặc định là trắng

        getWindow().getDecorView().setBackgroundColor(Color.parseColor(backgroundColor));
    }
}