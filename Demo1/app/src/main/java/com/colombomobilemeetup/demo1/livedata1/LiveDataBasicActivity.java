package com.colombomobilemeetup.demo1.livedata1;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.colombomobilemeetup.demo1.R;

import java.util.Timer;
import java.util.TimerTask;

public class LiveDataBasicActivity extends AppCompatActivity {


    private Timer timer;
    private int count = 0;
    private TextView textViewCount;

    MutableLiveData<Integer> data =new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_basic);
        textViewCount = findViewById(R.id.textViewCount112);
        data.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textViewCount.setText(integer.toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        startCounting();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCounting();
    }

    private void startCounting() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                data.postValue(count);

            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    private void stopCounting() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }
}
