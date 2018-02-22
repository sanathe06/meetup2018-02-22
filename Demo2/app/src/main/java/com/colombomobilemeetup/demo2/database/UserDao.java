package com.colombomobilemeetup.demo2.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User... users);

    @Query("select * from User")
    LiveData<List<User>> getAll();

    @Query("select * from User where id=:userId")
    LiveData<User> getUser(int userId);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

    @Query("select firstName from user")
    LiveData<List<NameTuple>> firstNames();

    public class NameTuple{
        public String firstName;
    }
}
