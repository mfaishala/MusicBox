package com.example.musicbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.TimeUnit;

public class PlayingMusic extends AppCompatActivity {

    ImageButton imageButton;
    BottomNavigationView bottomNavigationView;
    TextView playerPosition,playerDuration;
    SeekBar seekBar;
    ImageButton btrewind,btpause,btplay,btnext;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_music);

        TextView textView = findViewById(R.id.judul_lagu_playing);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected (true);


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
                Intent intent = new Intent(PlayingMusic.this, HomePage.class);
                startActivity(intent);
            }
        });

        //player
        playerPosition = findViewById(R.id.player_position);
        playerDuration = findViewById(R.id.player_duration);
        seekBar = findViewById(R.id.seekbar);
        btrewind = findViewById(R.id.btrewind);
        btplay = findViewById(R.id.btplay);
        btpause = findViewById(R.id.btpause);
        btnext = findViewById(R.id.btnext);

        mediaPlayer = MediaPlayer.create(this,R.raw.tulus_hati_hati_dijalan);

        runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,500);
            }
        };

        int duration = mediaPlayer.getDuration();
        String sDuration = convertFormat(duration);

        //
        playerDuration.setText(sDuration);

        btplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btplay.setVisibility(view.GONE);
                btpause.setVisibility(view.VISIBLE);
                mediaPlayer.start();
                seekBar.setMax(mediaPlayer.getDuration());
                handler.postDelayed(runnable,0);
            }
        });

        btpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btplay.setVisibility(view.VISIBLE);
                btpause.setVisibility(view.GONE);
                mediaPlayer.start();
                handler.removeCallbacks(runnable);
            }
        });

        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int currentPosition = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();

                if (mediaPlayer.isPlaying() && duration != currentPosition){
                    currentPosition = currentPosition + 5000;

                    playerPosition.setText(convertFormat(currentPosition));
                    mediaPlayer.seekTo(currentPosition);
                }


            }
        });

        btrewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int currentPosition = mediaPlayer.getCurrentPosition();

                if (mediaPlayer.isPlaying() && currentPosition > 5000){
                    currentPosition = currentPosition + 5000;

                    playerPosition.setText(convertFormat(currentPosition));
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser){
                    mediaPlayer.seekTo(progress);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                btpause.setVisibility(View.GONE);
                btplay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);
            }
        });
    }

    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
        , TimeUnit.MILLISECONDS.toMinutes(duration)
        ,TimeUnit.MILLISECONDS.toSeconds(duration)-
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }


}