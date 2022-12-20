package com.example.cheemsfm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class player extends AppCompatActivity {
    private Button playpause;
    private Button previous;
    private Button next;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    boolean isPlaying = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        playpause = findViewById(R.id.playpause);
        seekBar = findViewById(R.id.seekBar);

        TextView textView = findViewById(R.id.textView6);
        mediaPlayer = MediaPlayer.create(this,R.raw.story2);
        mediaPlayer.start();
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /*mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://open.spotify.com/track/0uI7yAKUf52Cn7y3sYyjiX?si=f17eb3d084eb4a67");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(player.this, "Buffering", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        mediaPlayer.prepareAsync();*/



        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }
                isPlaying = !isPlaying;
            }
        });

    }
}