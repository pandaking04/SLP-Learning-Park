package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class art_building extends AppCompatActivity {

    private ImageButton zone1_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_building);

        zone1_btn = findViewById(R.id.art_zone1);

        zone1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","หม่องนี่อีสาน");
                intent.putExtra("zone_des","หม่องนี่อีสาน จัดแสดงลักษณะภูมิประเทศของภาคอีสาน อารยธรรมขอมโบราณ แหล่งวัฒนธรรมเก่าแก่ ปราสาทหิน เครื่องประดับและเครื่องปั้นดินเผาที่ปรากฎและถูกค้นพบภายในแผ่นอีสาน อีกทั้งยังมีการจัดแสดงแผนผังชาติพันธุ์ของชาวอีสานว่าแต่ละจังหวัดในภาคอีสานนั้นมีชาติพันธุ์ดั้งเดิม");
                intent.putExtra("building", "art");
                startActivity(intent);
            }
        });


    }
}