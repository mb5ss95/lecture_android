package com.example.myapplication;

import android.widget.ImageView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class Our_Thread extends Thread {

    String host;
    int port;
    ImageView img;

    public Our_Thread(String host, int port, ImageView img) {
        this.host = host;
        this.port = port;
        this.img = img;
    }

    public void run() {
        try {
            Socket socket = new Socket(host, port);

            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            outStream.writeUTF("test");
            outStream.flush();

            System.out.println("!!!!!!!!!!START1!!!!!!!!!!");
            byte[] bytes = new byte[10240];
            int temp = 0;

            while (socket.isConnected() && temp < 10240) {
                if (temp == 0) {
                    System.out.println("!!!!!!!!!!START2!!!!!!!!!!");
                }
                bytes[temp] = inputStream.readByte();
                temp++;
            }
            System.out.println("!!!!!!!!!!START3!!!!!!!!!!");
            System.out.println("bytes array length : " + bytes.length);
            for(int i = 0; i < bytes.length; i++){
                System.out.println("bytes[" + i + "] : " + bytes[i]);
            }

            Your_Thread p = new Your_Thread(bytes, img);
            new Thread(p).start();

            socket.close();

        } catch (Exception e) {

        }

    }

}

