package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class plant_building extends AppCompatActivity {

    private ImageButton map_btn,back_btn,zone2,zone3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_building);

        map_btn = findViewById(R.id.zone1_btn);
        back_btn = findViewById(R.id.back_btn);
        zone2 = findViewById(R.id.zone2_btn);
        zone3 = findViewById(R.id.zone3_btn);


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plant_building.this,finish.class);
                intent.putExtra("building", "plant");
                startActivity(intent);
            }
        });

        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(plant_building.this,map_info.class);
                intent.putExtra("zone_name","โซนต้นไม้ประจำราชการ");
                intent.putExtra("zone_des"," ต้นราชพฤกษ์/ต้นคูน เป็นต้นไม้มงคลนิยมใช้ประกอบพิธีที่สำคัญ เช่น พิธีเสาไม้หลักเมือง เป็นส่วนประกอบในการท าคฑาจอมพล และ ยอดธงชัยเฉลิมพลของกองทหาร ทำพิธีปลูกบ้าน ฯลฯ ต้นราชพฤกษ์นอกจากจะเป็นไม้ประจำรัชกาลที่ 9 แล้วยังเป็นต้นไม้ประจำจังหวัดขอนแก่นอีกด้วย");
                intent.putExtra("building", "plant");
                intent.putExtra("image", R.drawable.plant_zone1_cover);
                startActivity(intent);
            }
        });

        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plant_building.this,map_info.class);
                intent.putExtra("zone_name","โซนโรงเรือนประเภทของพืช");
                intent.putExtra("zone_des","ภายในโรงเรือนได้จัดนิทรรศกาลเกี่ยวกับพันธุ์ไม้ในป่าเต็งรัง,นิทรรศการเกี่ยวกับต้นกระบองเพชรและนิทรรศการอาณาจักรพืช");
                intent.putExtra("building", "plant");
                intent.putExtra("image", R.drawable.plant_zone2_cover);
                startActivity(intent);
            }
        });

        zone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plant_building.this,map_info.class);
                intent.putExtra("zone_name","โซนสมุนไพรไทย");
                intent.putExtra("zone_des","สมุนไพร หมายถึง พืชที่ใช้ท าเป็นเครื่องยา สมุนไพรกำเนิดมาจากธรรมชาติและมีความหมายต่อชีวิตมนุษย์โดยเฉพาะในทางสุขภาพ พืชสมุนไพรนับตั้งแต่โบราณก็ทราบกันดีว่ามีคุณค่าทางยามากมาย ซึ่งเชื่อกันว่าต้นพืชต่างๆ เป็นพืชที่มีสารที่เป็นตัวยาด้วยกันทั้งสิ้นเพียงแต่ว่าพืชชนิดไหนจะมีคุณค่าทางยามากน้อยกว่ากันเท่านั้น");
                intent.putExtra("building", "plant");
                intent.putExtra("image", R.drawable.plant_zone3_cover);
                startActivity(intent);
            }
        });

    }
}