package com.francisdeh.ictnetapp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FrancisDeh on 10/29/2017.
 */

public class VideoFragment extends Fragment implements VideoAdapter.onListItemClick{

   RecyclerView recyclerView;
   VideoAdapter videoAdapter;
   List<Video> videoList;
   private onFragmentInteractionListener onFragmentInteractionListener;

    public VideoFragment(){

    }

    //fragment interaction listener
    public interface onFragmentInteractionListener{
        void onFragmentInteraction(int videoIndex);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeVideoList();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.video_fragment_layout, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.video_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setMoveDuration(2000);
        recyclerView.setItemAnimator(animator);

        videoAdapter = new VideoAdapter(videoList, this);
        recyclerView.setAdapter(videoAdapter);
        return view;
    }

    private void initializeVideoList() {
        videoList = DataSource.getVideos();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof onFragmentInteractionListener){
            onFragmentInteractionListener = (onFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onFragmentInteractionListener.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }

    @Override
    public void onItemClick(int itemClick) {
        //send the video info to the parent activity
        onFragmentInteractionListener.onFragmentInteraction(itemClick);
    }
}
