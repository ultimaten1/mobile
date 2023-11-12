package com.ultimate.b7_androidstudio_btvn1_sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.content.Context;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {
    private GridView grvMain;
    private TextView txtResult;
    private AppCompatButton btnCount;
    private AppCompatButton btnReset;
    String[] colors = {"BLACK", "RED", "BLUE", "GREEN"};
    int[] colorCodes = {R.color.black, R.color.red, R.color.blue, R.color.green};
    int selectedColor = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grvMain = findViewById(R.id.grvMain);
        txtResult = findViewById(R.id.txtResult);
        btnCount = findViewById(R.id.btnCount);
        btnReset = findViewById(R.id.btnReset);

        restoreAppState();

        if (selectedColor == 0) {
            selectedColor = getResources().getColor(R.color.colorPrimary);
        }

        txtResult.setBackgroundColor(selectedColor);

        gridViewHandler();
        clickItemGridViewHandler();
        clickCount();
        clickReset();
    }

    public void gridViewHandler() {
        CustomAdapter adapter = new CustomAdapter(MainActivity.this, colors, colorCodes);
        grvMain.setAdapter(adapter);
    }

    public void clickItemGridViewHandler() {
        grvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedColor = getResources().getColor(colorCodes[position]);
                txtResult.setBackgroundColor(selectedColor);

                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("selectedColor", selectedColor);
                editor.apply();
            }
        });
    }

    public void clickCount() {
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(String.valueOf(++count));
            }
        });
    }

    public void clickReset() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = getResources().getColor(R.color.colorPrimary);
                count = 0;
                txtResult.setText(String.valueOf(count));
                txtResult.setBackgroundColor(selectedColor);
            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        saveAppState();
//    }

    @Override
    protected void onPause() {
        super.onPause();
        saveAppState();
    }

    public void saveAppState() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count", count);
        editor.putInt("selectedColor", selectedColor);
        editor.apply();
    }

    public void restoreAppState() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 0);
        txtResult.setText(String.valueOf(count));
        selectedColor = sharedPreferences.getInt("selectedColor", 0);
        txtResult.setBackgroundColor(selectedColor);
    }
}
