package com.madantiwari.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.madantiwari.notifications.broadcastreceiver.BroadcastReceiverExample;

public class BroadcastActivity extends AppCompatActivity {

    Button btn_noti,btn_ser;
    BroadcastReceiverExample broadcastReceiverExample = new BroadcastReceiverExample();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        btn_noti=findViewById(R.id.btn_noti);

        btn_ser=findViewById(R.id.btn_service);
        btn_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BroadcastActivity.this,ServiceForClass.class);
                startActivity(intent);
            }
        });
        btn_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BroadcastActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiverExample, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiverExample);
    }
}
