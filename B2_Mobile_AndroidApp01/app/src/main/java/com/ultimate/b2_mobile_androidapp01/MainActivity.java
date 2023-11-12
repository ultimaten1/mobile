package com.ultimate.b2_mobile_androidapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnToast, btnCount;
    private TextView txtMessage;
    public static int count = 0;

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnToast){
                txtMessage.setText("Toast");
                count = 0;
            }
            else if (view.getId() == R.id.btnCount){
                txtMessage.setText(count++ + "");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);
        btnCount = findViewById(R.id.btnCount);
        txtMessage = findViewById(R.id.txtMessage);

        btnToast.setOnClickListener(onClick);
        btnCount.setOnClickListener(onClick);
    }
}