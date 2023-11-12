package com.ultimate.b6_androidproject_btvn1_photoapp;

import static com.ultimate.b6_androidproject_btvn1_photoapp.PhotoData.generatePhotoData;
import static com.ultimate.b6_androidproject_btvn1_photoapp.PhotoData.getPhotoFromId;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    private ArrayList<Photo> photoArrayList;
    private Context context;

    public PhotoAdapter(ArrayList<Photo> photoArrayList, Context context) {
        this.photoArrayList = photoArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return photoArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return photoArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyView dataItem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            dataItem = new MyView();
            convertView = inflater.inflate((R.layout.photo_disp_tpl), null);
            dataItem.imgPhoto = convertView.findViewById(R.id.imgPhoto);
            dataItem.txtCaption = convertView.findViewById(R.id.txtTitle);
            convertView.setTag(dataItem);
        }
        else {
            dataItem = (MyView) convertView.getTag();
        }

//        new DownloadImage(dataItem.imgPhoto).execute(photoArrayList.get(position).getSourcePhoto());

        String imageUrl = photoArrayList.get(position).getSourcePhoto();
        DownloadImageLoader imageLoader = new DownloadImageLoader(context, imageUrl);
        imageLoader.forceLoad();
        imageLoader.registerListener(0, new Loader.OnLoadCompleteListener<Bitmap>() {
            @Override
            public void onLoadComplete(Loader<Bitmap> loader, Bitmap data) {
                if (data != null) {
                    dataItem.imgPhoto.setImageBitmap(data);
                }
            }
        });

//        Picasso.get()
//                .load(photoArrayList.get(position).getSourcePhoto())
//                .resize(400, 400)
//                .centerCrop()
//                .into(dataItem.imgPhoto);

        dataItem.txtCaption.setText(photoArrayList.get(position).getTitlePhoto());

        return convertView;
    }

    public static class MyView {
        private ImageView imgPhoto;
        private TextView txtCaption;
    }
}
