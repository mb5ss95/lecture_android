package com.example.lastchance;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class loading extends AppCompatActivity {


    String IPSERVER = "124.54.159.27";
    int PORTSERVER = 80;
    int[] intArr = new int[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler hd = new Handler();

        ExampleThread thread = new ExampleThread();
        thread.setDaemon(true);
        new Thread(thread).start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hd.postDelayed(new splashhandler(), 4000); // 1초 후에 hd handler 실행  3000ms = 3초
    }

    private class splashhandler implements Runnable {
        public void run() {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.putExtra("go", intArr);
            startActivity(intent); //로딩이 끝난 후, ChoiceFunction 이동
            loading.this.finish(); // 로딩페이지 Activity stack에서 제거
        }
    }

    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }

    private class ExampleThread extends Thread {

        String str;

        public ExampleThread() {
            this.str = "check__";
        }

        public void run() {
            try {
                InetAddress srvAddress = InetAddress.getByName(IPSERVER);
                Socket client = new Socket(srvAddress, PORTSERVER);

                DataOutputStream output = new DataOutputStream(client.getOutputStream());
                DataInputStream input = new DataInputStream(client.getInputStream());

                output.writeUTF(str);
                output.flush();
                //Toast.makeText(MainActivity.this, inputStream.readUTF(), Toast.LENGTH_SHORT).show();
                byte[] byteArr = new byte[8];
                int sum;
                while (client.isConnected()) {
                    intArr[0] = 0;
                    intArr[1] = 0;
                    intArr[2] = 0;
                    intArr[3] = 0;
                    intArr[4] = 0;
                    intArr[5] = 0;
                    intArr[6] = 0;
                    intArr[7] = 0;
                    sum = 0;
                    input.read(byteArr);
                    intArr[0] = byteArr[0] - 48;
                    intArr[1] = byteArr[1] - 48;
                    intArr[2] = byteArr[2] - 48;
                    intArr[3] = byteArr[3] - 48;
                    intArr[4] = byteArr[4] - 48;
                    intArr[5] = byteArr[5] - 48;
                    intArr[6] = byteArr[6] - 48;
                    intArr[7] = byteArr[7] - 48;
                    sum = intArr[0] + intArr[1] + intArr[2] + intArr[3] + intArr[4] + intArr[5] + intArr[6] + intArr[7];
                    if (sum >= 0) {
                        break;
                    }
                }
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