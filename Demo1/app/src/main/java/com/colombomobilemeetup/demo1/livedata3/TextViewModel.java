package com.colombomobilemeetup.demo1.livedata3;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

public class TextViewModel extends ViewModel {
    private MutableLiveData<String> input = new MutableLiveData<>();

    public LiveData<String> capital = Transformations.switchMap(input, this::getCapitalized);

    public LiveData<Integer> length = Transformations.map(input, input -> input != null ? input.length() : 0);

    public void setInput(String input) {
        this.input.setValue(input);
    }


    @NonNull
    private MutableLiveData<String> getCapitalized(String input) {
        MutableLiveData<String> output = new MutableLiveData<>();
        output.setValue(input != null ? input.toUpperCase() : "");
        return output;
    }
}
