package com.example.istream.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.istream.R;
import com.example.istream.db.*;

public class HomeActivity extends AppCompatActivity {

    EditText url;
    AppDatabase db;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        url = findViewById(R.id.url);
        db = AppDatabase.getInstance(this);

        userId = getIntent().getIntExtra("userId", -1);
    }

    public void play(View v) {

        String videoUrl = url.getText().toString();

        if (!videoUrl.contains("youtube")) {
            Toast.makeText(this, "Invalid URL", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(this, PlayerActivity.class);
        i.putExtra("url", videoUrl);
        startActivity(i);
    }

    public void addToPlaylist(View v) {

        Playlist p = new Playlist();
        p.userId = userId;
        p.videoUrl = url.getText().toString();

        db.playlistDao().insert(p);

        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
    }

    public void openPlaylist(View v) {
        Intent i = new Intent(this, PlaylistActivity.class);
        i.putExtra("userId", userId);
        startActivity(i);
    }

    public void logout(View v) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}