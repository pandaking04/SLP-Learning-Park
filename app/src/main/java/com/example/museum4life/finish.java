package com.example.museum4life;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class finish extends AppCompatActivity {

    Button comment_btn,home_btn,retry_btn;
    private String myComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        comment_btn = findViewById(R.id.comment_btn);
        home_btn = findViewById(R.id.home_btn);
        retry_btn = findViewById(R.id.again_btn);

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
                        Toast.makeText(finish.this, "Commemt Added", Toast.LENGTH_LONG).show();
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