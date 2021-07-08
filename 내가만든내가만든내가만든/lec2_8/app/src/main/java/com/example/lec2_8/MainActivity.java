package com.example.lec2_8;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Story> al = new ArrayList<>();
    MyAdapter adapter;
    ListView lv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new click());

        init_data();
        init_adapter();
        init_listView();

    }

    private void init_listView() {
        // adapterView - ListView, GridView

        lv = findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(adapter.mItemClickListner);
    }

    private void init_adapter() {
        // adapter
        adapter = new MyAdapter(
                getApplicationContext(), // 현재화면의 제어권자
                R.layout.sample,
                al);

    }

    private void init_data() {
        // 1. 다량의 데이터
        // 2. Adapter
        // 3. AdapterView
        al.add(new Story("01번 나코", R.drawable.nako001));
        al.add(new Story("02번 나코", R.drawable.nako002));
        al.add(new Story("03번 나코", R.drawable.nako003));
        al.add(new Story("04번 나코", R.drawable.nako004));
        al.add(new Story("05번 나코", R.drawable.nako005));
        al.add(new Story("06번 나코", R.drawable.nako006));
        al.add(new Story("07번 나코", R.drawable.nako007));
        al.add(new Story("08번 나코", R.drawable.nako008));
        al.add(new Story("09번 나코", R.drawable.nako009));
        al.add(new Story("10번 나코", R.drawable.nako010));
        al.add(new Story("11번 나코", R.drawable.nako011));
        al.add(new Story("12번 나코", R.drawable.nako012));
    }
    class click implements Button.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
        }
    }
}



class MyAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Story> al;
    LayoutInflater inf;

    public MyAdapter(Context context, int layout, ArrayList<Story> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        this.inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { // 총 데이터의 개수
        return al.size();
    }

    @Override
    public Object getItem(int position) { // 해당 행의 데이터
        return al.get(position);
    }

    @Override
    public long getItemId(int position) { // 해당 행의 유니크한 id
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inf.inflate(layout, null);

        //TextView tv1 =  convertView.findViewById(R.id.textView1);
        TextView tv2 = convertView.findViewById(R.id.textView2);
        ImageView iv = convertView.findViewById(R.id.imageView1);

        Story s = al.get(position);
        //tv1.setText(s.date);
        tv2.setText(s.message);
        iv.setImageResource(s.img);


        return convertView;
    }

    public AdapterView.OnItemClickListener mItemClickListner = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // parent는 AdapterView의 속성의 모두 사용 할 수 있다.
            //String tv = (String) parent.getAdapter().getItem(position);
            Toast.makeText(context.getApplicationContext(), (position+1)+"번 나코를 선택 하셨습니다.", Toast.LENGTH_SHORT).show();
            //view.setSelected(false);
            //https://recipes4dev.tistory.com/47?category=605791
            //리스트 뷰에 관한것
            /*ImageView iv = view.findViewById(R.id.imageView1);
            view.setBackgroundColor(Color.RED);
            notifyDataSetChanged();*/
        }
    };


}


class Story { // 자바빈
    //String date = "";
    String message = "";
    int img; // 이미지

    public Story(/*String date,*/ String message, int img) {
        //this.date = date;
        this.message = message;
        this.img = img;
    }

    public Story() {
    } // 기본생성자 : 생성자 작업시 함께 추가하자
}

