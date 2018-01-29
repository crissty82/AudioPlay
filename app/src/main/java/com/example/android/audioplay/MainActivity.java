package com.example.android.audioplay;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mplayer;
    public Button b1, b2, b3;
    private int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.play);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mplayer = MediaPlayer.create(MainActivity.this, R.raw.color_black);
                mplayer.start();
            }
        });

        b2 = (Button) findViewById(R.id.pause);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mplayer.isPlaying())
                    mplayer.pause();
                else
                {
                    length = mplayer.getCurrentPosition();
                    mplayer.seekTo(length);
                    mplayer.start();
                }
            }
        });

        b3 = (Button) findViewById(R.id.stop);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mplayer.stop();
                mplayer.release();
            }
        });


    }
}
