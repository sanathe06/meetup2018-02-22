package com.colombomobilemeetup.demo1.viewmodel1;


import android.arch.lifecycle.ViewModel;

import com.colombomobilemeetup.demo1.livedata2.CounterLiveData;

public class CounterViewModel extends ViewModel {
    public CounterLiveData counterLiveData = new CounterLiveData();
}
