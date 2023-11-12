package com.example.photo_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageDetail extends AppCompatActivity {

    TextView txt_detail,show_detail;
    ImageView singleimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        txt_detail = findViewById(R.id.txt_detail);
        show_detail = findViewById(R.id.show_detail);
        singleimg = findViewById(R.id.singleimg);

        Picasso.get().load(getIntent().getStringExtra("img")).into(singleimg);
        txt_detail.setText(getIntent().getStringExtra("name"));

        //Chưa tạo Description cho MainActivity
        show_detail.setText(getIntent().getStringExtra("des"));
    }
}