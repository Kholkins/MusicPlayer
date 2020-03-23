package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView playPause;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPause = (ImageView)findViewById(R.id.imageViewIconPlay);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.original);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
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

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1000);
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
