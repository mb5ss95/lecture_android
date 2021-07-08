package com.example.myapplication566666666666666666;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.github.nkzawa.emitter.Emitter;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    private Socket socket;
    {
        try {
            socket = IO.socket("http://124.54.159.27:80");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        socket.on("msg", onMessage);
        socket.connect();

        btn = (Button)findViewById(R.id.bnt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socket.emit("msg", "hi");
                Log.e("send", "data");
            }
        });
    }

    private Emitter.Listener onMessage = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String data = "oooooooooooookkkkkkkkkkkk";
                    Log.e("get", data);
                }
            });
        }
    };
}