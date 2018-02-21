package com.colombomobilemeetup.demo1.lifecycle3;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.colombomobilemeetup.demo1.CountChangeListener;

import java.util.Timer;
import java.util.TimerTask;


public class CounterWithState implements LifecycleObserver {
    public static final String TAG = "Observer";
    private final CountChangeListener countChangeListener;
    private final LifecycleOwner lifecycleOwner;

    private int count;
    private Timer timer;


    public static void bind(LifecycleOwner lifecycleOwner, CountChangeListener countChangeListener, int initialCount) {
        new CounterWithState(lifecycleOwner, countChangeListener, initialCount);
    }

    private CounterWithState(LifecycleOwner lifecycleOwner, final CountChangeListener countChangeListener, int initialCount) {
        this.countChangeListener = countChangeListener;
        this.lifecycleOwner = lifecycleOwner;
        this.lifecycleOwner.getLifecycle().addObserver(this);
        this.count = initialCount;

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void create() {
        printLifecycleState("on_create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void start() {
        printLifecycleState("on_start");
        setValue(count);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void resume() {
        printLifecycleState("on_resume");
        startCounting();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void pause() {
        printLifecycleState("on_pause");
        stopCounting();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void stop() {
        printLifecycleState("on_stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void destroy() {
        printLifecycleState("on_destroy");
    }

    private void setValue(int count) {
        if (isActiveState()) {
            printLifecycleState("update");
            countChangeListener.onCount(count);
        }
    }

    private boolean isActiveState() {
        return lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }

    private void startCounting() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                setValue(count);

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

    void printLifecycleState(String tag) {
        Log.d(TAG, tag + " - > " + lifecycleOwner.getLifecycle().getCurrentState().name());
    }
}
