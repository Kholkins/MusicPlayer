package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView playPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPause = (ImageView)findViewById(R.id.imageViewIconPlay);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.original);
    }

    public void previous(View view) {
    }

    public void play(View view) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            playPause.setImageResource(R.drawable.ic_play_arrow_24dp);
        }else {
            mediaPlayer.start();
            playPause.setImageResource(R.drawable.ic_pause_24dp);
        }
    }

    public void next(View view) {
    }
}
