package com.example.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class My_Thread extends Thread {
    public void run() {
        String host = "192.168.219.101";
        int port = 3000;

        try {
            Socket socket = new Socket(host, port);

            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            Order order = new Order("Jungwoon", 3, "Chicken");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(order);
            outStream.writeObject(jsonOutput);
            outStream.flush();
            System.out.println(jsonOutput);


            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String input = (String) inputStream.readObject();
            System.out.println("from server : " + input);

            socket.close();


        } catch (Exception e) {

        }

    }

}
