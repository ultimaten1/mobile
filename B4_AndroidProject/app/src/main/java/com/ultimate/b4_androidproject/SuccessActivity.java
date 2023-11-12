package com.ultimate.b4_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SuccessActivity extends AppCompatActivity {
    private Button btnStartAgainSuccess;
    private TextView txtRecordValue;
    private Records recordsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btnStartAgainSuccess = findViewById(R.id.btnStartAgainSuccess);
        recordsList = new Records();

        String records = getIntent().getStringExtra("records");
        if (records != null) {
            txtRecordValue = findViewById(R.id.txtRecordValue);
            recordsList.addRecordsList(records);
            txtRecordValue.setText(recordsList.toString());
        }

        btnStartAgainSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}