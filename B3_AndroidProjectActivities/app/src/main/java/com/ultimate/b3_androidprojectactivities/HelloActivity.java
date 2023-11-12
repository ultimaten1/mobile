package com.ultimate.b3_androidprojectactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        txtMessage = findViewById(R.id.txtMessage);

        Intent myintent = getIntent();
        String str = myintent.getStringExtra("mykey");
        txtMessage.setText(str);
    }
}