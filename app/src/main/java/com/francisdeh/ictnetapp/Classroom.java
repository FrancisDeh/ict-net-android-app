package com.francisdeh.ictnetapp;
/*
Completed on Wednesday, 2017, November 22.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Classroom extends AppCompatActivity implements TabLayout.OnTabSelectedListener, VideoFragment.onFragmentInteractionListener, ImageFragment.onFragmentInteractionListener, TermsFragment.onFragmentInteraction {
    android.support.v7.widget.Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    private int[] SELECTED_ICONS = {R.drawable.video_icon, R.drawable.image_icon, R.drawable.term_icon};
    private int[] UNSELECTED_ICONS = {R.drawable.video_icon_unselected, R.drawable.image_icon_unselected, R.drawable.term_icon_unselected};
    private String[] FRAGMENT_TITLE = {"Networking Videos", "Networking Images", "Networking Terms"};

    //intent index for video
    public static String VIDEO_INDEX = "VIDEO_INDEX";
    //intent index for image
    public static String IMAGE_INDEX = "IMAGE_INDEX";
    //intent index for term
    public static String TERM_INDEX = "TERM_INDEX";

    //Alert Dialog views
    TextView lecturerName, courseTitle, indexNumber, developerName, licenseTitle, licenseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(FRAGMENT_TITLE[0]);
        setSupportActionBar(toolbar);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);


        tabLayout.getTabAt(0).setIcon(SELECTED_ICONS[0]);
        tabLayout.getTabAt(1).setIcon(SELECTED_ICONS[1]);
        tabLayout.getTabAt(2).setIcon(SELECTED_ICONS[2]);

    }

    private void setupViewPager(ViewPager viewPager) {
        MyFragmentAdapter fragmentAdapter  = new MyFragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(new VideoFragment());
        fragmentAdapter.addFragment(new ImageFragment());
        fragmentAdapter.addFragment(new TermsFragment());

        viewPager.setAdapter(fragmentAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.appInfo){
            //display dialog box
           displayDialog();

        }
        return super.onOptionsItemSelected(item);
    }

    private void displayDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ictnetapp v 1.0");

        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.app_info_layout, null);
        courseTitle = (TextView)view.findViewById(R.id.course_title);
        indexNumber = (TextView)view.findViewById(R.id.index_number);
        developerName = (TextView)view.findViewById(R.id.developer_name);
        licenseText = (TextView)view.findViewById(R.id.license_text_title);
        licenseTitle = (TextView)view.findViewById(R.id.license_text);
        lecturerName = (TextView)view.findViewById(R.id.lecturer_name);

        builder.setView(view);
        builder.setIcon(R.mipmap.launcher_logo);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.setIcon(SELECTED_ICONS[tab.getPosition()]);
        toolbar.setTitle(FRAGMENT_TITLE[tab.getPosition()]);

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.setIcon(UNSELECTED_ICONS[tab.getPosition()]);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        tab.setIcon(SELECTED_ICONS[tab.getPosition()]);
    }

    @Override
    public void onFragmentInteraction(int videoIndex) {
        //open another activity and display the video
        Intent intent = new Intent(Classroom.this, VideoPlayer.class);
        intent.putExtra(VIDEO_INDEX,videoIndex);
        startActivity(intent);
    }

    @Override
    public void onFragementItemSelected(int position) {
        //open another activity and display the image
        Intent imageIntent = new Intent(Classroom.this, ImageView.class);
        imageIntent.putExtra(IMAGE_INDEX, position);
        startActivity(imageIntent);
    }

    @Override
    public void onFragmentClick(int position) {
        //open another activity and display the term
        Intent termIntent = new Intent(Classroom.this, TermView.class);
        termIntent.putExtra(TERM_INDEX, position);
        startActivity(termIntent);
    }
}
