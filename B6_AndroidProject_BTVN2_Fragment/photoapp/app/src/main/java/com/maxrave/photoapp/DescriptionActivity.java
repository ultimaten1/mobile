package com.maxrave.photoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maxrave.photoapp.data.PhotoData;
import com.maxrave.photoapp.data.model.Photo;
import com.maxrave.photoapp.databinding.ActivityDescriptionBinding;
import com.maxrave.photoapp.download.DownloadImage;

public class DescriptionActivity extends AppCompatActivity {

    ActivityDescriptionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle args = getIntent().getExtras();
        assert args != null;
        int id = args.getInt("id");

        Photo photo = PhotoData.getPhotoById(id);
        assert photo != null;
        binding.tvTitle.setText(photo.getTitle_photo());
        binding.tvDescription.setText(photo.getDescription_photo());
        DownloadImage downloadImage = new DownloadImage(binding.imageView);
        downloadImage.execute(photo.getSource_photo());
    }
}