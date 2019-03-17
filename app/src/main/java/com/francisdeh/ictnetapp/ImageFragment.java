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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FrancisDeh on 10/29/2017.
 */

public class ImageFragment extends Fragment implements ImageAdapter.imageClickListener {
    RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    List<Image> imageList;
    onFragmentInteractionListener fragmentInteraction;

    public ImageFragment(){

    }

    public interface onFragmentInteractionListener{
        void onFragementItemSelected(int position);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeImageList();


    }

    private void initializeImageList() {
        imageList = DataSource.getImages();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gallery_fragment_layout, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.image_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setMoveDuration(2000);
        recyclerView.setItemAnimator(animator);

        imageAdapter = new ImageAdapter(imageList, this);
        recyclerView.setAdapter(imageAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof onFragmentInteractionListener){
            fragmentInteraction = (onFragmentInteractionListener)context;
        }
        else {
            throw new RuntimeException(context.toString() + " must implement onFragmentInteractionListener.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInteraction = null;
    }

    @Override
    public void onImageClick(int position) {
        fragmentInteraction.onFragementItemSelected(position);
    }
}
