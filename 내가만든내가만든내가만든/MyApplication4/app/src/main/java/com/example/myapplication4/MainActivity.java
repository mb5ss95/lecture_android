package com.example.myapplication4;

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
    int lockstate, lockstate1, lockstate2 = 0;

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
        if(lockstate==0)
        {
            switch (v.getId()) {
                case R.id.Botton_32:
                    input.setText(input.getText().toString() + 0);
                    break;
                case R.id.Botton_24:
                    input.setText(input.getText().toString() + 1);
                    break;
                case R.id.Botton_25:
                    input.setText(input.getText().toString() + 2);
                    break;
                case R.id.Botton_26:
                    input.setText(input.getText().toString() + 3);
                    break;
                case R.id.Botton_17:
                    input.setText(input.getText().toString() + 4);
                    break;
                case R.id.Botton_18:
                    input.setText(input.getText().toString() + 5);
                    break;
                case R.id.Botton_19:
                    input.setText(input.getText().toString() + 6);
                    break;
                case R.id.Botton_10:
                    input.setText(input.getText().toString() + 7);
                    break;
                case R.id.Botton_11:
                    input.setText(input.getText().toString() + 8);
                    break;
                case R.id.Botton_12:
                    input.setText(input.getText().toString() + 9);
                    break;
                case R.id.Botton_33:
                    input.setText(input.getText().toString() + ".");
                    break;
                case R.id.Botton_28:
                    input.setText(input.getText().toString() + k);
                    break;
                case R.id.Botton_29:
                    input.setText(input.getText().toString() + pi);
                    break;
                case R.id.Botton_30:
                    input.setText(input.getText().toString() + e);
                    break;
            }
        }
    }

    public void onClick1 (View v)
    {
        lockstate = 1;
        if(lockstate==1 && lockstate1==0)
        {
            number1 = input.getText().toString();
            dounum1 = Double.parseDouble(number1);
            dounum1 = checkdoutoint(dounum1);
            switch (v.getId())
            {
                case R.id.Botton_4:
                    input.setText(result.getText().toString() + "%");
                    type = REM;
                    break;
                case R.id.Botton_6:
                    input.setText(number1 + "+");
                    type = ADD;
                    break;
                case R.id.Botton_13:
                    input.setText(number1 + "-");
                    type = SUB;
                    break;
                case R.id.Botton_20:
                    input.setText(number1 + "*");
                    type = MUL;
                    break;
                case R.id.Botton_27:
                    input.setText(number1 + "/");
                    type = DIV;
                    break;
                case R.id.Botton_31:
                    dounum1*=dounum1;
                    result.setText(dounum1 + "");
                    break;
            }
            dounum2 = dounum1;
            lockstate=0;
            lockstate1=1;
        }
    }

    public void onClick2 (View v)
    {
        lockstate = 1;
        if(lockstate==1 && lockstate1==1)
        {
            number2 = input.getText().toString();
            dounum1 = Double.parseDouble(number2);
            dounum1 = checkdoutoint(dounum1);
            input.setText(number2 + "=");
                switch (type)
                {
                case 0:
                    dounum1 = dounum2 + dounum1;
                    result.setText("" + dounum1);
                    break;
                case 1:
                    dounum1 = dounum2 - dounum1;
                    result.setText("" + dounum1);
                    break;
                case 2:
                    dounum1 = dounum2 * dounum1;
                    result.setText("" + dounum1);
                    break;
                case 3:
                    dounum1 = dounum2 / dounum1;
                    result.setText("" + dounum1);
                    break;
                case 4:
                    dounum1 = dounum2 / 100;
                    result.setText("" + dounum1);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
            }
            lockstate = 2;
        }
    }

    public void onClick3 (View v)
    {
        switch (v.getId())
        {
            case R.id.Botton_3:
                input.setText("");
                result.setText("");
                lockstate = lockstate1 = 0;
                intnum1 = intnum2 = 0;
                dounum1 = dounum2 = 0;
                number1 = number2="";
                break;
            case R.id.Botton_5:
                String del_number = input.getText().toString();
                input.setText(del_number.substring(0,del_number.length() - 1));
                break;

        }
    }
}