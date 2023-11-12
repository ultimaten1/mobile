package com.ultimate.b3_androidproject_student;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int yoB;
    private Boolean gender;

    public Student() {
        name = "Null";
        yoB = 0;
        gender = false;
    }

    public Student(String name, int yoB, Boolean gender) {
        this.name = name;
        this.yoB = yoB;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYoB() {
        return yoB;
    }

    public void setYoB(int yoB) {
        this.yoB = yoB;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String isGender(Boolean gender) {
        if (gender) {
            return "Nữ";
        }
        else {
            return "Nam";
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yoB=" + yoB +
                ", gender=" + isGender(gender) +
                "}";
    }
}
