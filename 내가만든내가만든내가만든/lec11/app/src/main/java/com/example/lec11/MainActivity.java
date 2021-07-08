package com.example.lec11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*setTitle("ListView");

        final String[] mid = {"1", "2", "3"};

        ListView list = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (MainActivity.this,
                 android.R.layout.simple_list_item_1, mid);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(MainActivity.this, mid[position], Toast.LENGTH_SHORT).show();
            }
        });*/

        setTitle("ListView Add");

        final ArrayList<String> midList = new ArrayList<>();
        ListView listView = findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (MainActivity.this,
                        android.R.layout.simple_list_item_1, midList);
        listView.setAdapter(adapter);

        final EditText editText = findViewById(R.id.edit);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                midList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}

