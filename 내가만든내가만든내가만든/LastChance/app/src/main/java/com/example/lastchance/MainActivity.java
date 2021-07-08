package com.example.lastchance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    String IPSERVER = "124.54.159.27";
    int PORTSERVER = 80;
    ToggleButton l1_t1, l1_t2, l1_t3, l2_t1, l2_t2, l3_t1, l3_t2, l3_t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //상태바 없애기
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //눕히기
        //System.setProperty("http.keepAlive", "false");


        Button allon_bnt, alloff_bnt;

        boolean l1_t1_state, l1_t2_state, l1_t3_state;
        boolean l2_t1_state, l2_t2_state;
        boolean l3_t1_state, l3_t2_state, l3_t3_state;

        allon_bnt = findViewById(R.id.allon);
        alloff_bnt = findViewById(R.id.alloff);
        l1_t1 = findViewById(R.id.bnt0);
        l1_t2 = findViewById(R.id.bnt1);
        l1_t3 = findViewById(R.id.bnt2);
        l2_t1 = findViewById(R.id.bnt3);
        l2_t2 = findViewById(R.id.bnt4);
        l3_t1 = findViewById(R.id.bnt5);
        l3_t2 = findViewById(R.id.bnt6);
        l3_t3 = findViewById(R.id.bnt7);

        int arrVal[] = getIntent().getIntArrayExtra("go");


        l1_t1_state = (arrVal[0] != 0);
        l1_t2_state = (arrVal[1] != 0);
        l1_t3_state = (arrVal[2] != 0);
        l2_t1_state = (arrVal[3] != 0);
        l2_t2_state = (arrVal[4] != 0);
        l3_t1_state = (arrVal[5] != 0);
        l3_t2_state = (arrVal[6] != 0);
        l3_t3_state = (arrVal[7] != 0);

        l1_t1.setChecked(l1_t1_state);
        l1_t2.setChecked(l1_t2_state);
        l1_t3.setChecked(l1_t3_state);
        l2_t1.setChecked(l2_t1_state);
        l2_t2.setChecked(l2_t2_state);
        l3_t1.setChecked(l3_t1_state);
        l3_t2.setChecked(l3_t2_state);
        l3_t3.setChecked(l3_t3_state);


        View view = findViewById(R.id.back);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });


        allon_bnt.setOnClickListener(this);
        alloff_bnt.setOnClickListener(this);

        l1_t1.setOnClickListener(this);
        l1_t2.setOnClickListener(this);
        l1_t3.setOnClickListener(this);

        l2_t1.setOnClickListener(this);
        l2_t2.setOnClickListener(this);

        l3_t1.setOnClickListener(this);
        l3_t2.setOnClickListener(this);
        l3_t3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.allon:
                l1_t1.setChecked(true);
                l1_t2.setChecked(true);
                l1_t3.setChecked(true);
                l2_t1.setChecked(true);
                l2_t2.setChecked(true);
                l3_t1.setChecked(true);
                l3_t2.setChecked(true);
                l3_t3.setChecked(true);
                send("all__on");
                break;
            case R.id.alloff:
                l1_t1.setChecked(false);
                l1_t2.setChecked(false);
                l1_t3.setChecked(false);
                l2_t1.setChecked(false);
                l2_t2.setChecked(false);
                l3_t1.setChecked(false);
                l3_t2.setChecked(false);
                l3_t3.setChecked(false);
                send("all_off");
                break;
            case R.id.bnt0:
                if (l1_t1.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l1_t1_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l1_t1_0");
                }
                break;
            case R.id.bnt1:
                if (l1_t2.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l1_t2_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l1_t2_0");
                }
                break;
            case R.id.bnt2:
                if (l1_t3.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l1_t3_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l1_t3_0");
                }
                break;
            case R.id.bnt3:
                if (l2_t1.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l2_t1_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l2_t1_0");
                }
                break;
            case R.id.bnt4:
                if (l2_t2.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l2_t2_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l2_t2_0");
                }
                break;
            case R.id.bnt5:
                if (l3_t1.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l3_t1_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l3_t1_0");
                }
                break;
            case R.id.bnt6:
                if (l3_t2.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l3_t2_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l3_t2_0");
                }
                break;
            case R.id.bnt7:
                if (l3_t3.isChecked() == true) {
                    //l1_t1.setChecked(true);
                    send("l3_t3_1");
                } else {
                    //l1_t1.setChecked(false);
                    send("l3_t3_0");
                }
                break;

        }
    }


    public void send(String str) {

        ExampleThread thread = new ExampleThread(str);
        thread.setDaemon(true);
        new Thread(thread).start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert_ex = new AlertDialog.Builder(this);
        alert_ex.setMessage("정말로 종료하시겠습니까?");

        alert_ex.setPositiveButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert_ex.setNegativeButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                send("end");
                finishAffinity();
            }
        });
        alert_ex.setTitle("알림!!");
        AlertDialog alert = alert_ex.create();
        alert.show();

    }


    void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.timer, null);
        builder.setView(view);
        Button gogo = view.findViewById(R.id.gogo);
        Button nono = view.findViewById(R.id.nono);
        final Button open = view.findViewById(R.id.opentime);
        final Button close = view.findViewById(R.id.closetime);

        open.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog tpd = new TimePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(getApplicationContext(),
                                hourOfDay + "시 " + minute + "분에 불이 켜집니다.",
                                Toast.LENGTH_SHORT).show();
                        String hour = Integer.toString(hourOfDay);
                        String min = Integer.toString(minute);
                        final String result = "OT:" + hour + ":" + min;
                        send(result);
                    }
                }, 0, 00, true);

                tpd.show();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog tpd = new TimePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(getApplicationContext(),
                                hourOfDay + "시 " + minute + "분에 불이 꺼집니다.",
                                Toast.LENGTH_SHORT).show();
                        String hour = Integer.toString(hourOfDay);
                        String min = Integer.toString(minute);
                        final String result = "CT:" + hour + ":" + min;
                        send(result);
                    }
                }, 0, 00, true);
                tpd.show();
            }
        });

        final AlertDialog dialog = builder.create();
        gogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "서버에 저장 되었습니다.",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        nono.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private class ExampleThread extends Thread {

        String str;

        public ExampleThread(String str) {
            this.str = str;
        }

        public void run() {
            try {
                InetAddress srvAddress = InetAddress.getByName(IPSERVER);
                Socket client = new Socket(srvAddress, PORTSERVER);
                DataOutputStream output = new DataOutputStream(client.getOutputStream());
                output.writeUTF(str);
                output.flush();
                output.close();
                client.close();
                Thread.sleep(1000);
            } catch (UnknownHostException e) {
                Log.e("ERROR", e.toString());
            } catch (IOException e) {
                Log.e("ERROR", e.toString());
            } catch (InterruptedException e) {
                Log.d("ERROR", e.toString());
            }
        }
    }
}



