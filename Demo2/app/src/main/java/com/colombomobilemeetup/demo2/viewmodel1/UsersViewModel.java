package com.colombomobilemeetup.demo2.viewmodel1;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.colombomobilemeetup.demo2.User;
import com.colombomobilemeetup.demo2.UserRepository;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {

    private MutableLiveData<List<User>> users;

    private MutableLiveData<Boolean> progress = new MutableLiveData<>();

    public UsersViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadingData();
        }
        return users;
    }

    private void loadingData() {
        Handler handler = new Handler();
        progress.setValue(true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                users.postValue(UserRepository.getUsers());
                progress.postValue(false);
            }
        }, 3000);
    }

    public LiveData<Boolean> getProgress() {
        return progress;
    }

    public void refresh() {
        //loadingData();
        List<User> value = users.getValue();
        value.add(0,new User("Kim","Jong"));
        users.setValue(value);
    }
}
