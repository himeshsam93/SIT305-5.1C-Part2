package com.example.istream.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Playlist {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int userId;
    public String videoUrl;
}
