package com.francisdeh.ictnetapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Type;

public class Launcher extends AppCompatActivity {
    TextView appTextView;
    TextView titleTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        appTextView = (TextView)findViewById(R.id.app_name);
        titleTextView = (TextView)findViewById(R.id.app_text);

        appTextView.setTypeface(Typeface.createFromAsset(getAssets(), "greecian.ttf"));
        titleTextView.setTypeface(Typeface.createFromAsset(getAssets(), "greecian.ttf"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Launcher.this, Classroom.class));
                finish();
            }
        }, 3000);


    }
}
