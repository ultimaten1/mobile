package com.ultimate.b1_mobile_javatutorialprojects;

import androidx.annotation.NonNull;

public class Human {
    protected String name;

    public Human(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Human(" + name + ")";
    }
}
