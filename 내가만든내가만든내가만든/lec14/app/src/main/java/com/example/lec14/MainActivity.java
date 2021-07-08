package com.example.lec14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    Button btn1, btn2, btn3;
    TextView txt;
    ProgressBar pro;
    int mp3_position;

    ArrayList<String> mp3_list;
    String mp3_select;
    String mp3_Path = Environment.getExternalStorageDirectory().getPath() + "/";
    MediaPlayer mp3_Player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("절대 간단하지 않은 mp3 플레이어");

        /* 권한 요청 */
        request_permissions();

        init_data();
        init_listView();
        init_button_txt_pro();

    }

    private void init_button_txt_pro() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        txt = findViewById(R.id.txt);
        pro = findViewById(R.id.pro);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mp3_Player = new MediaPlayer();
                    mp3_Player.setDataSource(mp3_Path + mp3_select);
                    mp3_Player.prepare();
                } catch (IOException e) {
                }
                mp3_Player.start();
                btn1.setClickable(false);
                btn2.setClickable(true);
                btn3.setClickable(true);
                txt.setText("실행중인 음악 : " + mp3_select);
                pro.setVisibility(View.VISIBLE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp3_Player.stop();
                mp3_Player.reset();
                btn1.setClickable(true);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn3.setText("일시정지");
                txt.setText("실행중인 음악 : ");
                pro.setVisibility(View.INVISIBLE);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn3.getText() == "일시정지") {
                    btn3.setText("이어듣기");
                    mp3_Player.pause();
                    pro.setVisibility(View.INVISIBLE);
                    mp3_position = mp3_Player.getCurrentPosition();
                } else {
                    btn3.setText("일시정지");
                    mp3_Player.seekTo(mp3_position);
                    mp3_Player.start();
                    pro.setVisibility(View.VISIBLE);
                }

                btn1.setClickable(false);
                btn2.setClickable(true);
                btn3.setClickable(true);

                txt.setText("실행중인 음악 : " + mp3_select);
            }
        });
    }

    private void request_permissions() {
        /* 권한 요청 */
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                android.Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);
    }

    private void init_listView() {


        // adapterView
        listView = findViewById(R.id.list);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_single_choice,
                mp3_list);
        listView.setAdapter(adapter);
        listView.setItemChecked(0, true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mp3_select = mp3_list.get(position);
            }
        });

        mp3_select = mp3_list.get(0);
    }


    private void init_data() {
        mp3_list = new ArrayList<String>();
        // data
        File[] listFiles = new File(mp3_Path).listFiles();
        String file_Name, ext_Name;
        for (File file : listFiles) {
            file_Name = file.getName();
            ext_Name = file_Name.substring(file_Name.length() - 3);
            if (ext_Name.equals("mp3")) {
                mp3_list.add(file_Name);
            }
        }
    }
}


