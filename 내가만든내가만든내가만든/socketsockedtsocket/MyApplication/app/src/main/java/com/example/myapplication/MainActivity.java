package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener, Wiget_interface {

    Button btn1;
    EditText edit;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_wiget();
        init_image();
    }

    public void init_image() {
        String temp = edit.getText().toString();
        int temp2 = 3000;
        Our_Thread thread = new Our_Thread(temp, temp2, img);
        thread.start();
    }

    @Override
    public void init_wiget() {
        btn1 = findViewById(R.id.btn1);
        edit = findViewById(R.id.edit);
        img = findViewById(R.id.image);

        btn1.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                String temp = edit.getText().toString();
                int temp2 = 3000;

                My_Thread thread = new My_Thread(temp, temp2, 1);
                thread.start();

                break;
        }


    }
}

