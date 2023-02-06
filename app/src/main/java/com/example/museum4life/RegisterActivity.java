package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    static int REQUESCODE = 1;
    static int PReqCode = 1;
    private FirebaseAuth mAuth;
    private EditText emailEdit, passwordEdit, userNameEdit, confirmPassword;
    private Button btnRegister;
    private TextView textLogin;
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private FirebaseFirestore firestore;
    private StorageReference storageReference;
    private ImageButton back_btn;
    private static final String USER = "user";
    private static final String TAG = "RegisterActivity";
    private User user;
    ImageView ImgUserPhoto;
    Uri pickedImgUri;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        emailEdit = findViewById(R.id.register_email);
        passwordEdit = findViewById(R.id.register_password);
        btnRegister = findViewById(R.id.register);
        userNameEdit = findViewById(R.id.register_username);
        back_btn = findViewById(R.id.back_btn);
        ImgUserPhoto = findViewById(R.id.profile_pic);
        confirmPassword = findViewById(R.id.register_confirm);

        firestore = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        mDatabase = database.getReference(USER);

//        ImgUserPhoto.setOnClickListener((view) -> {
//            if(Build.VERSION.SDK_INT >= 22){
//                checkAndRequestForPermission();
//            }
//            else{
//                openGallery();
//            }
//        });

        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                String username = userNameEdit.getText().toString();
                String confirmPass = confirmPassword.getText().toString();
                if(email.isEmpty()){
                    emailEdit.setError("Email can not be empty");
                }
                if(password.isEmpty()){
                    passwordEdit.setError("Password can not be empty");
                }
                if(username.isEmpty()){
                    userNameEdit.setError("Username can not be empty");
                }
                if (!password.equals(confirmPass)){
                    confirmPassword.setError("Confirm Password not match");
                }
                user = new User(email,password,username);
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                   if (task.isSuccessful()){
                       Toast.makeText(RegisterActivity.this,"User Created.",Toast.LENGTH_SHORT).show();
                       uid = mAuth.getCurrentUser().getUid();
                       DocumentReference documentReference = firestore.collection("Users").document(uid);
                       Map<String,Object> user = new HashMap<>();
                       user.put("email",email);
                       user.put("username", username);
                       documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void unused) {
                               Log.d(TAG,"onSuccess: " + uid);
                           }
                       });
                       startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                   }
                   else{
                       Toast.makeText(RegisterActivity.this,"ERROR" + task.getException(),Toast.LENGTH_SHORT).show();
                   }
                });
            }
        });




    }

    private void checkAndRequestForPermission() {
        if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(RegisterActivity.this, "Please accept for required permission",Toast.LENGTH_SHORT).show();
            }
            else
            {
                ActivityCompat.requestPermissions(RegisterActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PReqCode);
            }


        }

        else{
            openGallery();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK && requestCode == REQUESCODE && data != null){
//            pickedImgUri = data.getData();
//            ImgUserPhoto.setImageURI(pickedImgUri);
//        }

        if(requestCode == 1000){
            if(requestCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                ImgUserPhoto.setImageURI(imageUri);
            }
        }
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);
    }

    public void registerUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            uid = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = firestore.collection("users").document(uid);
                            Map<String,Object> user = new HashMap<>();
                            user.put("email",emailEdit);
                            user.put("username",userNameEdit);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {

                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "createUserWithEmail:success" + uid);

                                }
                            });
                            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(loginIntent);
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    public void updateUI(FirebaseUser currentUser){
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(user);
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }

//    private void Register() {
//        String user = email.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//        String username = userName.getText().toString().trim();
//        if(user.isEmpty()){
//            email.setError("Email can not be empty");
//        }
//        if(pass.isEmpty()){
//            password.setError("Password can not be empty");
//        }
//        if(username.isEmpty()){
//            userName.setError("Username can not be empty");
//        }
//        else{
//            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
//
//                        Toast.makeText(RegisterActivity.this,"User registerd Successfully", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
//                    }
//                    else{
//                        Toast.makeText(RegisterActivity.this,"Registeration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            });
//        }
//    }
}