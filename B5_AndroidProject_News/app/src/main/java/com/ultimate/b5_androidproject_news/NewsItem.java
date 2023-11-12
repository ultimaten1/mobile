package com.ultimate.b5_androidproject_news;

public class NewsItem {
    private String photoUrl;
    private String title;
    private String description;


    public NewsItem(String photoUrl, String title, String description) {
        this.photoUrl = photoUrl;
        this.title = title;
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
