package com.ultimate.b3_androidproject_student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoActivity extends AppCompatActivity {

    private TextView txtListStudentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        txtListStudentInfo = findViewById(R.id.txtListStudentInfo);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Students receivedStudents = (Students) bundle.get("students");
            if (receivedStudents != null) {
                ArrayList<Student> studentList = receivedStudents.getStudentList();

                txtListStudentInfo.setText(studentList.toString());
            }
        }
    }
}