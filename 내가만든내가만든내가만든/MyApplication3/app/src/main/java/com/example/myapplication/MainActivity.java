package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    TextView result, input;

    String history = "";
    String number1 = "";
    String number2 = "";
    double dounum1, dounum2;
    int intnum1, intnum2;

    int type;
    int ADD = 0;
    int SUB = 1;
    int MUL = 2;
    int DIV = 3;
    int REM = 4;
    int Sin = 5;
    int Cos = 6;
    int Tan = 7;
    int Lnx = 8;
    int Log = 9;
    int Odx = 10;
    int Eux = 11;
    int Xfc = 12;
    int Xuy = 13;
    int Abx = 14;
    int Xut = 15;
    int Sqt = 16;

    double pi=3.14159;
    double e =2.71828;
    double k =138 * Math.pow(10,21);

    public static double checkdoutoint(double x)
    {
        int temp = (int)x;
        return (x-temp==0) ? temp : x;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        input = findViewById(R.id.input);

    }


    public void onClick (View v)
    {
            switch (v.getId())
            {
                case R.id.Botton_32:
                    result.setText(result.getText().toString() + 0);
                    break;
                case R.id.Botton_24:
                    result.setText(result.getText().toString() + 1);
                    break;
                case R.id.Botton_25:
                    result.setText(result.getText().toString() + 2);
                    break;
                case R.id.Botton_26:
                    result.setText(result.getText().toString() + 3);
                    break;
                case R.id.Botton_17:
                    result.setText(result.getText().toString() + 4);
                    break;
                case R.id.Botton_18:
                    result.setText(result.getText().toString() + 5);
                    break;
                case R.id.Botton_19:
                    result.setText(result.getText().toString() + 6);
                    break;
                case R.id.Botton_10:
                    result.setText(result.getText().toString() + 7);
                    break;
                case R.id.Botton_11:
                    result.setText(result.getText().toString() + 8);
                    break;
                case R.id.Botton_12:
                    result.setText(result.getText().toString() + 9);
                    break;
                case R.id.Botton_33:
                    result.setText(result.getText().toString() + ".");
                    break;
                case R.id.Botton_28:
                    result.setText(result.getText().toString() + k);
                    break;
                case R.id.Botton_29:
                    result.setText(result.getText().toString() + pi);
                    break;
                case R.id.Botton_30:
                    result.setText(result.getText().toString() + e);
                    break;
            }
    }
}