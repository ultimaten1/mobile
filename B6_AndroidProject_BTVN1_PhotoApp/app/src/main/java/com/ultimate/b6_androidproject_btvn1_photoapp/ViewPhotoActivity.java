package com.ultimate.b6_androidproject_btvn1_photoapp;

import static com.ultimate.b6_androidproject_btvn1_photoapp.PhotoData.generatePhotoData;
import static com.ultimate.b6_androidproject_btvn1_photoapp.PhotoData.getPhotoFromId;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPhotoActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Bitmap> {
    private ImageView imgDetail;
    private TextView txtDetailTitle, txtDetailDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);

        imgDetail = findViewById(R.id.imgDetail);
        txtDetailTitle = findViewById(R.id.txtDetailTitle);
        txtDetailDescription = findViewById(R.id.txtDetailDescription);

        int id = (int) getIntent().getLongExtra("id", 0);
//        new DownloadImage(imgDetail).execute((getPhotoFromId(id, generatePhotoData()).getSourcePhoto()));

//        Picasso.get()
//                .load(getPhotoFromId(id, generatePhotoData()).getSourcePhoto())
//                .resize(500, 500)
//                .centerCrop()
//                .into(imgDetail);

        LoaderManager.getInstance(this).initLoader(1, null, this).forceLoad();

        txtDetailTitle.setText((getPhotoFromId(id, generatePhotoData()).getTitlePhoto()));
        txtDetailDescription.setText((getPhotoFromId(id, generatePhotoData()).getDescriptionPhoto()));
    }

    @NonNull
    @Override
    public Loader<Bitmap> onCreateLoader(int id, @Nullable Bundle args) {
        int photoId = (int) getIntent().getLongExtra("id", 0);
        String imageUrl = getPhotoFromId(photoId, generatePhotoData()).getSourcePhoto();
        return new DownloadImageLoader(this, imageUrl);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Bitmap> loader, Bitmap data) {
        if (data != null) {
            imgDetail.setImageBitmap(data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Bitmap> loader) {

    }
}