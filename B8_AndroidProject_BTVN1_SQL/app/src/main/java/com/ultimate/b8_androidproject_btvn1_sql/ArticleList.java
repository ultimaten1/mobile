package com.ultimate.b8_androidproject_btvn1_sql;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArticleList {
    @SerializedName("articles")
    @Expose
    private ArrayList<Article> articles;
    public ArticleList(ArrayList<Article> articles) { this.setArticles (articles); }
    public ArrayList<Article> getArticles() { return articles; }
    public void setArticles (ArrayList<Article> articles) { this. articles = articles; }
}
