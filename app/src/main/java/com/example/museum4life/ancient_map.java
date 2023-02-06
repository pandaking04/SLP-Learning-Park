package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ancient_map extends AppCompatActivity {
    private ImageButton back_btn,zone1_btn,zone6_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ancient_map);

        back_btn = findViewById(R.id.arrow_back);
        zone1_btn = findViewById(R.id.zone1_btn);
        zone6_btn = findViewById(R.id.btn_zone6);

        zone1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ancient_map.this,ancient_zone_1.class));
            }
        });

        zone6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ancient_map.this,ancient_zone_6.class));
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ancient_map.this, Ancient.class));
            }
        });
    }
}