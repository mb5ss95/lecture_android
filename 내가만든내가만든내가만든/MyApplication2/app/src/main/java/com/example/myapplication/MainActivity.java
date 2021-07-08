package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView TextResult, TextPutin;
    String num1, num2;
    Integer result;
    Botton btn0, btn1, btn2, btn3;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setTitle("계산기");



        btn0 = (Button) findViewById(R.id.Button_0);
        btn1 = (Button) findViewById(R.id.Button_1);
        btn2 = (Button) findViewById(R.id.Button_2);
        btn3 = (Button) findViewById(R.id.Button_3);



        TextResult = (TextView) findViewById(R.id.TextResult);
        TextPutin = (TextView) findViewById(R.id.TextPutin);

        btn1.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                result= Integer.parseInt(num1)+ Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        btn2.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                result= Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        btn3.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                result= Integer.parseInt(num1)* Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
        btn4.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1){
                num1= edit1.getText().toString();
                num2= edit2.getText().toString();
                textResult.setText("계산 결과 : " + Math.sqrt((double)Integer.parseInt(num1)));
                return false;
            }
        });

        setContentView(R.layout.main);

    }
}
