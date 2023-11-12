package com.ultimate.b8_androidproject_btvn2_firebase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {
    private String article_description;
    private String article_image;
    private String article_title;
    private int article_id;

    public Article() {

    }

    public Article(String article_description, String article_image, String article_title, int article_id) {
        this.article_description = article_description;
        this.article_image = article_image;
        this.article_title = article_title;
        this.article_id = article_id;
    }

    public String getArticleDescription() {
        return article_description;
    }

    public String getArticleImage() {
        return article_image;
    }

    public String getArticleTitle() {
        return article_title;
    }
    public int getArticle_id() {
        return article_id;
    }
}

