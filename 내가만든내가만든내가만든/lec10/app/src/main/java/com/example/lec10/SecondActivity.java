package com.example.lec10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        setTitle("SecondActivity");

        Intent intent2 = getIntent();
        final int hapVal = intent2.getIntExtra("num1", 0)
                         + intent2.getIntExtra("num2", 0);

        Button btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outintent = new Intent(getApplicationContext(),
                                               MainActivity.class);
                outintent.putExtra("hap", hapVal);
                setResult(RESULT_OK, outintent);
                finish();
            }
        });
    }
}
