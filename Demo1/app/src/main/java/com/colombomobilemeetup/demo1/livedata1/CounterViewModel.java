package com.colombomobilemeetup.demo1.livedata1;


import android.arch.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    public CounterLiveData getCounter() {
        return CounterLiveData.get();
    }
}
