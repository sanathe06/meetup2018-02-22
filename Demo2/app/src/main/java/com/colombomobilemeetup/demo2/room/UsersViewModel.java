package com.colombomobilemeetup.demo2.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.colombomobilemeetup.demo2.database.User;
import com.colombomobilemeetup.demo2.database.UserRepository;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public UsersViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<List<User>> getUsers() {
        return userRepository.getUsers();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (userRepository != null) {
            userRepository.clear();
        }
    }
}
