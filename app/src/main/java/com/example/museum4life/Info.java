package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

public class Info extends AppCompatActivity {

    StorageReference storageReference;
    FirebaseFirestore fStore;
    ImageButton back_btn,audio_btn;
    TextView things_name,things_description;
    String audio_sauce;
    String img_sauce = "test";


    ImageView things_img;
    private boolean mediaPlaying;
    private MediaPlayer mPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String thingName = extras.getString("name");

        fStore = FirebaseFirestore.getInstance();


        back_btn = findViewById(R.id.back_btn);
        things_name = findViewById(R.id.things_name);
        things_description = findViewById(R.id.things_des);
        audio_btn = findViewById(R.id.audio_btn);
        things_img = findViewById(R.id.things_img);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Info.this,activity_map.class);
                startActivity((intent));
                finish();
            }
        });

        DocumentReference documentReference = fStore.collection("museum").document("plant").collection("Things")
                .document("Map").collection("Zone1").document(thingName);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                things_name.setText(value.getString("name"));
                things_description.setText(value.getString("description"));
                audio_sauce = value.getString("sound");
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
            }
        });





        audio_btn.setOnClickListener(new View.OnClickListener() {
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
        });



    }
}