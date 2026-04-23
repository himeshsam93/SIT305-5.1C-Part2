package com.example.istream.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM User WHERE username=:u AND password=:p")
    User login(String u, String p);
}