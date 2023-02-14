package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class finish extends AppCompatActivity {

    Button comment_btn,home_btn,retry_btn;
    private String myComment;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fireStore;
    private String uid, usernameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String building = extras.getString("building");

        comment_btn = findViewById(R.id.comment_btn);
        home_btn = findViewById(R.id.home_btn);
        retry_btn = findViewById(R.id.again_btn);
        mAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();

        fireStore.collection("Users").document(uid).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String username = documentSnapshot.getString("username");

                usernameTxt = username;
            }
        });

        retry_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(building.equals("ancient")){
                    Intent intent = new Intent(finish.this,ancient_building.class);
                    startActivity(intent);
                    finish();
                }
                if(building.equals("art")){
                    Intent intent = new Intent(finish.this,art_building.class);
                    startActivity(intent);
                    finish();
                }
                if(building.equals("plant")){
                    Intent intent = new Intent(finish.this,plant_building.class);
                    startActivity(intent);
                    finish();
                }
                if(building.equals("butterfly")){
                    Intent intent = new Intent(finish.this,butterfly_building.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(finish.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(finish.this);
                myDialog.setTitle("Please leave a comment");

                final EditText commentInput = new EditText(finish.this);
                commentInput.setInputType(InputType.TYPE_CLASS_TEXT);
                myDialog.setView(commentInput);

                myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myComment = commentInput.getText().toString();
                        Map<String, Object> comment = new HashMap<>();
                        comment.put("text", myComment);
                        comment.put("username", usernameTxt);

                       DocumentReference db = fireStore.collection("museum").document(building)
                               .collection("Comment")
                                .document();
                       db.set(comment).addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void unused) {
                               Log.d("comment","DocumentSnapshot written with ID: " + db.getId());
                               Toast.makeText(finish.this, "Comment Added", Toast.LENGTH_LONG).show();
                           }
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Log.w("comment", "Error adding document", e);
                           }
                       });

                    }
                });

                myDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                myDialog.show();
            }
        });
    }
}