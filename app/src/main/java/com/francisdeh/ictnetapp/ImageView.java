package com.francisdeh.ictnetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class ImageView extends AppCompatActivity {

   android.widget.ImageView imageView;
    TextView textView;
    Button prevBtn, randBtn, nextBtn;
    Toolbar toolbar;
    //image index
    private int imageIndex;
    private static String IMAGE_NUMBER;

    List<Image> imageList = DataSource.getImages();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

       imageView = (android.widget.ImageView)findViewById(R.id.image);
        textView = (TextView)findViewById(R.id.text);
        prevBtn = (Button)findViewById(R.id.prev_btn);
        randBtn = (Button)findViewById(R.id.rand_btn);
        nextBtn = (Button)findViewById(R.id.next_btn);
        toolbar = (Toolbar)findViewById(R.id.toolbar);


        toolbar.setTitle("Networking Images");
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(savedInstanceState != null){
            imageIndex = savedInstanceState.getInt(IMAGE_NUMBER, 0);
            setImageAndText(imageIndex);
        } else {
            //intent will be received here
            if (getIntent().hasExtra(Classroom.IMAGE_INDEX)) {
                imageIndex = getIntent().getIntExtra(Classroom.IMAGE_INDEX, 0);
                setImageAndText(imageIndex);
            }
        }

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePreviousImage();

            }
        });

        randBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               generateRandomImage();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNextImage();
            }
        });

    }

    private void setImageAndText(int position){
        if(!(position < 0) && (position != imageList.size())){
            Image image = imageList.get(position);

            imageView.setImageResource(image.getImageId());
            textView.setText(image.getTitleOfImage());
        }



    }

    private void generatePreviousImage() {
        int newImageIndex = --imageIndex;
        if(newImageIndex < 0){
            newImageIndex = imageList.size() - 1;
            imageIndex = imageList.size() - 1;
        }

        setImageAndText(newImageIndex);

    }

    private void generateRandomImage() {
        int randomImageIndex = (int)(Math.random() * imageList.size());
        imageIndex = randomImageIndex;
        setImageAndText(randomImageIndex);


    }

    private void generateNextImage() {
        int newImageIndex = ++imageIndex;
        if(newImageIndex == imageList.size()){
            newImageIndex = 0;
            imageIndex = 0;
        }

        setImageAndText(newImageIndex);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(IMAGE_NUMBER, imageIndex);
    }
}
