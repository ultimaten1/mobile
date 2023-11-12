package com.maxrave.photoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxrave.photoapp.R;
import com.maxrave.photoapp.data.model.Photo;
import com.maxrave.photoapp.download.DownloadImage;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private ArrayList<Photo> photos;
    private Context context;
    public ImageAdapter(Context context, ArrayList<Photo> photos) {
        this.photos = photos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public Object getItem(int i) {
        return photos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return photos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater layoutInflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        }
        ImageView iv = view.findViewById(R.id.imageView);
        TextView tvTitle = view.findViewById(R.id.textView);
        tvTitle.setText(photos.get(i).getTitle_photo());
        DownloadImage downloadImage = new DownloadImage(iv);
        downloadImage.execute(photos.get(i).getSource_photo());

        return view;
    }
}
