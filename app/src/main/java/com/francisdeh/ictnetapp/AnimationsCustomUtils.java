package com.francisdeh.ictnetapp;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by FrancisDeh on 10/31/2017.
 */

public class AnimationsCustomUtils {

    public AnimationsCustomUtils(){

    }

    public static void animate(RecyclerView.ViewHolder holder , boolean goesDown){
        ObjectAnimator animator = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown==true ? 300:-300, 0);
        animator.setDuration(500);
        animator.start();
    }
}
