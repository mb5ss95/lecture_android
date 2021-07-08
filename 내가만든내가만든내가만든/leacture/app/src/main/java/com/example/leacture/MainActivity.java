package com.example.leacture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox check1, check2;
        final Button bnt;
        final ImageView dddc;
        final RadioGroup ratio;
        final RadioButton rto1, rto2;

        ratio = findViewById(R.id.rto);
        rto1 = findViewById(R.id.rto1);
        rto2 = findViewById(R.id.rto2);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        bnt = findViewById(R.id.bnt);
        dddc = findViewById(R.id.ddd);


        check1.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                     @Override
                     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                         if (check1.isChecked() == true) {
                             ratio.setVisibility(View.VISIBLE);
                             bnt.setVisibility(View.VISIBLE);
                             check2.setVisibility(View.INVISIBLE);
                             //sana1.setVisibility(View.VISIBLE);
                             //sana2.setVisibility(View.VISIBLE);
                         } else {
                             ratio.setVisibility(View.INVISIBLE);
                             bnt.setVisibility(View.INVISIBLE);
                             check2.setVisibility(View.VISIBLE);
                             dddc.setImageResource(0);
                             rto1.setChecked(false);
                             rto2.setChecked(false);
                             //sana1.setVisibility(View.INVISIBLE);
                             //sana2.setVisibility(View.INVISIBLE);
                         }
                     }
                 }
                );

        check2.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                     @Override
                     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                             if (check2.isChecked() == true) {
                                 ratio.setVisibility(View.VISIBLE);
                                 bnt.setVisibility(View.VISIBLE);
                                 check1.setVisibility(View.INVISIBLE);
                                 //nako1.setVisibility(View.VISIBLE);
                                 //nako2.setVisibility(View.VISIBLE);
                             } else {
                                 ratio.setVisibility(View.INVISIBLE);
                                 bnt.setVisibility(View.INVISIBLE);
                                 check1.setVisibility(View.VISIBLE);
                                 dddc.setImageResource(0);
                                 rto1.setChecked(false);
                                 rto2.setChecked(false);
                                 //nako1.setVisibility(View.INVISIBLE);
                                 //nako2.setVisibility(View.INVISIBLE);
                             }

                     }
                 }
                );

        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (ratio.getCheckedRadioButtonId()) {
                    case R.id.rto1:
                        if (check1.isChecked() == true) {
                            dddc.setImageResource(R.drawable.tksk1);
                        } else {
                            dddc.setImageResource(R.drawable.na2);
                        }
                        break;
                    case R.id.rto2:
                        if (check2.isChecked() == true) {
                            dddc.setImageResource(R.drawable.na1);
                        } else {
                            dddc.setImageResource(R.drawable.tksk2);
                        }
                        break;
                }
            }
        });

    }
}
