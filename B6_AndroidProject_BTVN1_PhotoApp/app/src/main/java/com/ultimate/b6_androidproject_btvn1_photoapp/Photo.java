package com.ultimate.b6_androidproject_btvn1_photoapp;

import android.graphics.Bitmap;

public class Photo {
    private int id;
    private String sourcePhoto;
    private String titlePhoto;
    private String descriptionPhoto;

    public Photo(int id, String sourcePhoto, String titlePhoto, String descriptionPhoto) {
        this.id = id;
        this.sourcePhoto = sourcePhoto;
        this.titlePhoto = titlePhoto;
        this.descriptionPhoto = descriptionPhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourcePhoto() {
        return sourcePhoto;
    }

    public void setSourcePhoto(String sourcePhoto) {
        this.sourcePhoto = sourcePhoto;
    }

    public String getTitlePhoto() {
        return titlePhoto;
    }

    public void setTitlePhoto(String titlePhoto) {
        this.titlePhoto = titlePhoto;
    }

    public String getDescriptionPhoto() {
        return descriptionPhoto;
    }

    public void setDescriptionPhoto(String descriptionPhoto) {
        this.descriptionPhoto = descriptionPhoto;
    }
}
