package com.example.cheemsfm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class Memes extends AppCompatActivity {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.m48, R.drawable.m49,R.drawable.m50,
            R.drawable.m41,R.drawable.m42,R.drawable.m43,R.drawable.m44,R.drawable.m45,R.drawable.m46,R.drawable.m47,R.drawable.m37,R.drawable.m33,R.drawable.m34,R.drawable.m35,R.drawable.m36,R.drawable.m32,R.drawable.m38,R.drawable.m39,R.drawable.m40,R.drawable.m31,R.drawable.m, R.drawable.m30,
            R.drawable.m29, R.drawable.m28, R.drawable.m27, R.drawable.m26,
            R.drawable.m25, R.drawable.m24, R.drawable.m23, R.drawable.m22,
            R.drawable.m21, R.drawable.m20, R.drawable.m19, R.drawable.m18,
            R.drawable.m17, R.drawable.m15, R.drawable.m14,
            R.drawable.m13, R.drawable.m12, R.drawable.m11, R.drawable.m10,
            R.drawable.m9, R.drawable.m8, R.drawable.m7, R.drawable.m6,R.drawable.m5, R.drawable.m4, R.drawable.m3, R.drawable.m2, R.drawable.m1));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memes);
        MediaPlayer mintro = MediaPlayer.create(this, R.raw.mintro);
        mintro.start();
        recyclerView = findViewById(R.id.recyclerView_new);
        /*images = new int[]{R.drawable.m37,R.drawable.m33,R.drawable.m34,R.drawable.m35,R.drawable.m36,R.drawable.m32,R.drawable.m38,R.drawable.m39,R.drawable.m40,R.drawable.m31,R.drawable.m, R.drawable.m30,
                R.drawable.m29, R.drawable.m28, R.drawable.m27, R.drawable.m26,
                R.drawable.m25, R.drawable.m24, R.drawable.m23, R.drawable.m22,
                R.drawable.m21, R.drawable.m20, R.drawable.m19, R.drawable.m18,
                R.drawable.m17, R.drawable.m16, R.drawable.m15, R.drawable.m14,
                R.drawable.m13, R.drawable.m12, R.drawable.m11, R.drawable.m10,
                R.drawable.m9, R.drawable.m8, R.drawable.m7, R.drawable.m6,R.drawable.m5, R.drawable.m4, R.drawable.m3, R.drawable.m2, R.drawable.m1};*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Memes.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(Memes.this, images,Memes.this);
        recyclerView.setAdapter(myAdapter);
        swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                RearrangeItems();
            }
        });

    }
    public void RearrangeItems(){
        Collections.shuffle(images, new Random(System.currentTimeMillis()));
        MyAdapter myAdapter = new MyAdapter(Memes.this, images,Memes.this);
        Toast.makeText(this, "Refreshed", Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(myAdapter);

    }


}