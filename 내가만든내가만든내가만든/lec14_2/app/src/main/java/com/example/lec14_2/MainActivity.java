package com.example.lec14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp3_player;
    SeekBar seek;
    Switch switch1;
    TextView txt;
    SimpleDateFormat time = new SimpleDateFormat("mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switch1 = findViewById(R.id.switch1);
        seek = findViewById(R.id.seek);
        txt = findViewById(R.id.txt);

        int position;


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp3_player.pause();
                    mp3_player.seekTo(progress);
                    seek.setProgress(mp3_player.getCurrentPosition());
                    txt.setText("" + time.format(mp3_player.getCurrentPosition()));
                    mp3_player.start();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch1.isChecked() == true) {
                    mp3_player = MediaPlayer.create(MainActivity.this, R.raw.avocado);
                    mp3_player.start();
                    seek.setVisibility(View.VISIBLE);
                    new Thread() {
                        public void run() {
                            if (mp3_player == null) {
                                return;
                            }
                            seek.setMax(mp3_player.getDuration());
                            while (mp3_player.isPlaying()) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        seek.setProgress(mp3_player.getCurrentPosition());
                                        txt.setText("" + time.format(mp3_player.getCurrentPosition()));
                                    }
                                });
                                SystemClock.sleep(200);
                            }
                        }
                    }.start();
                } else {
                    seek.setVisibility(View.INVISIBLE);
                    txt.setText("");
                    mp3_player.stop();
                    mp3_player.reset();
                }
            }
        });
    }
}
