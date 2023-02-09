package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class map_info extends AppCompatActivity {

    TextView zone_txt,zone_txt_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_info);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String zone_detail = extras.getString("zone_des");
        String zone_name = extras.getString("zone_name");
        String check_AR = extras.getString("ar_check");
        String zone_No = extras.getString("zoneNo");
        String building = extras.getString("building");

        zone_txt = findViewById(R.id.zone_name);
        zone_txt_des = findViewById(R.id.zone_des);

        zone_txt.setText(zone_name);
        zone_txt_des.setText(zone_detail);


        FloatingActionButton floatingActionButton = findViewById(R.id.qr_code);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(map_info.this,QRCodeScanner.class);
                intent.putExtra("checkAR", check_AR);
                intent.putExtra("building", building);
                startActivity(intent);

            }
        });
    }
}