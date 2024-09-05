package com.aula2.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button getAllPhotos;
    Button getId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllPhotos = findViewById(R.id.getAllPhotos);
        getId = findViewById(R.id.getIdPhoto);

        getAllPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity_getPhoto.class);
                startActivity(intent);
            }
        });

        getId.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity_getPhoto.class).putExtra("byId", true)));
    }
}