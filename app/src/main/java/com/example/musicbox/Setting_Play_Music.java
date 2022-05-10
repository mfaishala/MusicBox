package com.example.musicbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Setting_Play_Music extends AppCompatActivity {

    ImageButton imageButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_play_music);

        imageButton=(ImageButton) findViewById(R.id.exit_setting_plying);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting_Play_Music.this, PlayingMusic.class);
                startActivity(intent);
            }
        });

        TextView textView = findViewById(R.id.judul_music);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected (true);
    }
}