package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ancient_building extends AppCompatActivity {

    private ImageButton zone1,zone2,zone3,zone4,zone5,zone6,zone7,back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ancient_building);

        back_btn = findViewById(R.id.back_btn);
        zone1 = findViewById(R.id.ancient_zone1_btn);
        zone2 = findViewById(R.id.ancient_zone2_btn);
        zone3 = findViewById(R.id.ancient_zone3_btn);
        zone4 = findViewById(R.id.ancient_zone4_btn);
        zone5 = findViewById(R.id.ancient_zone5_btn);
        zone6 = findViewById(R.id.ancient_zone6_btn);
        zone7 = findViewById(R.id.ancient_zone7_btn);

        zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,map_info.class);
                intent.putExtra("zone_name","โซน ปลูก ดำ หว่าน ไถ");
                intent.putExtra("zone_des","จัดแสดงในส่วนของการทำนาในสมัยโบราณ มีอุปกรณ์ต่างๆที่ใช้คือคันไถคราดและอีทุบโดยคันไถจะใช้ในขั้นตอนแรกเพื่อขุดดินจากดินเรียบๆคราดใช้ปรับหน้าดินให้เท่ากันเพื่อพร้อมที่จะปลูกข้าวอีทุบใช้ทำให้ดินก้อนใหญ่ๆกลายเป็นดินก้อนเล็กๆ");
                intent.putExtra("ar_check", "withAR");
                intent.putExtra("zoneNo", "zone1");
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,finish.class);
                startActivity(intent);
            }
        });
    }
}