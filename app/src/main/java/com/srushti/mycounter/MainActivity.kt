package com.srushti.mycounter

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.ButterKnife
import com.srushti.mycounter.utils.AppUtils

class MainActivity : AppCompatActivity() {

    //    @BindView(R.id.btn_counter)
//    internal var mBtnCounter: Button? = null
//    @BindView(R.id.tv_score)
//    internal var mTvScore: TextView? = null
    lateinit var mBtnCounter: Button
    lateinit var mBtnResetGame: Button
    lateinit var mTvScore: TextView
    lateinit var mTvDisplayTime: TextView
    private var mSessionScore: Int = 0
    private var mContext: Context = this@MainActivity
    private lateinit var mTimer: CountDownTimer
    val COUNTDOWN_INTERVAL: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        mContext = this

        initViews();
        setListener()
    }

    private fun initViews() {
        mBtnCounter = findViewById(R.id.btn_counter)
        mBtnResetGame = findViewById(R.id.btn_reset)
        mTvScore = findViewById(R.id.tv_your_score)
        mTvDisplayTime = findViewById(R.id.tv_time)
    }

    private fun setListener() {
        mBtnCounter.setOnClickListener { view: View ->
            //                AppUtils.showToast(mContext, "button clicked");
            startTimer()
            setSessionScore(++mSessionScore)
            //                mBtnCounter.setEnabled(true);
            //                Handler handler = new Handler();
            //                handler.postDelayed(new Runnable() {
            //                    @Override
            //                    public void run() {
            //                        mBtnCounter.setActivated(false);
            //                    }
            //                }, 100);
            AppUtils.startBounceAnimation(mContext, view)
        }

        mBtnResetGame.setOnClickListener { view: View ->
            stopTimer()
        }
    }


    private fun setSessionScore(pIntScore: Int) {
        mTvScore.text = String.format(getString(R.string.txt_your_score), pIntScore)
    }

    private fun startTimer() {
        if(null == mTimer){
            mTimer = getTimer(60 * 1000, COUNTDOWN_INTERVAL).start()
        } else {
            resumeTimer()
        }
    }

    private fun getTimer(pDuration: Long, pIntCountDownInterval: Long): CountDownTimer {
        return object : CountDownTimer(pDuration, pIntCountDownInterval) {
            override fun onFinish() {
                onTimeUp();
            }

            override fun onTick(pTimeRemaining: Long) {
                showTimeOnScreen(pTimeRemaining);
            }

        }
    }

    private fun showTimeOnScreen(pTimeRemaining: Long) {
        val time = pTimeRemaining / 1000
        setTimerValue(time.toString())
    }

    private fun setTimerValue(strTime: String) {
        mTvDisplayTime.text = strTime
    }

    private fun onTimeUp() {
        AppUtils.showToast(this, "Time up!!!")
    }

    private fun stopTimer() {
        mTimer.cancel()
    }

    private fun pauseTimer() {
        mTimer.cancel()
    }

    private fun resumeTimer() {

    }
}
