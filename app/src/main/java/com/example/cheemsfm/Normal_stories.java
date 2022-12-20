package com.example.cheemsfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Normal_stories extends AppCompatActivity {
    private MediaPlayer mPlayer;
    ListView listView;
    String arr[] = {"Dogesh,Dogelina aur Jinn! ", "Dogesh ke ghar chori !",
            "Vimdhayak ji Ki Beti aur Shaadi ka rishta", "Dogesh vs Lion | Dogesh ka Breakup ! ", "Dogesh Ke Pakode",
            "Chalaak dogesh", "ogesh ko lagi gali dene ki lat", "Dogesh vs Pari ", "Dogesh kaa kutta", "Jadui Baba aur Dogesh", "Shakht launda dogesh ", "Dogesh ka Breakup ! ", "Dogesh ke ghar chori !",
            "Vimdhayak ji Ki Beti aur Shaadi ka rishta", "Dogesh vs Lion | Dogesh ka Breakup ! ", "Dogesh Ke Pakode",
            "Chalaak dogesh", "Dogesh ko lagi gali dene ki lat", "Dogesh vs Pari ", "Dogesh kaa kutta", "Jadui Baba aur Dogesh", "Shakht launda dogesh "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_stories);
        listView = findViewById(R.id.listview);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Normal_stories.this, "Playing: " + i, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),player.class);
                intent.putExtra("name",arr[i]);
                startActivity(intent);
            }
        });
    }
}