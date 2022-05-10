package com.example.musicbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Search extends AppCompatActivity {

    ImageButton imageButton;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bottomNavigationView = findViewById(R.id.Search_Page);
        bottomNavigationView.setSelectedItemId(R.id.Search);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {


                    case R.id.Search:
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

        imageButton=(ImageButton) findViewById(R.id.Notifikasi_search);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Notifications.class);
                startActivity(intent);
            }
        });

        imageButton=(ImageButton) findViewById(R.id.back_search);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}