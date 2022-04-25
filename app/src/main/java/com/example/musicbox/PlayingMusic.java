package com.example.musicbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlayingMusic extends AppCompatActivity {

    ImageButton imageButton;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_music);

        bottomNavigationView = findViewById(R.id.navbar_playing_music);
        bottomNavigationView.setSelectedItemId(R.id.navbar_setting_icon);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {


                    case R.id.navbar_setting_icon:
                        startActivity(new Intent(getApplicationContext(),Setting_Play_Music.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navbar_Like_icon:
                        return true;

                    case R.id.navbar_Repeat_icon:
                        return true;
                }

                return false;
            }
        });

        imageButton=(ImageButton) findViewById(R.id.button_back_ply_music);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayingMusic.this, PlaylistMusic.class);
                startActivity(intent);
            }
        });
    }
}