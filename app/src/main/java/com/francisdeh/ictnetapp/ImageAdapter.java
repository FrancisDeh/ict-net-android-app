package com.francisdeh.ictnetapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by FrancisDeh on 10/31/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{

    List<Image> imageList;
    private int previousPosition = 0;
    public imageClickListener clickListener;

    public ImageAdapter(List<Image> image, imageClickListener clickListener){
        this.imageList = image;
        this.clickListener = clickListener;
    }

    public interface imageClickListener{
        void onImageClick(int position);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_cards, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
    holder.setImageId(imageList.get(position).getImageId());
    holder.setTitle(imageList.get(position).getTitleOfImage());
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
        return imageList.size();
    }

    public  class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        View myView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
        }

        public void setImageId(int imageId){
            ImageView imageView = (ImageView)myView.findViewById(R.id.image_list);
            imageView.setImageResource(imageId);
            imageView.setOnClickListener(this);
        }

        public void setTitle(String title){
            TextView textView = (TextView)myView.findViewById(R.id.image_list_title);
            textView.setText(title);
        }

        @Override
        public void onClick(View v) {
            clickListener.onImageClick(getAdapterPosition());
        }
    }
}
