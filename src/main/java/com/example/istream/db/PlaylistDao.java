package com.example.istream.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlaylistDao {

    @Insert
    void insert(Playlist playlist);

    @Query("SELECT * FROM Playlist WHERE userId=:uid")
    List<Playlist> getUserPlaylist(int uid);
}
