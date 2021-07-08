package com.example.myapplication;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ObjectOutputStream;
import java.net.Socket;

class My_Thread extends Thread {

    String host;
    int port;
    int cnt;

    public My_Thread(String host, int port, int cnt) {
        this.host = host;
        this.port = port;
        this.cnt = cnt;
    }


    public void run() {


        try {
            Socket socket = new Socket(host, port);

            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());

            if(cnt == 1) {
                Order order = new Order("real", 3, "Chicken");
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                String jsonOutput = gson.toJson(order);
                outStream.writeObject(jsonOutput);
                outStream.flush();

                System.out.println(jsonOutput);
            }
            else{
                outStream.writeObject("test");
                outStream.flush();
                outStream.close();
            }

            socket.close();

        } catch (Exception e) {

        }

    }

}

