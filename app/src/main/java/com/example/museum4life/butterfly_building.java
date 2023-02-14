package com.example.museum4life;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class butterfly_building extends AppCompatActivity {

    private ImageButton zone1,zone2,zone3,butterfly_zone4,zone5,zone6,zone7,back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butteyfly_building);

        zone1 = findViewById(R.id.butterfly_zone1);
        zone2 = findViewById(R.id.butterfly_zone2);
        zone3 = findViewById(R.id.butterfly_zone3);
        zone5 = findViewById(R.id.butterfly_zone5);
        zone6 = findViewById(R.id.butterfly_zone6);
        zone7 = findViewById(R.id.butterfly_zone7);
        back_btn = findViewById(R.id.back_btn);

        butterfly_zone4 = findViewById(R.id.butterfly_zone4);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(butterfly_building.this);
                builder.setTitle("คุณแน่ใจใช่ไหม");
                builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(butterfly_building.this,finish.class);
                        intent.putExtra("building", "butterfly");
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setMessage("คุณต้องการสิ้นสุดการเยี่ยมชมใช่หรือไม่?");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","ห้องวิดีทัศน์");
                intent.putExtra("zone_des","เป็นห้องสื่อความรู้เกี่ยวกับการกำเนิดแมลง และวงจรชีวิตผีเสื้อ แมลงกำเนิดมาแล้วเมื่อประมาณ 380 ล้านปีก่อน และผีเสื้อกลางวันกำเนิดมาแล้วเมื่อประมาณ 200 ล้านปีก่อน วงจรชีวิตผีเสื้อมีทั้งหมด 4 ระยะ คือ ไข่ หนอน ดักแด้ ตัวเต็มวัย หรือผีเสื้อ ตามลำดับ");
                intent.putExtra("building", "butterfly");
                intent.putExtra("image", R.drawable.butterfly_zone1_cover);
                startActivity(intent);
            }
        });

        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","ห้องแมลงจิ๋ว");
                intent.putExtra("zone_des","เป็นการจัดแสดงนิทรรศการแมลงขนาดเล็ก ที่มีความยาวไม่ถึง 1 เซนติเมตร จึงสามารถปรับตัวให้เข้ากับสิ่งแวดล้อมได้ดี จึงสามารถอาศัยอยู่ได้แทบทุกหนทุกแห่ง โดยเราจะส่องกล้องไมโครสโคป เพื่อให้เห็นส่วนต่างๆ ของแมลงจิ๋วได้ชัดเจนยิ่งขึ้น ดูว่าภายใต้เลนส์กล้องคือแมลงชนิดไหน และมีรูปร่างอย่างไร");
                intent.putExtra("building", "butterfly");
                intent.putExtra("image", R.drawable.butterfly_zone2_cover);
                startActivity(intent);
            }
        });

        zone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","แมลงเศรษฐกิจ");
                intent.putExtra("zone_des","นิทรรศการเกี่ยวกับแมลงเศรษฐกิจ แมลงอุตสาหกรรม แมลงกินได้หรือแมลงทางเลือก(ในส่วนแมลงกินได้มีคุณค่าทางโภชนาการด้านโปรตีนสูงมาก) โดยมีตัวอย่างแมลง 5 ชนิด");
                intent.putExtra("building", "butterfly");
                intent.putExtra("image", R.drawable.butterfly_zone3_cover);
                startActivity(intent);
            }
        });

        butterfly_zone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","สวนผีเสื้อ");
                intent.putExtra("zone_des","สวนผีเสื้อ มีผีเสื้อตลอดทั้งปี ส่วนใหญ่จะเป็นผีเสื้อตามช่วงฤดู เช่น ผีเสื้อกะทกรก ผีเสื้อปีกไข่ใหญ่ ผีเสื้อหางติ่งธรรมดา ผีเสื้อหนอนมะนาว ในช่วงหน้าร้อน มีผีเสื้อหนอนคูนธรรมดา ช่วงปลายฝนต้นหนาว มีผีเสื้อถุงทองธรรมดา อาหารของผีเสื้อ คือ น้้ำหวานจากเกสรดอกไม้ อาหารอีกชนิดที่ผีเสื้อชื่นชอบคือ เกลือแร่ ซึ่งเกลือแร่ที่ได้จากธรรมาชาติ คือ ปัสสาวะของสัตว์ เหงื่อของมนุษย์");
                intent.putExtra("building", "butterfly");
                intent.putExtra("image", R.drawable.butterfly_zone4_cover);
                startActivity(intent);
            }
        });

        zone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","พิพิธภัณฑ์แมลง");
                intent.putExtra("zone_des","เป็นโซนที่เก็บรวบรวมแมลง ผีเสื้อในประเทศ และต่างประเทศไว้เพื่อศึกษา ผีเสื้อมี 2 ประเภท คือ ผีเสื้อกลางวัน ผีเสื้อกลางคืน และแมลงต่าง ๆ ที่ใกล้จะสูญพันธุ์ โดยที่สำคัญของโซนนี้จะเป็นตู้แมลงอนุรักษ์ เนื่องจากมีผีเสื้อที่สูญพันธุ์แล้วจากประเทศไทยเมื่อประมาณปี พ.ศ. 2527");
                intent.putExtra("building", "butterfly");
                intent.putExtra("image", R.drawable.butterfly_zone5_cover);
                startActivity(intent);
            }
        });

        zone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","อุโมงค์แมลง");
                intent.putExtra("zone_des","เป็นการจำลองช่วงเวลากลางคืน แมลงที่เราจะเห็นแสงกะพริบได้ชัดเจนในช่วงกลางคืน นั้นก็คือ “หิ่งห้อย” ซึ่งการกะพริบแสงจะกะพริบตลอดเวลา และใช้เป็นภาษาสื่อสารเพื่อการหาคู่ของตัวผู้และตัวเมีย เสียงที่ได้ยิน เป็นการจำลองเสียงของแมลง เสียงของจิ้งหรีดเกิดเสียงจากการเสียดสีของปีก ส่วนจักจั่นเกิดจากการคลายตัว-หดตัวของกล้ามเนื้อส่วนท้อง เสียงของแมลงมีความหมายหลายแบบทั้งการป้องกันตัว สร้างอาณาเขต การผสมพันธุ์ และคนสมัยก่อนยังใช้เสียงของจักจั่นเป็นสัญญาณที่บ่งบอกว่านี่คือ “ฤดูร้อน”");
                intent.putExtra("building", "butterfly");
                intent.putExtra("image", R.drawable.butterfly_zone6_cover);
                startActivity(intent);
            }
        });

        zone7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(butterfly_building.this,map_info.class);
                intent.putExtra("zone_name","โมเดลแมลง");
                intent.putExtra("zone_des","โซนนี้เป็นการจำลองแมงและแมลง ที่ให้เรียนรู้รูปร่าง/โครงสร้างภายนอก และอวัยวะที่สามารถมองเห็นด้วยตาเปล่าที่ชัดเจนขึ้น โดยรูปร่างแมลง มี 3 ส่วน คือ 1.ส่วนหัว 2.ส่วนอก 3.ส่วนท้องหรือลำตัวมีหนวด และมีขา 6 ขา เช่น ตั๊กแตน มด ผีเสื้อ เป็นต้นรูปร่างของแมง มี 2 ส่วน คือ 1.ส่วนหัวกับอกรวมกัน เรียกว่าProsoma (โปรโซมา) 2.ส่วนท้อง ไม่มีหนวด และมีขา 8 หรือ 10 ขาเช่น แมงมุม แมงป่อง");
                intent.putExtra("building", "butterfly");
                intent.putExtra("image", R.drawable.butterfly_zone7_cover);
                startActivity(intent);
            }
        });
    }
}