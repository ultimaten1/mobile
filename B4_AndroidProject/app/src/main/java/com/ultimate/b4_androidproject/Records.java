package com.ultimate.b4_androidproject;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private ArrayList<String> recordsList;

    public Records() {
        recordsList = new ArrayList<>();
    }


    public ArrayList<String> getRecordsList() {
        return recordsList;
    }

    public void setRecordsList(ArrayList<String> recordsList) {
        this.recordsList = recordsList;
    }

    public void addRecordsList(String record) {
        recordsList.add(record);
    }

    @Override
    public String toString() {
        return recordsList + "";
    }
}
