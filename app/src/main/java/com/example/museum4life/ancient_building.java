package com.example.museum4life;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
                intent.putExtra("building", "ancient");
                intent.putExtra("image", R.drawable.ancient_zone1_cover);
                startActivity(intent);
            }
        });

        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,map_info.class);
                intent.putExtra("zone_name","เก็บ เกี่ยว คัด แยก");
                intent.putExtra("zone_des","หลังจากปลูกข้าวแล้ว เมื่อข้าวออกรวงชาวนาจะทำการเก็บเกี่ยวข้าว โดยใช้เคียวในการเกี่ยว แล้วทำการแยกเมล็ดข้าวออกจากต้นข้าว โดยการใช้ไม้ขัดข้าวและนำไปฟาดกับไม้ เพื่อให้เมล็ดข้าวหล่นจากต้นข้าว  จากนั้นจะนำข้าวไปทำการแยกระหว่างเมล็ดที่มีข้าวกับเปลือกออกจากกัน โดยการใช้กระด้งในการฟัด เพื่อให้เปลือกโดนลมพัดไป จากนั้นจะนำข้าวเปลือกไปแยกเป็นข้าวสาร โดยการตำข้าวด้วยครกกระเดื่องซึ่งใช้หลักการโมเมนตั้มในปัจจุบันที่จะทำให้จุดหมุนใกล้ฝั่งที่คนเหยียบ เพื่อที่จะทำให้อีกฝั่งได้แรงในการตำมากขึ้นและออกแรงเหยียบน้อย");
                intent.putExtra("building", "ancient");
                intent.putExtra("image", R.drawable.ancient_zone2_cover);
                startActivity(intent);
            }
        });

        zone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,map_info.class);
                intent.putExtra("zone_name","หุง หา อาหาร");
                intent.putExtra("zone_des","จะเป็นการจำลองครัวไฟ (ห้องครัว) ของคนสมัยก่อน และอุปกรณ์ต่างๆในการทำมาหากิน เช่น ซุ่ม ยอ ในการหาปลา");
                intent.putExtra("building", "ancient");
                intent.putExtra("image", R.drawable.ancient_zone3_cover);
                startActivity(intent);
            }
        });

        zone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,map_info.class);
                intent.putExtra("zone_name","ปั่น ย้อม ทัก ถอ");
                intent.putExtra("zone_des","จำลองอุปกรณ์ต่างๆ ในการทำเครื่องนุ่งห่ม เช่น ที่ปั่นฝ้าย กี่ทอผ้า อิ้วอีดฝ้าย อิ้วอีดฝ้ายใช้ในการบีบเมล็ดฝ้ายให้แตกเพื่อคัดแยกเปลือกและเมล็ดออกจากปุยฝ้าย โดยมีเกลียวของแกนอิ้วอีดฝ้ายที่มีลักษณะเป็นเกลียวแบบวนเฉียง จะทำให้กำลังบิดต่อเนื่องและเบาแรง");
                intent.putExtra("building", "ancient");
                intent.putExtra("image", R.drawable.ancient_zone4_cover);
                startActivity(intent);
            }
        });

        zone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,map_info.class);
                intent.putExtra("zone_name","อุปกรณ์โลหะ");
                intent.putExtra("zone_des","เป็นโซนที่รวบรวมอุปกรณ์โลหะ เช่น ตาชั่ง สว่านไม้ จอบ เคียวแบบต่างๆ อาวุธ เช่น หอก ธนู ปืน ที่คนสมัยก่อนใช้ในการล่าสัตว์หรือเป็นการป้องกันตัว ของใช้ต่างๆ เช่น เตารีด ที่ใช้หลักการถ่ายเทความร้อน โดยถ่ายเทจากถ่านสู่เหล็กและจานเหล็กสู่ผ้าที่รีด");
                intent.putExtra("building", "ancient");
                intent.putExtra("image", R.drawable.ancient_zone5_cover);
                startActivity(intent);
            }
        });

        zone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,map_info.class);
                intent.putExtra("zone_name","ทำมาค้าขาย");
                intent.putExtra("zone_des","การจำลองร้านค้าในสมัยก่อน จะมีอุปกรณ์ต่างๆ เช่น แม่พิมพ์ทำขนมกรวยตวงน้ำมัน เครื่องอิเล็กทรอนิกส์ เช่น ทีวีตู้ วิทยุทรานซิเตอร์ เครื่องเล่นแผ่นเสียง จักรยานสามล้อถีบ");
                intent.putExtra("building", "ancient");
                intent.putExtra("image", R.drawable.ancient_zone6_cover);
                startActivity(intent);
            }
        });

        zone7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ancient_building.this,map_info.class);
                intent.putExtra("zone_name","การคมนาคม");
                intent.putExtra("zone_des","ยุคสมัยก่อนการคมนาคม มี 3 ทางหลักๆ คือ ทางบก ทางน้ำ ทางอากาศ คมนาคมทางบกจะให้เกวียนเป็นพาหนะในการเดินทาง ซึ่งเกวียนในสมัยก่อนจะมี 2 แบบ คือ เกวียนใหญ่และเกวียนเล็ก คมนาคมทางน้ำ เรือ มี 2 แบบ คือ เรือขุดและเรือต่อ คมนาคมทางอากาศ เป็นการจำลอง บั้งไฟ โดยบั้งไฟจะใช้หลักการแรงผลักของดินปืนในบั้งไฟ ทำให้บั้งไฟพุ่งขึ้นสู่ท้องฟ้า ซึ่งในปัจจุบันนักวิทยาศาสตร์ได้นำหลักการนี้มาประยุกต์ใช้กับจรวดหรือยานอวกาศต่างๆ  ");
                intent.putExtra("building", "ancient");
                intent.putExtra("image", R.drawable.ancient_zone7_cover);
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ancient_building.this);
                builder.setTitle("คุณแน่ใจใช่ไหม");
                builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ancient_building.this,finish.class);
                        intent.putExtra("building", "ancient");
                        startActivity(intent);
                        finish();
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
    }
}