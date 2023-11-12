package com.ultimate.b3_androidproject_student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button btnRegister, btnShow;
    private EditText etxtName, etxtYoB;
    private Switch switchGender;
    private Students students = new Students();

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if (isChecked) {
                switchGender.setText("Nữ");
            }
            else {
                switchGender.setText("Nam");
            }
        }
    };

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnRegister) {
                String name = etxtName.getText().toString();
                int yoB = Integer.parseInt(etxtYoB.getText().toString());
                Boolean gender = switchGender.isChecked();

                Student student = new Student(name, yoB, gender);
                students.addStudent(student);
            }
            else if (view.getId() == R.id.btnShow) {
                Intent intent = new Intent(MainActivity.this, StudentInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("students", students);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister = findViewById(R.id.btnRegister);
        btnShow = findViewById(R.id.btnShow);
        etxtName = findViewById(R.id.etxtName);
        etxtYoB = findViewById(R.id.etxtYoB);
        switchGender = findViewById(R.id.switchGender);

        switchGender.setOnCheckedChangeListener(onCheckedChangeListener);
        btnRegister.setOnClickListener(onClickListener);
        btnShow.setOnClickListener(onClickListener);

        if (savedInstanceState!= null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                students = (Students) savedInstanceState.getSerializable("students", Students.class);
            }
            else {
                students = (Students) savedInstanceState.getSerializable("students");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("students", students);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//    }
}