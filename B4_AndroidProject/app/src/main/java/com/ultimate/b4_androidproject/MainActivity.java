package com.ultimate.b4_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Khai bao bien
    private Button btnStart;
    private TextView txtTime;
    private TextView txtTimeValue;
    private TextView txtLanguage;
    private Spinner spnLanguage;
    private ArrayList<String> arrLanguage;
    private GridView grvGridData;
    private Grid gridViewAdapter, gridViewAdapter2;
    private ArrayAdapter<Integer> arrayAdapter;
    private String[] gridColorData = {
            "#008B8B", "#00FF00", "#48D1CC", "#556B2F", "#696969",
            "#3399FF", "#8FBC8F", "#AFEEEE", "#B8860B", "#BDB76B",
            "#D8BFD8", "#DEB887", "#FFFF00", "#66FFB2", "#EE82EE",
            "#DC143C", "#008B8B", "#00FF00", "#48D1CC", "#556B2F",
            "#696969", "#3399FF", "#8FBC8F", "#AFEEEE", "#B8860B",
            "#BDB76B", "#D8BFD8", "#DEB887", "#FFFF00", "#66FFB2",
            "#EE82EE", "#DC143C", "#008B8B", "#00FF00", "#48D1CC",
            "#556B2F", "#696969", "#3399FF", "#8FBC8F", "#AFEEEE",
            "#B8860B", "#BDB76B", "#D8BFD8", "#DEB887", "#FFFF00",
            "#66FFB2", "#EE82EE", "#DC143C", "#008B8B", "#00FF00",
            "#48D1CC", "#556B2F", "#696969", "#3399FF", "#8FBC8F",
            "#AFEEEE", "#B8860B", "#BDB76B", "#D8BFD8", "#DEB887",
            "#FFFF00", "#66FFB2", "#EE82EE", "#DC143C", "#008B8B",
            "#00FF00", "#48D1CC", "#556B2F", "#696969", "#3399FF",
            "#8FBC8F", "#AFEEEE", "#B8860B", "#BDB76B", "#D8BFD8",
            "#DEB887", "#FFFF00", "#66FFB2", "#EE82EE", "#DC143C",
            "#008B8B", "#00FF00", "#48D1CC", "#556B2F", "#008B8B",
            "#00FF00", "#48D1CC", "#556B2F", "#696969", "#3399FF",
            "#8FBC8F", "#AFEEEE", "#B8860B", "#BDB76B", "#D8BFD8",
            "#DEB887", "#FFFF00", "#66FFB2", "#EE82EE", "#DC143C"
    };
    private CountDownTimer countDownTimer;
    private List<Integer> numberList;
    private int expectedNumber = 1;
    private int incorrectClicks = 0;
    private boolean gameStarted = false;
    private String selectedLanguage;

    private void spinnerHandler() {
        // Them EN va VN vao mang arrayList
        arrLanguage.add("EN");
        arrLanguage.add("VN");

        // Cai dat adapter cho spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, arrLanguage);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnLanguage.setAdapter(spinnerAdapter);

        spnLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selectedLanguage = arrLanguage.get(position);

                if ("EN".equals(selectedLanguage)) {
                    btnStart.setText("Start");
                    txtTime.setText("Time:");
                    txtLanguage.setText("Language:");
                } else if ("VN".equals(selectedLanguage)) {
                    btnStart.setText("Bắt đầu");
                    txtTime.setText("Thời gian:");
                    txtLanguage.setText("Ngôn ngữ:");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Mac dinh cho spinner la "EN"
        String selection = "EN";
        spnLanguage.setSelection(spinnerAdapter.getPosition(selection));
    }

    private void gridViewHandler() {
        grvGridData.setAdapter(gridViewAdapter);
    }

    private void startCountdown() {
        gameStarted = true;
        expectedNumber = 1;
        incorrectClicks = 0;

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        long countDownMillis = 20 * 60 * 1000;

        countDownTimer = new CountDownTimer(countDownMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 1000 / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
                String timeFormatted = String.format("%02d:%02d", minutes, seconds);
                txtTimeValue.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                txtTimeValue.setText("00:00");
                gameStarted = false;

                // Cac phuong thuc intent
                Intent intent = new Intent(MainActivity.this, FailedActivity.class);
                startActivity(intent);
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void onClick_btnStartHandler() {
        arrayAdapter = new ArrayAdapter<Integer>(MainActivity.this, R.layout.gridview_item, numberList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.gridview_item, parent, false);
                }

                TextView textView = convertView.findViewById(R.id.txtgridItem);
                int randomNumber = numberList.get(position);
                String color = gridColorData[randomNumber - 1];
                textView.setBackgroundColor(Color.parseColor(color));
                textView.setText(String.valueOf(randomNumber));

                return convertView;
            }
        };

    }

    private void buttonStartHandler() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameStarted) {
                    numberList = generateRandomNumbers();

                    onClick_btnStartHandler();
//                    arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, numberList);
                    grvGridData.setAdapter(arrayAdapter);

                    startCountdown();
                }
                else {
                    if ("EN".equals(selectedLanguage)) {
                        Toast.makeText(MainActivity.this, "The game is in process! Do not press the Start button again!", Toast.LENGTH_SHORT).show();
                    }
                    else if ("VN".equals(selectedLanguage)) {
                        Toast.makeText(MainActivity.this, "Trò chơi đang diễn ra! Không được nhấn nút Start lại!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void grvGridDataOnClickHandler() {
        grvGridData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (gameStarted) {
                    int clickedNumber = numberList.get(position);
                    if (clickedNumber == expectedNumber) {
                        numberList.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                        expectedNumber++;
                        if (expectedNumber >= 100) {
                            Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
                            intent.putExtra("records", txtTimeValue.getText().toString().trim());
                            startActivity(intent);
                        }
                    } else {
                        if ("EN".equals(selectedLanguage)) {
                            if (incorrectClicks == 0) {
                                Toast.makeText(MainActivity.this, "You were wrong: " + (++incorrectClicks) + " time", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "You were wrong: " + (++incorrectClicks) + " times", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if ("VN".equals(selectedLanguage)) {
                            Toast.makeText(MainActivity.this, "Bạn đã sai: " + (++incorrectClicks) + " lần", Toast.LENGTH_SHORT).show();
                        }
                        if (incorrectClicks >= 3) {
                            incorrectClicks = 0;
                            Intent intent = new Intent(MainActivity.this, FailedActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dang ki bien
        btnStart = findViewById(R.id.btnStart);
        txtTime = findViewById(R.id.txtTime);
        txtTimeValue = findViewById(R.id.txtTimeValue);
        txtLanguage = findViewById(R.id.txtLanguage);
        spnLanguage = findViewById(R.id.spnLanguage);
        arrLanguage = new ArrayList<>();
        grvGridData = findViewById(R.id.grvGridData);
        gridViewAdapter = new Grid(MainActivity.this, gridColorData);
        numberList = new ArrayList<>();

        // Goi cac ham xu li
        spinnerHandler();
        gridViewHandler();
        buttonStartHandler();
        grvGridDataOnClickHandler();
    }
}