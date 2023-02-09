package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
                Intent intent = new Intent(info_with_ar.this,activity_map.class);
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
                        Intent intent = new Intent(info_with_ar.this,model_ar.class);
                        intent.putExtra("model", value.getString("name"));
                        startActivity(intent);
                    }
                });

                audio_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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