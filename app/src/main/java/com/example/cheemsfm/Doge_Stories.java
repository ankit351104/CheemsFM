package com.example.cheemsfm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Doge_Stories extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doge_stories);
    }

    public void openActivity3(View view3) {
        Toast.makeText(this, "Opening Normal Doge Stories", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Normal_stories.class);
        startActivity(intent);
    }

    public void openActivity4(View view4) {
        Toast.makeText(this, "Opening List of stories", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Story_list.class);
        startActivity(intent);
    }
}