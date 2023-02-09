package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SLP_Template extends AppCompatActivity {

    ImageButton backBtn;
    ImageView previewImg;
    TextView textView,mapLabel;
    Button reviewBtn, startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slp_template);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String map_detail = extras.getString("detail");
        String map_name = extras.getString("name");

        backBtn = findViewById(R.id.back_btn);
        previewImg = findViewById(R.id.image_preview);
        textView = findViewById(R.id.detail_preview);
        reviewBtn = findViewById(R.id.review_btn);
        startBtn = findViewById(R.id.start_btn);
        mapLabel = findViewById(R.id.map_label);
        previewImg = findViewById(R.id.image_preview);
        int image_link = getIntent().getIntExtra("image", 0);

        previewImg.setImageResource(image_link);
        textView.setText(map_detail);
        mapLabel.setText(map_name);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(SLP_Template.this, activity_map.class));
            }
        });

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SLP_Template.this, Review.class));
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("zone",map_name);
                if(map_name.equals("พิพิธภัณฑ์ไทยโบราณ")){
                    startActivity(new Intent(SLP_Template.this, ancient_building.class));
                }else if(map_name.equals("สวนพฤกษศาสตร์")){
                    startActivity(new Intent(SLP_Template.this, plant_building.class));
                }else if(map_name.equals("ไทยศึกษานิทัศน์")){
                    startActivity(new Intent(SLP_Template.this, art_building.class));
                }
                else if(map_name.equals("อุทยานผีเสื้อ")){
                    startActivity(new Intent(SLP_Template.this, butterfly_building.class));
                }

            }
        });


    }
}