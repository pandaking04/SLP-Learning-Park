package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class art_building extends AppCompatActivity {

    private ImageButton zone1_btn,zone2,zone3,zone4,zone5,zone6,zone7,zone8,back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_building);

        zone1_btn = findViewById(R.id.art_zone1);
        zone2 = findViewById(R.id.art_zone2);
        zone3 = findViewById(R.id.art_zone3);
        zone4 = findViewById(R.id.art_zone4);
        zone5 = findViewById(R.id.art_zone5);
        zone6 = findViewById(R.id.art_zone6);
        zone7 = findViewById(R.id.art_zone7);
        zone8 = findViewById(R.id.art_zone8);
        back_btn = findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,finish.class);
                intent.putExtra("building", "art");
                startActivity(intent);
            }
        });

        zone1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","หม่องนี่อีสาน(ที่นี่อีสาน)");
                intent.putExtra("zone_des","หม่องนี่อีสาน จัดแสดงลักษณะภูมิประเทศของภาคอีสาน อารยธรรมขอมโบราณ แหล่งวัฒนธรรมเก่าแก่ ปราสาทหิน เครื่องประดับและเครื่องปั้นดินเผาที่ปรากฎและถูกค้นพบภายในแผ่นอีสาน อีกทั้งยังมีการจัดแสดงแผนผังชาติพันธุ์ของชาวอีสานว่าแต่ละจังหวัดในภาคอีสานนั้นมีชาติพันธุ์ดั้งเดิม");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone1_cover);
                startActivity(intent);
            }
        });

        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","เฮ็ดกินเฮ็ดส่าง(ทำมาหากิน)");
                intent.putExtra("zone_des","โซนเฮ็ดกินเฮ็ดส่าง จะจัดแสดงอุปกรณ์เครื่องมือ เครื่องใช้ที่ชาวอีสานใช้สำหรับทำมาหากินและดำรงชีวิตประจำวัน เช่น งานทอเสื่อ ทอผ้า งานเครื่องจักรสาน เครื่องปั้นดินเผา เครื่องมือเกษตรกรรม เครื่องมือดักสัตว์ เครื่องมือจับสัตว์น้ำ ระหัดวิดน้ำ เป็นต้น");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone2_cover);
                startActivity(intent);
            }
        });


        zone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","ส่างบ้านแปงเฮือน(ปลูกบ้านสร้างเฮือน)");
                intent.putExtra("zone_des","จัดแสดงให้ความรู้เกี่ยวเอกลักษณ์เฉพาะของเฮือนอีสาน และประเภทของเฮือนอีสานที่สร้างเพื่อใช้สอยตามวัตถุประสงค์ที่แตกต่างกันออกไป รวมไปถึงเสวียน หรือยุ้งข้าวอีสาน");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone3_cover);
                startActivity(intent);
            }
        });

        zone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","ห้องนิทรรศการพระยากำธรพายัพทิศ");
                intent.putExtra("zone_des","พระยากำธรพายัพทิศท่านมีศักดิ์เป็นหลานชาย พระยาสุริยเดชต้นตระกูลพระยากำธรพายัพทิศ สืบเชื้อสายมาจากพระเจ้าตากสินมหาราช โดยท่านเป็นบุตรชายคนที่ 3 ของท่าน ทองดี อินทโสฬส และท่านนกเอี้ยง ภายในห้องนิทรรศการพระยากำธรพายัพทิศ จะจัดแสดงสิ่งของ เครื่องใช้ส่วนตัว เอกสารต่างๆ รวมทั้งประวัติ และผลงานของท่านระหว่างการเข้ารับราชการเป็นข้าหลวงประจำนคราชสีมา โดยเฉพาะอย่างยิ่ง การร่วมกับพันเอกพระเริงรุกปัจจามิตร (ทอง รักสงบ) และชาวเมืองนคราชสีมาในการสร้างอนุสาวรีย์ท้าวสุรนารี ตั้งอยู่ที่ประชุมพลดังที่เราได้เห็นในปัจจุบัน");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone4_cover);
                startActivity(intent);
            }
        });

        zone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","นุ่งซิ่นไหมห่มผ้าฝ้าย(นุ่งฝ้ายห่มไหม)");
                intent.putExtra("zone_des","จัดแสดงวัฒนธรรมการทอผ้าของชาวอีสานไม่ว่าจะเป็นอุปกรณ์เครื่องมือสำหรับการทอผ้าฝ้ายและผ้าไหม อีกทั้งยังมีการจัดแสดงย่ามไทยและลายผ้าของชาติพันธุ์ในภาคอีสานในพื้นที่ใกล้เคียง");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone5_cover);
                startActivity(intent);
            }
        });

        zone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","สังคมวัฒนธรรมอาเชียน");
                intent.putExtra("zone_des","จัดแสดงข้อมูลให้ความรู้เกี่ยวกับสังคมวัฒนธรรมของคนในประเทศสมาชิกอาเซียน โดยจะมีตัวอย่างวัฒนธรรมการแต่งกายและอาหารจากแต่ละประเทศมาให้ผู้เข้ามาเยี่ยมชมได้ศึกษาและทำความเข้าใจสมาชิกอาเซียนประเทศอื่นๆ ด้วย");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone6_cover);
                startActivity(intent);
            }
        });

        zone7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","ม่วนซื่นโฮวแซว(บันเทิงเริงเล่น)");
                intent.putExtra("zone_des","ทราบประวัติความเป็นมาของเครื่องดนตรีพื้นบ้านที่เป็นเอกลักษณ์ของชาวอีสาน นั่นก็คือ แคน นั่นเอง");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone7_cover);
                startActivity(intent);
            }
        });

        zone8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(art_building.this,map_info.class);
                intent.putExtra("zone_name","ง่านบุญหว่ายผี(ทำบุญไหว้ผี)");
                intent.putExtra("zone_des","จัดแสดงประเพณีและความเชื่อของชาวอีสานที่ได้รับสืบทอดต่อจากบรรพบุรุษ ที่สะท้อนถึงความศรัทธาต่อพระพุทธศาสนาและความเชื่อเรื่องผีหรือสิ่งที่เหนือธรรมชาติ จนก่อให้เกิดงานบุญประเพณีของชาวอีสานขึ้นอย่าง ฮีตสิบสอง ที่หมายถึงประเพณี 12 เดือน ที่เกี่ยวกับหลักพระพุทธศาสนา ความเชื่อ และการดำรงชีวิตทางการเกษตรของชาวอีสานตั้งแต่อดีตจนถึงปัจจุบัน");
                intent.putExtra("building", "art");
                intent.putExtra("image", R.drawable.art_zone8_cover);
                startActivity(intent);
            }
        });

    }
}