package com.colombomobilemeetup.demo2.sharedviewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class SharedViewModel extends AndroidViewModel {

    public MutableLiveData<String> item = new MutableLiveData<>();

    public SharedViewModel(@NonNull Application application) {
        super(application);
    }
}
