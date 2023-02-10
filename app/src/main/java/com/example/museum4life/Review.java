package com.example.museum4life;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Review extends AppCompatActivity {
    RecyclerView recyclerView;
    Review_Adapter adapter;
    ArrayList<Comment> commentArrayList;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    TextView review_label;
    ImageButton back_btn;
    ImageView previewImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String building = extras.getString("building");
        String building_name = extras.getString("name");
        String map_detail = extras.getString("detail");
        int image_link = getIntent().getIntExtra("image", 0);

       /* progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data..");
        progressDialog.show(); */


        back_btn = findViewById(R.id.back_btn);
        previewImg = findViewById(R.id.image_preview);

        previewImg.setImageResource(image_link);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Review.this, SLP_Template.class);
                intent.putExtra("name", building_name);
                intent.putExtra("detail", map_detail);
                intent.putExtra("image", image_link);
                intent.putExtra("building", building);
                startActivity(intent);

            }
        });

        review_label = findViewById(R.id.review_txt);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        commentArrayList = new ArrayList<Comment>();
        adapter = new Review_Adapter(Review.this,commentArrayList);

        recyclerView.setAdapter(adapter);

        review_label.setText(building_name);

        EventChangeListener(building);
    }

    private void EventChangeListener(String building) {
        db.collection("museum").document(building).collection("Comment")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error != null){
                           /* if(progressDialog.isShowing())
                                progressDialog.dismiss(); */
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()){
                            if(dc.getType() == DocumentChange.Type.ADDED){
                                    commentArrayList.add(dc.getDocument().toObject(Comment.class));
                            }

                            adapter.notifyDataSetChanged();
                           /* if(progressDialog.isShowing())
                                progressDialog.dismiss(); */
                        }
                    }
                });
    }


}