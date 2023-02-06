package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Review extends AppCompatActivity {
    RecyclerView recyclerView;
    Review_Adapter adapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        items = new ArrayList<>();
        items.add("First_User");
        items.add("First_User");
        items.add("First_User");
        items.add("First_User");

        recyclerView = findViewById(R.id.recycleView);
    }
}