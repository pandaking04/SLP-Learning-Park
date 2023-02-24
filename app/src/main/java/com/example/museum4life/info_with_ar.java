package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class info_with_ar extends AppCompatActivity {

    StorageReference storageReference;
    FirebaseFirestore fStore;
    ImageButton back_btn,audio_btn;
    TextView things_name,things_description;
    String audio_sauce;
    Button showAR;
    String img_sauce = "test";
    TextToSpeech t1;
    int isSpeak = 0;


    ImageView things_img;
    private boolean mediaPlaying;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_with_ar);

        //extras
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String zone_detail = extras.getString("zone_des");
        String zone_name = extras.getString("zone_name");
        int image_link = getIntent().getIntExtra("image", 0);
        String thingName = extras.getString("name");
        String building = extras.getString("building");
        //

        fStore = FirebaseFirestore.getInstance();


        back_btn = findViewById(R.id.back_btn);
        showAR = findViewById(R.id.showAR);
        things_name = findViewById(R.id.things_name);
        things_description = findViewById(R.id.things_des);
        audio_btn = findViewById(R.id.audio_btn);
        things_img = findViewById(R.id.things_img);

        t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                    t1.setLanguage(Locale.forLanguageTag("th_TH"));
                    t1.setSpeechRate(0.7f);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info_with_ar.this,map_info.class);
                intent.putExtra("zone_name", zone_name);
                intent.putExtra("zone_des", zone_detail);
                intent.putExtra("image", image_link);
                intent.putExtra("building", building);
                startActivity((intent));
                finish();
            }
        });

        DocumentReference documentReference = fStore.collection("museum").document(building).collection("Things")
                .document(thingName);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                things_name.setText(value.getString("name"));
                things_description.setText(value.getString("description"));
                //audio_sauce = value.getString("sound");
                img_sauce = value.getString("name");
                storageReference = FirebaseStorage.getInstance().getReference().child("Image/"+img_sauce+".jpg");



                try {
                    File localFile = File.createTempFile("temp","jpg");
                    storageReference.getFile(localFile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                    things_img.setImageBitmap(bitmap);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

                showAR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(building.equals("ancient")){
                            Intent intent = new Intent(info_with_ar.this,model_ar.class);
                            intent.putExtra("model", value.getString("name"));
                            startActivity(intent);
                            finish();
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(info_with_ar.this);
                            builder.setTitle("ขออภัย");
                            builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });


                            builder.setMessage("พื้นที่จัดแสดงนี้ี้ยังไม่มีบริการ AR");
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }

                    }
                });

                audio_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("sound", value.getString("description"));
                        t1.speak(value.getString("description"), TextToSpeech.QUEUE_FLUSH, null);


                    }
                });
            }
        });





       /* audio_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlaying){
                    mediaPlaying = false;
                    mPlayer.pause();

                }

                else{
                    mediaPlaying = true;
                    if(mPlayer == null){
                        mPlayer = new MediaPlayer();
                        try {
                            mPlayer.setDataSource(audio_sauce);
                            mPlayer.prepare();
                            mPlayer.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });*/

    }
}