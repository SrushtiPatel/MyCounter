package com.srushti.mycounter

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.ButterKnife

class MainActivity : AppCompatActivity() {

    //    @BindView(R.id.btn_counter)
//    internal var mBtnCounter: Button? = null
//    @BindView(R.id.tv_score)
//    internal var mTvScore: TextView? = null
    lateinit var mBtnCounter: Button
    lateinit var mTvScore: TextView
    private var mSessionScore: Int = 0
    private var mContext: Context = this@MainActivity

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
        mTvScore = findViewById(R.id.tv_score)
    }

    private fun setListener() {
        mBtnCounter.setOnClickListener { view: View ->
            //                AppUtils.showToast(mContext, "button clicked");
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
    }


    private fun setSessionScore(pIntScore: Int) {
        mTvScore.text = String.format(getString(R.string.txt_your_score), pIntScore)
    }
}
