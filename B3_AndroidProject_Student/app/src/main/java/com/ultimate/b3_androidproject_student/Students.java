package com.ultimate.b3_androidproject_student;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Students implements Serializable {
    private ArrayList<Student> studentList;

    public Students() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}
