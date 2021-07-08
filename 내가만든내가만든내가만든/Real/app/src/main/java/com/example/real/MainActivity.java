
package com.example.real;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, buttonP, button4,
            button5, button6, buttonX, button7, button8, button9, buttonre,
            buttonD, button0, buttonR, buttonC, buttonM, buttondot, buttonDel;
    private TextView edit, edit1;
    private Double a, b, c =0.0;

    private int where = 0;
    private boolean lk = false;
    private boolean tk = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"IPhone",Toast.LENGTH_SHORT).show();

        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        buttonP=(Button)findViewById(R.id.buttonP);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        buttonX=(Button)findViewById(R.id.buttonX);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button9=(Button)findViewById(R.id.button9);
        buttonD=(Button)findViewById(R.id.buttonD);
        button0=(Button)findViewById(R.id.button0);
        buttonR=(Button)findViewById(R.id.buttonR);
        buttonC=(Button)findViewById(R.id.buttonC);
        buttonM=(Button)findViewById(R.id.buttonM);
        buttondot=(Button)findViewById(R.id.buttondot);
        buttonDel=(Button)findViewById(R.id.buttonDEL);
        buttonre=(Button)findViewById(R.id.buttonremainder);

        edit =findViewById(R.id.edit1);
        edit1 =findViewById(R.id.edit2);

        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c==1.0){}
                else{
                if(v==button1){
                    edit1.setText(edit1.getText().toString()+1); lk=true;
                }
                else if(v==button2){
                    edit1.setText(edit1.getText().toString()+2); lk=true;
                }
                else if(v==button3){
                    edit1.setText(edit1.getText().toString()+3); lk=true;
                }
                else if(v==button4){
                    edit1.setText(edit1.getText().toString()+4); lk=true;
                }
                else if(v==button5){
                    edit1.setText(edit1.getText().toString()+5); lk=true;
                }
                else if(v==button6){
                    edit1.setText(edit1.getText().toString()+6); lk=true;
                }
                else if(v==button7){
                    edit1.setText(edit1.getText().toString()+7); lk=true;
                }
                else if(v==button8){
                    edit1.setText(edit1.getText().toString()+8); lk=true;
                }
                else if(v==button9){
                    edit1.setText(edit1.getText().toString()+9); lk=true;
                }
                else if(v==button0){
                    edit1.setText(edit1.getText().toString()+0); lk=true;
                }
                else if(v==buttondot){
                    if(lk==true&&tk==false) {
                        edit1.setText(edit1.getText().toString() + ".");
                        tk = true;
                    }
                }}
                if(v==buttonC){
                    edit.setText("");
                    edit1.setText("");
                    a=b=c=0.0;
                    tk=lk=false;
                    where=0;
                }
            }
        };

        View.OnClickListener c2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c==1){Toast.makeText(getApplicationContext(),
                        "초기화 해주세요.",Toast.LENGTH_SHORT).show();}
                else{
                if(lk==false){Toast.makeText(getApplicationContext(),
                        "숫자를 누르세요.",Toast.LENGTH_SHORT).show();}
                else{
                if(v==buttonP){
                    if(where>0){}
                    else{
                    a=Double.valueOf(edit1.getText().toString().trim());
                    edit.setText(a+" + ");
                    edit1.setText("");
                    where=1;
                }}
                else if(v==buttonDel){
                    if(edit1.getText().toString().length()==0){
                        Toast.makeText(getApplicationContext(),
                            "지울게 없습니다.",Toast.LENGTH_SHORT).show();}
                    else {
                        edit1.setText(edit1.getText().toString().substring
                                (0, edit1.getText().toString().length() - 1));
                    }
                }
                else if(v==buttonX){
                    if(where>0){}
                    else{
                    a=Double.valueOf(edit1.getText().toString().trim());
                    edit.setText(a+" * ");
                    edit1.setText("");
                    where=2;}
                }
                else if(v==buttonD){
                    if(where>0){}
                    else{
                    a=Double.valueOf(edit1.getText().toString().trim());
                    edit.setText(a+" / ");
                    edit1.setText("");
                    where=3;}
                }
                else if(v==buttonM){
                    if(where>0){}
                    else{
                    a=Double.valueOf(edit1.getText().toString().trim());
                    edit.setText(a+" - ");
                    edit1.setText("");
                    where=4;}
                }
                else if(v==buttonre)
                {
                    if(where>0){}
                    else{
                    a=Double.valueOf(edit1.getText().toString().trim());
                    edit.setText(a+" % ");
                    edit1.setText("");
                    where=5;}
                }
                else if(v==buttonR) {
                    lk=false;
                    if (where == 1) {
                        b = Double.valueOf(edit1.getText().toString().trim());
                        edit.setText(a + " + "+ b);
                        a+=b;
                        edit1.setText(""+a);
                    }
                    else if (where == 2) {
                        b = Double.valueOf(edit1.getText().toString().trim());
                        edit.setText(a + " * "+ b);
                        a*=b;
                        edit1.setText(""+a);
                    }
                    else if (where == 3) {
                        b = Double.valueOf(edit1.getText().toString().trim());
                        edit.setText(a + " / "+ b);
                        a/=b;
                        edit1.setText(""+a);
                    }
                    else if (where == 4) {
                        b = Double.valueOf(edit1.getText().toString().trim());
                        edit.setText(a + " - "+ b);
                        a-=b;
                        edit1.setText(""+a);
                    }
                    else if (where == 5) {
                        edit.setText(a + " % ");
                        a = a/100;
                        edit1.setText("" + a);
                    }
                    c=1.0;
                }
                }
            }}

        };
        button1.setOnClickListener(cl);
        button2.setOnClickListener(cl);
        button3.setOnClickListener(cl);
        buttonP.setOnClickListener(c2);
        button4.setOnClickListener(cl);
        button5.setOnClickListener(cl);
        button6.setOnClickListener(cl);
        buttonX.setOnClickListener(c2);
        button7.setOnClickListener(cl);
        button8.setOnClickListener(cl);
        button9.setOnClickListener(cl);
        buttonD.setOnClickListener(c2);
        button0.setOnClickListener(cl);
        buttonR.setOnClickListener(c2);
        buttonC.setOnClickListener(cl);
        buttonM.setOnClickListener(c2);
        buttonre.setOnClickListener(c2);
        buttondot.setOnClickListener(cl);
        buttonDel.setOnClickListener(c2);
    }
}