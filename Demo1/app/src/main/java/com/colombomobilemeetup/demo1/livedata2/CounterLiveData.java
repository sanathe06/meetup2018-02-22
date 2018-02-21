package com.colombomobilemeetup.demo1.livedata2;

import android.arch.lifecycle.MutableLiveData;

import java.util.Timer;
import java.util.TimerTask;

public class CounterLiveData extends MutableLiveData<Integer>{
    private Timer timer;
    private int count = 0;
    @Override
    protected void onActive() {
        super.onActive();
        startCounting();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        stopCounting();
    }

    private void startCounting() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                postValue(count);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    public static CounterLiveData get() {
        return new CounterLiveData();
    }

    private void stopCounting() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }
}
