package com.example.musicbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Liked_Song extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_song);

        bottomNavigationView = findViewById(R.id.Liked_Song_page);
        bottomNavigationView.setSelectedItemId(R.id.Home);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {


                    case R.id.Search:
                        startActivity(new Intent(getApplicationContext(),Search.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),HomePage.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Libarary:
                        startActivity(new Intent(getApplicationContext(),Library.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });


        imageButton=(ImageButton) findViewById(R.id.back_liked_song);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Liked_Song.this, Library.class);
                startActivity(intent);
            }
        });
    }
}