package com.example.musicbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Library extends AppCompatActivity {

    CardView cardView;
    ImageButton imageButton;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        imageButton=(ImageButton) findViewById(R.id.button_notif_library);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this, Notifications.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.Libarary_page);
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

        //Liked Song
        cardView=(CardView) findViewById(R.id.Liked_Song);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this, Liked_Song.class);
                startActivity(intent);
            }
        });

        //My Following
        cardView=(CardView) findViewById(R.id.My_Following);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this, My_Following.class);
                startActivity(intent);
            }
        });

        //My Playlist
        cardView=(CardView) findViewById(R.id.My_Playlist);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this, My_Playlist.class);
                startActivity(intent);
            }
        });
    }
}