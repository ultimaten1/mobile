package com.ultimate.b4_androidproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

public class Grid extends BaseAdapter {
    private Context context;
    private String[] gridColor;
    private LayoutInflater inflater;

    public Grid(Context context, String[] gridColor) {
        this.context = context;
        this.gridColor = gridColor;
    }

    @Override
    public int getCount() {
        return gridColor.length;
    }

    @Override
    public Object getItem(int position) {
        return gridColor[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(gridColor[position]));
        convertView.setBackground(colorDrawable);

        return convertView;
    }
}