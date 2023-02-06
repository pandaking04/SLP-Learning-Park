package com.example.museum4life;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ancient_detail extends AppCompatActivity {

    TextView name, description;
    String item_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ancient_detail);

        name = findViewById(R.id.detail_name);
        description = findViewById(R.id.detail_description);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            item_name = extras.getString("name");
        }

        name.setText(item_name);
    }
}