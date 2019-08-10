package com.srushti.mycounter.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.srushti.mycounter.animutils.MyBounceInterpolator
import com.srushti.mycounter.R

object AppUtils {

    fun showToast(pContext: Context, pStrMsg: String) {
        Toast.makeText(pContext, pStrMsg, Toast.LENGTH_SHORT).show()
    }


    fun startZoomInAnimation(pContext: Context, pView: View) {
        val myAnim = AnimationUtils.loadAnimation(pContext, R.anim.button_bounce)
        pView.startAnimation(myAnim)
    }

    fun startBounceAnimation(pContext: Context, pView: View) {
        val myAnim = AnimationUtils.loadAnimation(pContext, R.anim.button_bounce)
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        val interpolator = MyBounceInterpolator(0.2, 20.0)
        myAnim.interpolator = interpolator

        pView.startAnimation(myAnim)
    }
}
