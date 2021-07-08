package com.example.home_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    MediaPlayer mMediaplayer = new MediaPlayer();
    Button btn1, btn2;
    TextView txt;
    final String path = "gs://test-a526e.appspot.com/test_d/";
    int num = 1;
    FirebaseStorage storage;
    StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txt = findViewById(R.id.txt);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if (num > 1) {
                    num--;
                }
                String a = Integer.toString(num);
                String temp = "song" + a + ".mp3";
                txt.setText(temp);
                fetchAudioUrlFromFirebase(temp);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                if ( num < 4){
                    num++;
                }
                String a = Integer.toString(num);
                String temp = "song" + a + ".mp3";
                txt.setText(temp);
                fetchAudioUrlFromFirebase(temp);
            }
        });
    }

    private void fetchAudioUrlFromFirebase(String temp) {
        storage = FirebaseStorage.getInstance();
        // Create a storage reference from our app
        storageRef = storage.getReferenceFromUrl(path + temp);
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                try {
                    // Download url of file
                    String url = uri.toString();
                    System.out.println(url+"555555555555555555555555");
                    mMediaplayer.reset();
                    mMediaplayer.setDataSource(url);
                    // wait for media player to get prepare
                    mMediaplayer.setOnPreparedListener(MainActivity.this);
                    mMediaplayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("TAG", e.getMessage());
                    }
                });

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}