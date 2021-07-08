package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class MainActivity extends AppCompatActivity {

    Socket socket;
    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            socket = IO.socket("http://124.54.159.27:80");
        }catch (Exception e) {
            e.printStackTrace();
        }
        socket.connect();

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener()
        {
            @Override
            public void call(Object... args) {
                socket.emit("message_from_client", "Hi~ 나는 안드로이드야.");
            }
        }).on("message_from_server", new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(args[0].toString());
                    }
                });
            }
        });

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.result);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "보냄.",
                        Toast.LENGTH_SHORT).show();
                //String msg = editText.getText().toString();
               //socket.emit("message_from_client", msg);
                String test = "test12";
                socket.emit("message_from_client", test);
            }
        });
    }
}
