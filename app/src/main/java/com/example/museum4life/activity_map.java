package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class activity_map extends AppCompatActivity {
    ImageButton ancient_btn,art_btn,plant_btn,butter_btn;
    String ancient_detail = "";
    String ancient_name = "";
    String art_detail,art_name,plant_detail,plant_name,butter_detail,butter_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

       ancient_btn = (ImageButton) findViewById(R.id.ancient_btn);
       art_btn = findViewById(R.id.art_btn);
       plant_btn = findViewById(R.id.plant_btn);
       butter_btn = findViewById(R.id.butterfly_btn);

       ancient_detail = "ิพิธภัณฑ์เทคโนโลยีไทยโบราณ สร้างขึ้นในปี พ.ศ. 2547 เพื่อเป็นที่เก็บหลักฐานแห่งความทรงจำไว้ให้คนไทยได้ภาคภูมิใจในความสามารถของนักวิทยาศาสตร์และวิศวกรไทยโบราณ โดยมีวัตถุประสงค์สร้างความตระหนักในคุณค่าของประวัติศาสตร์ วิทยาศาสตร์และเทคโนโลยีของบรรพชนไทยให้กับนักเรียน นักศึกษา และประชาชนที่สนใจ ให้ได้ศึกษาหาความรู้ ก่อเกิดแรงบันดาลใจในการคิดค้นและนำไปต่อยอดความรู้ในอดีต";
       ancient_name = "พิพิธภัณฑ์ไทยโบราณ";
       art_detail = "ห้องไทยศึกษานิทัศน์และวัฒนธรรมอาเซียนสร้างขึ้นในปี พ.ศ. 2536 โดยเก็บรวบรวมและจัดแสดงวัสดุทางวัฒนธรรมของอีสาน ที่ชาวบ้านยังคงผลิตและใช้ประโยชน์ในชีวิตประจำวัน วัสดุทางวัฒนธรรมที่รวบรวมไว้มีจำนวนมากกว่า 2,000 ชิ้น ภายในอาคารจัดแสดงความรู้เกี่ยวกับภูมิปัญญาพื้นบ้านอีสานและวัฒนธรรมอาเซียน";
       art_name = "ไทยศึกษานิทัศน์";
       plant_detail = "สวนพฤกษศาสตร์ มทส. สร้างขึ้นปี พ.ศ. 2553 เพื่อเป็นแหล่งเรียนรู้ด้านพฤกษศาสตร์ สนับสนุนโครงการอนุรักษ์พันธุกรรมพืชอันเนื่องมาจากพระราชดำริฯ และปลูกจิตสำนึก รักหวนแหนตระหนักถึงคุณค่าของพรรณไม้ ในท้องถิ่น นำไปสู่การอนุรักษ์และใช้ประโยชน์อย่างยั่งยืน";
       plant_name = "สวนพฤกษศาสตร์";
       butter_detail = "อุทยานผีเสื้อเฉลิมพระเกียรติ สร้างขึ้นในปี พ.ศ. 2538 เพื่อเฉลิมฉลองในวโรกาสที่พระบาทสมเด็จพระเจ้าอยู่หัวทรงครองสิริราชสมบัติเป็นปีที่ 50 ซึ่งส่วนหนึ่งในงานเกษตรและอุตสาหกรรมโลก โดยมีวัตถุประสงค์สร้างค่านิยมและปลูกจิตสำนึกการอนุรักษ์สิ่งแวดล้อม โดยใช้ผีเสื้อและแมลงเป็นสื่อหรือตัวแทนความสัมพันธ์การมีชีวิตของสัตว์ และพืช";
       butter_name = "อุทยานผีเสื้อ";

        ancient_btn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_map.this, SLP_Template.class);
                intent.putExtra("detail", ancient_detail);
                intent.putExtra("name", ancient_name);
                intent.putExtra("image", R.drawable.ancient_cover);
                startActivity(intent);
            }
        });

        art_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_map.this, SLP_Template.class);
                intent.putExtra("detail", art_detail);
                intent.putExtra("name", art_name);
                intent.putExtra("image", R.drawable.art_cover);
                startActivity(intent);
            }
        });

        plant_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_map.this, SLP_Template.class);
                intent.putExtra("detail", plant_detail);
                intent.putExtra("name", plant_name);
                intent.putExtra("image", R.drawable.plant_cover);
                startActivity(intent);
            }
        });

        butter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_map.this, SLP_Template.class);
                intent.putExtra("detail", butter_detail);
                intent.putExtra("name", butter_name);
                intent.putExtra("image", R.drawable.butterfly_cover);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.map);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.map:

                        return true;

                    case  R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return  true;
                }
                return false;
            }
        });
    }
}