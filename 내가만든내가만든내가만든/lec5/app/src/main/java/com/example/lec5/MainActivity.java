package com.example.lec5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener, CalendarView.OnDateChangeListener {

    private
    Chronometer chrono;
    Button bnt_start, bnt_end;
    RadioButton rbnt_cal, rbnt_time;
    CalendarView calview;
    TimePicker tpicker;
    TextView txt_y, txt_m, txt_d, txt_hour, txt_min;
    int select_y, select_m, select_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = findViewById(R.id.id_chronometer);
        bnt_start = findViewById(R.id.id_bnt_start);
        bnt_end = findViewById(R.id.id_bnt_end);
        rbnt_cal = findViewById(R.id.id_rbnt_cal);
        rbnt_time = findViewById(R.id.id_rbnt_time);
        calview = findViewById(R.id.id_calview);
        tpicker = findViewById(R.id.id_tpicker);
        txt_y = findViewById(R.id.id_txt_y);
        txt_m = findViewById(R.id.id_txt_m);
        txt_d = findViewById(R.id.id_txt_d);
        txt_hour = findViewById(R.id.id_txt_hour);
        txt_min = findViewById(R.id.id_txt_min);

        calview.setVisibility(View.INVISIBLE);
        tpicker.setVisibility(View.INVISIBLE);

        bnt_start.setOnClickListener(this);
        bnt_end.setOnClickListener(this);
        rbnt_cal.setOnClickListener(this);
        rbnt_time.setOnClickListener(this);

        calview.setOnDateChangeListener(this);
    }

    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
        select_y = year;
        select_m = month + 1;
        select_d = dayOfMonth;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_rbnt_cal:
                rbnt_time.setChecked(false);
                calview.setVisibility(View.INVISIBLE);
                tpicker.setVisibility(View.VISIBLE);
                break;

            case R.id.id_rbnt_time:
                rbnt_cal.setChecked(false);
                calview.setVisibility(View.VISIBLE);
                tpicker.setVisibility(View.INVISIBLE);
                break;

            case R.id.id_bnt_start:
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.setTextColor(Color.RED);
                chrono.start();
                break;

            case R.id.id_bnt_end:
                chrono.setTextColor(Color.BLUE);
                chrono.stop();
                txt_y.setText(Integer.toString(select_y));
                txt_m.setText(Integer.toString(select_m));
                txt_d.setText(Integer.toString(select_d));
                txt_hour.setText(Integer.toString(tpicker.getCurrentHour()));
                txt_min.setText(Integer.toString(tpicker.getCurrentMinute()));
                break;
        }
    }
}
