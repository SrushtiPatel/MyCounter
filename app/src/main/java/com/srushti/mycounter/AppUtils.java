package com.srushti.mycounter;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class AppUtils {

    public static void showToast(Context pContext, String pStrMsg){
        Toast.makeText(pContext, pStrMsg, Toast.LENGTH_SHORT).show();
    }


    public static void startZoomInAnimation(Context pContext, View pView) {
        final Animation myAnim = AnimationUtils.loadAnimation(pContext, R.anim.button_bounce);
        pView.startAnimation(myAnim);
    }

    public static void startBounceAnimation(Context pContext, View pView) {
        final Animation myAnim = AnimationUtils.loadAnimation(pContext, R.anim.button_bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        pView.startAnimation(myAnim);
    }
}
