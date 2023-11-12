package com.ultimate.b8_androidproject_btvn2_firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView_Config {
    private Context context;

    class ArticleItemView extends RecyclerView.ViewHolder {
        private ImageView article_image;
        private TextView article_title;

        private String key;

        public ArticleItemView(ViewGroup parent) {
            super(LayoutInflater.from(context)
                    .inflate(R.layout.article_disp_tpl, parent, false));


        }
    }
}
