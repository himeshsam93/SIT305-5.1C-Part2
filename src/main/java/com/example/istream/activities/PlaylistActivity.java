package com.example.istream.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.istream.R;
import com.example.istream.db.*;

import java.util.*;

public class PlaylistActivity extends AppCompatActivity {

    ListView listView;
    AppDatabase db;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        listView = findViewById(R.id.listView);
        db = AppDatabase.getInstance(this);

        userId = getIntent().getIntExtra("userId", -1);

        List<Playlist> list = db.playlistDao().getUserPlaylist(userId);

        List<String> urls = new ArrayList<>();
        for (Playlist p : list) {
            urls.add(p.videoUrl);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, urls);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((a, b, pos, id) -> {
            Intent i = new Intent(this, PlayerActivity.class);
            i.putExtra("url", urls.get(pos));
            startActivity(i);
        });
    }
}
