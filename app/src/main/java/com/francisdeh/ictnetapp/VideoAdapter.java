package com.francisdeh.ictnetapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/**
 * Created by FrancisDeh on 10/31/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<Video> videoList;
    private int previousPosition = 0;

    //Interface of click events
    public interface onListItemClick{
        void onItemClick(int itemClick);
    }

    private onListItemClick onListItemClick;

    public VideoAdapter(List<Video> videos, onListItemClick onListItemClick) {
        this.videoList = videos;
        this.onListItemClick = onListItemClick;
    }




    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_cards, parent, false);

        return new VideoViewHolder(rootView);
    }



    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        holder.setTitle(videoList.get(position).getTitleOfVideo());
        holder.setDuration(videoList.get(position).getDurationOfVideo());
        /*Code for animation*/
        if (position > previousPosition){
           AnimationsCustomUtils.animate(holder, true);

        }
        else {
           AnimationsCustomUtils.animate(holder, false);
        }
        previousPosition = position;

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

     class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        View myView;
        ImageView smallPlayIconImageView, largePlayIconImageView;

        public VideoViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            smallPlayIconImageView = (ImageView)myView.findViewById(R.id.play_button);
            largePlayIconImageView = (ImageView)myView.findViewById(R.id.video_list_image);
            smallPlayIconImageView.setOnClickListener(this);
            largePlayIconImageView.setOnClickListener(this);

        }

        public void setTitle(String title) {
            TextView textView = (TextView)myView.findViewById(R.id.video_list_title);
            textView.setText(title);
        }


        public void setDuration(String duration){
            TextView textView = (TextView)myView.findViewById(R.id.video_list_duration);
            textView.setText(duration);
        }

        @Override
        public void onClick(View v) {
            onListItemClick.onItemClick(getAdapterPosition());
        }
    }


}
