package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class butterfly_building extends AppCompatActivity {

    private ImageButton butterfly_zone4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butteyfly_building);

        butterfly_zone4 = findViewById(R.id.butterfly_zone4);

        butterfly_zone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","สวนผีเสื้อ");
                intent.putExtra("zone_des","สวนผีเสื้อ มีผีเสื้อตลอดทั้งปี ส่วนใหญ่จะเป็นผีเสื้อตามช่วงฤดู เช่น ผีเสื้อกะทกรก ผีเสื้อปีกไข่ใหญ่ ผีเสื้อหางติ่งธรรมดา ผีเสื้อหนอนมะนาว ในช่วงหน้าร้อน มีผีเสื้อหนอนคูนธรรมดา ช่วงปลายฝนต้นหนาว มีผีเสื้อถุงทองธรรมดา อาหารของผีเสื้อ คือ น้้ำหวานจากเกสรดอกไม้ อาหารอีกชนิดที่ผีเสื้อชื่นชอบคือ เกลือแร่ ซึ่งเกลือแร่ที่ได้จากธรรมาชาติ คือ ปัสสาวะของสัตว์ เหงื่อของมนุษย์");
                intent.putExtra("building", "butterfly");
                startActivity(intent);
            }
        });
    }
}