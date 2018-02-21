package com.colombomobilemeetup.demo2.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.colombomobilemeetup.demo2.database.User;
import com.colombomobilemeetup.demo2.database.UserRepository;


public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private User user;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User> getUser(int userId) {
        return userRepository.getUser(userId);
    }

    public void save(String fname, String lname) {
        if (user != null) {
            user.setFirstName(fname);
            user.setLastName(lname);
            userRepository.update(user);
        } else {
            userRepository.insert(new User(fname, lname));
        }
    }

    public void delete() {
        if (user != null) {
            userRepository.delete(user);
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (userRepository != null) {
            userRepository.clear();
        }
    }
}
