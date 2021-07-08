package com.example.moonproject;

import androidx.appcompat.app.AppCompatActivity;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import android.content.pm.ActivityInfo;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {



    private
    MqttAndroidClient mqttAndroidClient;
    Button allon_bnt, alloff_bnt;
    ToggleButton l1_t1, l1_t2, l1_t3, l2_t1, l2_t2, l3_t1, l3_t2, l3_t3;

    boolean l1_t1_state, l1_t2_state, l1_t3_state;
    boolean l2_t1_state, l2_t2_state;
    boolean l3_t1_state, l3_t2_state, l3_t3_state;

    String topic_lolin1 = "topic_lolin1";
    String topic_lolin2 = "topic_lolin2";
    String topic_lolin3 = "topic_lolin3";
    String iiip = "tcp://192.168.137.234:1883";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //상태바 없애기
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //눕히기

        allon_bnt = findViewById(R.id.allon);
        alloff_bnt = findViewById(R.id.alloff);
        l1_t1= findViewById(R.id.bnt0);
        l1_t2= findViewById(R.id.bnt1);
        l1_t3= findViewById(R.id.bnt2);
        l2_t1= findViewById(R.id.bnt3);
        l2_t2= findViewById(R.id.bnt4);
        l3_t1= findViewById(R.id.bnt5);
        l3_t2= findViewById(R.id.bnt6);
        l3_t3= findViewById(R.id.bnt7);


        mqttAndroidClient = new MqttAndroidClient(this,  iiip, MqttClient.generateClientId());
        // 2번째 파라메터 : 브로커의 ip 주소 , 3번째 파라메터 : client 의 id를 지정함 여기서는 paho 의 자동으로 id를 만들어주는것


        try
        {
            IMqttToken token = mqttAndroidClient.connect(getMqttConnectionOption());    //mqtttoken 이라는것을 만들어 connect option을 달아줌
            token.setActionCallback(new IMqttActionListener()
            {
                @Override
                public void onSuccess(IMqttToken asyncActionToken)
                {
                    mqttAndroidClient.setBufferOpts(getDisconnectedBufferOptions());    //연결에 성공한경우
                    Log.e("Connect_success", "Success");
                    try
                    {
                        mqttAndroidClient.subscribe(topic_lolin1, 0 );   //연결에 성공하면 토픽으로 subscribe함
                        mqttAndroidClient.subscribe(topic_lolin2, 0 );   //연결에 성공하면 토픽으로 subscribe함
                        mqttAndroidClient.subscribe(topic_lolin3, 0 );   //연결에 성공하면 토픽으로 subscribe함
                        mqttAndroidClient.publish(topic_lolin1, "all".getBytes(), 0 , false );
                        mqttAndroidClient.publish(topic_lolin2, "all".getBytes(), 0 , false );
                        mqttAndroidClient.publish(topic_lolin3, "all".getBytes(), 0 , false );
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception)
                {
                    //연결에 실패한경우
                    Log.e("connect_fail", "Failure " + exception.toString());
                    Toast.makeText(MainActivity.this, "fail",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (MqttException e)
        {
            e.printStackTrace();
        }


        //subscribe 할때 3번째 파라메터에 익명함수 리스너를 달아줄수도있음

        /*try
        {
            mqttAndroidClient.subscribe(tttopic, 0, new IMqttMessageListener()
            {
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception
                {

                }
            });
        }
        catch (MqttException e)
        {
            e.printStackTrace();
        }*/

        allon_bnt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    mqttAndroidClient.publish(topic_lolin1, "allon".getBytes(), 0 , false );
                    mqttAndroidClient.publish(topic_lolin2, "allon".getBytes(), 0 , false );
                    mqttAndroidClient.publish(topic_lolin3, "allon".getBytes(), 0 , false );
                    l1_t1.setChecked(true);
                    l1_t2.setChecked(true);
                    l1_t3.setChecked(true);
                    l2_t1.setChecked(true);
                    l2_t2.setChecked(true);
                    l3_t1.setChecked(true);
                    l3_t2.setChecked(true);
                    l3_t3.setChecked(true);
                    //버튼을 클릭하면 jmlee 라는 토픽으로 메시지를 보냄
                }
                catch (MqttException e)
                {
                    e.printStackTrace();
                }
            }
        });

        alloff_bnt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    mqttAndroidClient.publish(topic_lolin1, "alloff".getBytes(), 0 , false );
                    mqttAndroidClient.publish(topic_lolin2, "alloff".getBytes(), 0 , false );
                    mqttAndroidClient.publish(topic_lolin3, "alloff".getBytes(), 0 , false );
                    l1_t1.setChecked(false);
                    l1_t2.setChecked(false);
                    l1_t3.setChecked(false);
                    l2_t1.setChecked(false);
                    l2_t2.setChecked(false);
                    l3_t1.setChecked(false);
                    l3_t2.setChecked(false);
                    l3_t3.setChecked(false);
                    //버튼을 클릭하면 jmlee 라는 토픽으로 메시지를 보냄
                }
                catch (MqttException e)
                {
                    e.printStackTrace();
                }
            }
        });

        l1_t1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l1_t1.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin1, "t1_1".getBytes(), 0 , false );
                        l1_t1.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin1, "t1_0".getBytes(), 0 , false );
                        l1_t1.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        l1_t2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l1_t2.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin1, "t2_1".getBytes(), 0 , false );
                        l1_t2.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin1, "t2_0".getBytes(), 0 , false );
                        l1_t2.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        l1_t3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l1_t3.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin1, "t3_1".getBytes(), 0 , false );
                        l1_t3.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin1, "t3_0".getBytes(), 0 , false );
                        l1_t3.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        l2_t1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l2_t1.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin2, "t1_1".getBytes(), 0 , false );
                        l2_t1.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin2, "t1_0".getBytes(), 0 , false );
                        l2_t1.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        l2_t2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l2_t2.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin2, "t2_1".getBytes(), 0 , false );
                        l2_t2.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin2, "t2_0".getBytes(), 0 , false );
                        l2_t2.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        l3_t1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l3_t1.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin3, "t1_1".getBytes(), 0 , false );
                        l3_t1.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin3, "t1_0".getBytes(), 0 , false );
                        l3_t1.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        l3_t2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l3_t2.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin3, "t2_1".getBytes(), 0 , false );
                        l3_t2.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin3, "t2_0".getBytes(), 0 , false );
                        l3_t2.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        l3_t3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (l3_t3.isChecked() == true){
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin3, "t3_1".getBytes(), 0 , false );
                        l3_t3.setChecked(true);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    try
                    {
                        mqttAndroidClient.publish(topic_lolin3, "t3_0".getBytes(), 0 , false );
                        l3_t3.setChecked(false);
                    }
                    catch (MqttException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        mqttAndroidClient.setCallback(new MqttCallback()
        {
            //클라이언트의 콜백을 처리하는부분

            @Override
            public void connectionLost(Throwable cause)
            {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception
            {
                //모든 메시지가 올때 Callback method
                if (topic.equals(topic_lolin1))
                {
                    //topic 별로 분기처리하여 작업을 수행할수도있음
                    String msg = new String(message.getPayload());
                    l1_t1_state = (Integer.parseInt(msg.substring(0, 1)) != 0);
                    l1_t1.setChecked(l1_t1_state);
                    l1_t2_state = (Integer.parseInt(msg.substring(1, 2)) != 0);
                    l1_t2.setChecked(l1_t2_state);
                    l1_t3_state = (Integer.parseInt(msg.substring(2, 3)) != 0);
                    l1_t3.setChecked(l1_t3_state);
                }
                else if(topic.equals(topic_lolin2))
                {
                    String msg = new String(message.getPayload());
                    l2_t1_state = (Integer.parseInt(msg.substring(0, 1)) != 0);
                    l2_t1.setChecked(l2_t1_state);
                    l2_t2_state = (Integer.parseInt(msg.substring(1, 2)) != 0);
                    l2_t2.setChecked(l2_t2_state);
                }
                else if(topic.equals(topic_lolin3))
                {
                    String msg = new String(message.getPayload());

                    l3_t1_state = (Integer.parseInt(msg.substring(0, 1)) != 0);
                    l3_t1.setChecked(l3_t1_state);
                    l3_t2_state = (Integer.parseInt(msg.substring(1, 2)) != 0);
                    l3_t2.setChecked(l3_t2_state);
                    l3_t3_state = (Integer.parseInt(msg.substring(2, 3)) != 0);
                    l3_t3.setChecked(l3_t3_state);
                }
            }


            @Override
            public void deliveryComplete(IMqttDeliveryToken token)
            {

            }
        });
    }


    private DisconnectedBufferOptions getDisconnectedBufferOptions()
    {
        DisconnectedBufferOptions disconnectedBufferOptions = new DisconnectedBufferOptions();
        disconnectedBufferOptions.setBufferEnabled(true);
        disconnectedBufferOptions.setBufferSize(100);
        disconnectedBufferOptions.setPersistBuffer(true);
        disconnectedBufferOptions.setDeleteOldestMessages(false);
        return disconnectedBufferOptions;
    }



    private MqttConnectOptions getMqttConnectionOption()
    {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setWill("aaa", "I am going offline".getBytes(), 1, true);
        return mqttConnectOptions;
    }
}
