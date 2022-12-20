package com.example.cheemsfm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public CardView memes, audio_memes, Video_Memes, feedback,submit,Dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memes = (CardView) findViewById(R.id.memes);
        audio_memes = (CardView) findViewById(R.id.audio_memes);
        Video_Memes = (CardView) findViewById(R.id.Video_Memes);
        feedback = (CardView) findViewById(R.id.feedback);
        submit = (CardView) findViewById(R.id.submit);
        Dev = (CardView) findViewById(R.id.Dev);

        memes.setOnClickListener(this);
        audio_memes.setOnClickListener(this);
        Video_Memes.setOnClickListener(this);
        feedback.setOnClickListener(this);
        submit.setOnClickListener(this);
        Dev.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.memes:
                i = new Intent(this, Memes.class);
                startActivity(i);
                break;

            case R.id.audio_memes:
                i = new Intent(this, Doge_Stories.class);
                startActivity(i);
                break;

            case R.id.Video_Memes:
                i = new Intent(this, video_memes.class);
                startActivity(i);
                break;

            case R.id.feedback:
                i = new Intent(this, Feedback.class);
                startActivity(i);
                break;

            case R.id.submit:
                i = new Intent(this, submit.class);
                startActivity(i);
                break;
            case R.id.Dev:
                i = new Intent(this, Dev.class);
                startActivity(i);
                break;

        }
    }
}