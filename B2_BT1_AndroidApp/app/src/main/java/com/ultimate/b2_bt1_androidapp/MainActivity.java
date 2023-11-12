package com.ultimate.b2_bt1_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtComputer, txtYou, txtResult;

    private Button btnRandom;

    private final Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtComputer = findViewById(R.id.txtComputerValue);
        txtYou = findViewById(R.id.txtYourValue);
        txtResult = findViewById(R.id.txtResult);
        btnRandom = findViewById(R.id.btnRandom);

        btnRandom.setOnClickListener(view -> {
            int txtComputerValue = random.nextInt(1000);
            txtComputer.setText(txtComputerValue + "");

            int txtYourValue = random.nextInt(1000);
            txtYou.setText(txtYourValue + "");

            if (txtComputerValue > txtYourValue)
                txtResult.setText("Computer won!");
            else if (txtComputerValue < txtYourValue)
                txtResult.setText("You won!");
            else
                txtResult.setText("Draw!");
        });
    }
}