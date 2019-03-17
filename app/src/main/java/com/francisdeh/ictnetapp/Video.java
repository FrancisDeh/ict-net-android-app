package com.francisdeh.ictnetapp;

/**
 * Created by FrancisDeh on 10/31/2017.
 */

public class Video {


    private String titleOfVideo;
    private String durationOfVideo;
    private String pathTitleOfVideo;


    public Video(String titleOfVideo, String pathTitleOfVideo, String durationOfVideo) {
        this.durationOfVideo = durationOfVideo;
        this.pathTitleOfVideo = pathTitleOfVideo;
        this.titleOfVideo = titleOfVideo;
    }


    public String getTitleOfVideo() {
        return titleOfVideo;
    }

    public void setTitleOfVideo(String titleOfVideo) {
        this.titleOfVideo = titleOfVideo;
    }

    public String getDurationOfVideo() {
        return durationOfVideo;
    }

    public void setDurationOfVideo(String durationOfVideo) {
        this.durationOfVideo = durationOfVideo;
    }

    public void setPathTitleOfVideo(String pathTitleOfVideo){
        this.pathTitleOfVideo = pathTitleOfVideo;
    }

    public String getPathTitleOfVideo(){
        return this.pathTitleOfVideo;
    }


}
