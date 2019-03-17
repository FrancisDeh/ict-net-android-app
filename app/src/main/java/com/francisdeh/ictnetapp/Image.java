package com.francisdeh.ictnetapp;

/**
 * Created by FrancisDeh on 10/31/2017.
 */

public class Image {
    private String titleOfImage;

    private int imageId;

    public Image(String titleOfImage, int imageId) {
        this.titleOfImage = titleOfImage;
        this.imageId = imageId;
    }

    public String getTitleOfImage() {
        return titleOfImage;
    }

    public void setTitleOfImage(String titleOfImage) {
        this.titleOfImage = titleOfImage;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }






}
