package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class map_info extends AppCompatActivity {

    TextView zone_txt,zone_txt_des;
    ImageView img_preview;
    ImageButton back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_info);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String zone_detail = extras.getString("zone_des");
        String zone_name = extras.getString("zone_name");
        String building = extras.getString("building");
        int image_link = getIntent().getIntExtra("image", 0);

        zone_txt = findViewById(R.id.zone_name);
        zone_txt_des = findViewById(R.id.zone_des);
        img_preview = findViewById(R.id.image_preview);
        back_btn = findViewById(R.id.back_btn);

        img_preview.setImageResource(image_link);
        zone_txt.setText(zone_name);
        zone_txt_des.setText(zone_detail);


        FloatingActionButton floatingActionButton = findViewById(R.id.qr_code);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(building.equals("ancient")){
                    Intent intent = new Intent(map_info.this, ancient_building.class);
                    intent.putExtra("building", "ancient");
                    startActivity(intent);
                }
                if(building.equals("butterfly")){
                    Intent intent = new Intent(map_info.this, butterfly_building.class);
                    intent.putExtra("building", "butterfly");
                    startActivity(intent);
                }
                if(building.equals("plant")){
                    Intent intent = new Intent(map_info.this, plant_building.class);
                    intent.putExtra("building", "plant");
                    startActivity(intent);
                }
                if(building.equals("art")){
                    Intent intent = new Intent(map_info.this, art_building.class);
                    intent.putExtra("building", "art");
                    startActivity(intent);
                }
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(map_info.this,QRCodeScanner.class);
                intent.putExtra("building", building);
                intent.putExtra("zone_name", zone_name);
                intent.putExtra("zone_des", zone_detail);
                intent.putExtra("image", image_link);
                startActivity(intent);

            }
        });
    }
}