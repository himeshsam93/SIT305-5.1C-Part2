package com.example.istream.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String fullName;
    public String username;
    public String password;
}
