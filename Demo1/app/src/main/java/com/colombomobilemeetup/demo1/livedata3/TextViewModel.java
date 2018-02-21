package com.colombomobilemeetup.demo1.livedata3;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

public class TextViewModel extends ViewModel {
    private MutableLiveData<String> input = new MutableLiveData<>();


    public LiveData<String> capsWithSwitchMap = Transformations.switchMap(input, new Function<String, LiveData<String>>() {
        @Override
        public LiveData<String> apply(String input) {
            MutableLiveData<String> output = new MutableLiveData<>();
            output.setValue(input != null ? input.toUpperCase() : "");
            return output;
        }
    });

    public LiveData<Integer> capsWithMap = Transformations.map(input, new Function<String, Integer>() {
        @Override
        public Integer apply(String input) {
            return input != null ? input.length() : 0;
        }
    });

    public void setInput(String input) {
        this.input.setValue(input);
    }
}
