package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button btnLogout,btnEdit, btnCredit;
    TextView usernameTxt;
    private String currentUser;
    private DatabaseReference profileUserRef;
    private FirebaseFirestore fireStore;
    private String uid;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        drawerLayout = findViewById(R.id.drawer_layout);

        mAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        uid = mAuth.getCurrentUser().getUid();
        usernameTxt = findViewById(R.id.username_txt);
        btnLogout = findViewById(R.id.logout_btn);
        btnEdit = findViewById(R.id.edit_btn);
        btnCredit = findViewById(R.id.credit_btn);

        btnCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, credit.class));
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,Edit_Profile.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });

        fireStore.collection("Users").document(uid).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String username = documentSnapshot.getString("username");

                usernameTxt.setText(username);
            }
        });




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:
                        return true;

                    case R.id.map:
                        startActivity(new Intent(getApplicationContext(),activity_map.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case  R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return  true;
                }
                return false;
            }
        });


        mAuth = FirebaseAuth.getInstance();
    }

    private void Logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Profile.this, LoginActivity.class));
        finish();
    }



    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    private void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void LogoutClick(View view){
        logout();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Profile.this.closeDrawer(drawerLayout);
    }

    @Override
    public void  onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null){
            startActivity(new Intent(Profile.this, LoginActivity.class));
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Profile.this, LoginActivity.class));
    }
}