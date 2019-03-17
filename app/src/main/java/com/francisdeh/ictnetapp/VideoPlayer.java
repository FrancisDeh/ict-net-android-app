package com.francisdeh.ictnetapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import uk.co.jakelee.vidsta.VidstaPlayer;

public class VideoPlayer extends AppCompatActivity {

    private List<Video> videoList = DataSource.getVideos();
    private String videoTitle;
    VidstaPlayer vidstaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);



        if(getIntent().hasExtra(Classroom.VIDEO_INDEX)){
            int videoIndex = getIntent().getIntExtra(Classroom.VIDEO_INDEX, 1);

            videoTitle = videoList.get(videoIndex).getPathTitleOfVideo();
        }

        vidstaPlayer = (VidstaPlayer)findViewById(R.id.player);
        vidstaPlayer.setAutoLoop(true);
        vidstaPlayer.setAutoPlay(true);

        setSource(videoTitle);

    }

    private void setSource(String title){
        Uri uri = Uri.parse("android.resource://"+ getPackageName() + "/raw/" + title);
        vidstaPlayer.setVideoSource(uri);
    }


}
