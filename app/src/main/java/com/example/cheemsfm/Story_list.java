package com.example.cheemsfm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class Story_list extends AppCompatActivity {
    RecyclerView recyclerView;
    //private CustomAdapter.RecyclerViewClickListener listener;
    String [] arr = {"Dogesh ka Breakup ! ", "Dogesh ke ghar chori !",
            "Vimdhayak ji Ki Beti aur Shaadi ka rishta", "Dogesh vs Lion | Dogesh ka Breakup ! ", "Dogesh Ke Pakode",
            "Chalaak dogesh", "ogesh ko lagi gali dene ki lat", "Dogesh vs Pari ", "Dogesh kaa kutta", "Jadui Baba aur Dogesh", "Shakht launda dogesh ", "Dogesh ka Breakup ! ", "Dogesh ke ghar chori !",
            "Vimdhayak ji Ki Beti aur Shaadi ka rishta", "Dogesh vs Lion | Dogesh ka Breakup ! ", "Dogesh Ke Pakode",
            "Chalaak dogesh", "Dogesh ko lagi gali dene ki lat", "Dogesh vs Pari ", "Dogesh kaa kutta", "Jadui Baba aur Dogesh", "Shakht launda dogesh "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_above18);
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        CustomAdapter ad = new CustomAdapter(arr);
        recyclerView.setAdapter(ad);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

    }

}