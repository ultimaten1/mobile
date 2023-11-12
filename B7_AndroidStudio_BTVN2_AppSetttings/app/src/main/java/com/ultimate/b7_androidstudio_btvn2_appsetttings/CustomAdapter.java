package com.ultimate.b7_androidstudio_btvn2_appsetttings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.graphics.Color;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] colors;
    private int[] colorCodes;

    public CustomAdapter(Context context, String[] colors, int[] colorCodes) {
        this.context = context;
        this.colors = colors;
        this.colorCodes = colorCodes;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_gridview, null);
        }

        View viewColor = view.findViewById(R.id.viewColor);
        TextView txtGridViewItem = view.findViewById(R.id.txtGridViewItem);

        int color = context.getResources().getColor(colorCodes[position]);
        viewColor.setBackgroundColor(color);

        txtGridViewItem.setText(colors[position]);

        return view;
    }
}


