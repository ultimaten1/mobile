package com.ultimate.b6_androidproject_btvn2_fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    private List<Bitmap> images;

    public void setImages(List<Bitmap> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images != null ? images.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return images != null ? images.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(600, 600));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        if (images != null && position < images.size()) {
            imageView.setImageBitmap(images.get(position));
        } else {
            imageView.setImageResource(android.R.drawable.ic_menu_gallery);
        }

        return imageView;
    }
}

