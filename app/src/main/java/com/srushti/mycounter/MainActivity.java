package com.srushti.mycounter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_counter)
    Button mBtnCounter;
    @BindView(R.id.tv_score)
    TextView mTvScore;

    private int mSessionScore;
    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;

        setListener();
    }

    private void setListener() {
        mBtnCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AppUtils.showToast(mContext, "button clicked");
                setSessionScore(++mSessionScore);
//                mBtnCounter.setEnabled(true);
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mBtnCounter.setActivated(false);
//                    }
//                }, 100);
                AppUtils.startBounceAnimation(mContext, view);
            }
        });
    }


    private void setSessionScore(int pIntScore) {
        mTvScore.setText(String.format("Your Score: %s", pIntScore));
    }
}
