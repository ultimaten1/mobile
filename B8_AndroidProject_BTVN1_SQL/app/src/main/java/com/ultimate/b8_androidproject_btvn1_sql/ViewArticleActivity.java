package com.ultimate.b8_androidproject_btvn1_sql;

import static com.ultimate.b8_androidproject_btvn1_sql.ArticleData.getPhotoFromId;

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

public class ViewArticleActivity extends AppCompatActivity {
    private ImageView imgDetail;
    private TextView txtDetailTitle, txtDetailDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_article);

        imgDetail = findViewById(R.id.imgDetail);
        txtDetailTitle = findViewById(R.id.txtDetailTitle);
        txtDetailDescription = findViewById(R.id.txtDetailDescription);

        int id = (int) getIntent().getLongExtra("id", 0);

        Picasso.get()
                .load(ArticleData.getPhotoFromId(id).getArticle_image())
                .resize(500, 500)
                .centerCrop()
                .into(imgDetail);

        txtDetailTitle.setText((ArticleData.getPhotoFromId(id).getArticle_title()));
        txtDetailDescription.setText((ArticleData.getPhotoFromId(id).getArticle_description()));
    }
}