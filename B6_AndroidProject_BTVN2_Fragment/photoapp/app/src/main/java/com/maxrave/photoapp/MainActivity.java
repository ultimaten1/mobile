package com.maxrave.photoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.maxrave.photoapp.adapter.ImageAdapter;
import com.maxrave.photoapp.data.PhotoData;
import com.maxrave.photoapp.data.model.Photo;
import com.maxrave.photoapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GridView gridView = binding.gridView;
        ArrayList<Photo> photos = PhotoData.generatePhotoData();
        ImageAdapter imageAdapter = new ImageAdapter(this, photos);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Photo photo = (Photo) adapterView.getItemAtPosition(i);
            Bundle args = new Bundle();
            args.putInt("id", photo.getId());
            startActivity(new Intent(MainActivity.this, DescriptionActivity.class).putExtras(args));
        });
    }
}