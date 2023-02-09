package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class plant_building extends AppCompatActivity {

    private ImageButton map_btn,back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_building);

        map_btn = findViewById(R.id.zone_btn);
        back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plant_building.this,SLP_Template.class);
                startActivity(intent);
            }
        });

        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(plant_building.this,map_info.class);
                intent.putExtra("zone_name","โซนต้นไม้ประจำราชการ");
                intent.putExtra("zone_des"," ต้นราชพฤกษ์/ต้นคูน เป็นต้นไม้มงคลนิยมใช้ประกอบพิธีที่สำคัญ เช่น พิธีเสาไม้หลักเมือง เป็นส่วนประกอบในการท าคฑาจอมพล และ ยอดธงชัยเฉลิมพลของกองทหาร ทำพิธีปลูกบ้าน ฯลฯ ต้นราชพฤกษ์นอกจากจะเป็นไม้ประจำรัชกาลที่ 9 แล้วยังเป็นต้นไม้ประจำจังหวัดขอนแก่นอีกด้วย");
                intent.putExtra("ar_Check", "noAR");
                intent.putExtra("building", "plant");
                startActivity(intent);

            }
        });

    }
}