package com.ultimate.b1_mobile_javatutorialprojects;

import androidx.annotation.NonNull;

public class Student extends Human{
    private float gPA;

    public Student(String name, float gPA) {
        super(name);
        this.gPA = gPA;
    }

    @NonNull
    @Override
    public String toString() {
        return "Student(" + name + ", " + gPA + ")";
    }
}
