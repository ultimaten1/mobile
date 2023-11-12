package com.ultimate.b7_androidstudio_btvn2_appsetttings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {
    private GridView grvMain;
    private TextView txtResult;
    private CustomAdapter adapter;
    private String[] colors = {"BLACK", "RED", "BLUE", "GREEN"};

    public int[] getColorCodes() {
        return colorCodes;
    }

    private int[] colorCodes = {R.color.black, R.color.red, R.color.blue, R.color.green};
    private int count = 0;
    private int selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grvMain = findViewById(R.id.grvMain);
        txtResult = findViewById(R.id.txtResult);

        PreferenceManager.setDefaultValues(MainActivity.this, R.xml.preferences, false);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean enableFeature = preferences.getBoolean("enable_feature", true);

        if (enableFeature) {
            selectedColor = preferences.getInt("color_preference", getResources().getColor(R.color.colorPrimary));
            count = preferences.getInt("count", 0);
            txtResult.setBackgroundColor(selectedColor);
            txtResult.setText(String.valueOf(count));
        } else {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
            editor.remove("count");
            editor.remove("color_preference");
            editor.apply();

            count = 0;
            txtResult.setText(String.valueOf(count));
            int defaultColor = getResources().getColor(R.color.colorPrimary);
            txtResult.setBackgroundColor(defaultColor);
        }

        adapter = new CustomAdapter(MainActivity.this, colors, colorCodes);
        grvMain.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        gridViewHandler();
        clickItemGridViewHandler();
        clickCount();
        clickReset();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveOnClick();
    }

    public void saveOnClick() {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
        editor.putInt("count", count);
        editor.apply();
    }

    private void gridViewHandler() {
        grvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedColor = getResources().getColor(colorCodes[position]);
                txtResult.setBackgroundColor(selectedColor);

                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
                editor.putInt("color_preference", selectedColor);
                editor.apply();
            }
        });
    }

    private void clickItemGridViewHandler() {
        grvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedColor = getResources().getColor(colorCodes[position]);
                txtResult.setBackgroundColor(selectedColor);

                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
                editor.putInt("color_preference", selectedColor);
                editor.apply();
            }
        });
    }

    private void clickCount() {
        findViewById(R.id.btnCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText(String.valueOf(++count));

//                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
//                editor.putInt("count", count);
//                editor.apply();
            }
        });
    }

    private void clickReset() {
        findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
                editor.remove("count");
                editor.remove("color_preference");
                editor.apply();

                count = 0;
                txtResult.setText(String.valueOf(count));
                int defaultColor = getResources().getColor(R.color.colorPrimary);
                txtResult.setBackgroundColor(defaultColor);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        count = PreferenceManager.getDefaultSharedPreferences(this).getInt("count", 0);
        txtResult.setText(String.valueOf(count));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
