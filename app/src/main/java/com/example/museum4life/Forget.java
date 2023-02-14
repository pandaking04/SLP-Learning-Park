package com.example.museum4life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget extends AppCompatActivity {

    ImageButton back_btn;
    Button forget_btn;
    EditText forget_txt;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        back_btn = findViewById(R.id.arrow_register);
        forget_txt = findViewById(R.id.forget_edit);
        forget_btn = findViewById(R.id.forget_confirm);
        mAuth = FirebaseAuth.getInstance();

        forget_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = forget_txt.getText().toString();

                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Forget.this,"Done sent",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Forget.this,"Error",Toast.LENGTH_LONG).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Forget.this,"Error Failed",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forget.this, LoginActivity.class));
            }
        });
    }
}