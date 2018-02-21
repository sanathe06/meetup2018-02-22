package com.colombomobilemeetup.demo2.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

public class UserRepository {
    UserDatabase userDatabase;

    public UserRepository(Context context) {
        userDatabase = UserDatabase.getAppDatabase(context);
    }

    public LiveData<List<User>> getUsers() {
        return userDatabase.userDao().getAll();
    }

    public void insert(User... users) {
        userDatabase.userDao().insert(users);
    }

    public void clear() {
        UserDatabase.destroyInstance();
    }

    public LiveData<User> getUser(int userId) {
        return userDatabase.userDao().getUser(userId);
    }

    public void update(User... users) {
        userDatabase.userDao().update(users);
    }

    public void delete(User... users) {
        userDatabase.userDao().delete(users);
    }
}
