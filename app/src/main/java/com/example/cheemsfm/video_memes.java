package com.example.cheemsfm;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Vector;

public class video_memes extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YoutubeVideo>youtubeVideos = new Vector<YoutubeVideo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_memes);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewN);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/Y2gvoFf0pkk\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/Wdg91NY17bA\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/dWXkVj6oTF4\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/m_fRAADBwXk\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/Xrsotja1oYQ\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/Rtt0OJhUCIk\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/kM-gF1ArEi8?t=2\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/QAGg8C1WydQ\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/AQe8GOIFDdM\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/lF0x-wyeL_g\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/bQz9tjXkF1o?t=2\" frameborder = \"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width = \"100%\" src=\"https://www.youtube.com/embed/HunpE-7FKhY?t=12\" frameborder = \"0\" allowfullscreen></iframe>"));
        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }
}