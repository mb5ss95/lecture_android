package com.example.lec10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ActivityExam");

        android.util.Log.i("activity Test", "OnCreate()");

        Button btn3 = findViewById(R.id.btn);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:01012341234");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        Button btn4 = findViewById(R.id.btn2);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        android.util.Log.i("Activity test", "onDestroy()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        android.util.Log.i("Activity test", "onPause()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        android.util.Log.i("Activity test", "onRestart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        android.util.Log.i("Activity test", "onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        android.util.Log.i("Activity test", "onStart()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        android.util.Log.i("Activity test", "onStop()");
    }
}
