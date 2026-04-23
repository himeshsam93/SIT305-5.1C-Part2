package com.example.istream.activities;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.istream.R;

public class PlayerActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        webView = findViewById(R.id.webView);

        String url = getIntent().getStringExtra("url");

        String videoId = "";

        if (url.contains("v=")) {
            videoId = url.split("v=")[1];
        } else if (url.contains("youtu.be/")) {
            videoId = url.split("youtu.be/")[1];
        }

        if (videoId.contains("&")) {
            videoId = videoId.split("&")[0];
        }

        String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"
                + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(html, "text/html", "utf-8");
    }
}
