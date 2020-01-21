package com.madantiwari.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.madantiwari.notifications.service.MyService;

public class ServiceForClass extends AppCompatActivity {

    private Button btnstart,btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_for_class);

        btnstart = findViewById(R.id.btnStart);
        btnstop = findViewById(R.id.btnStop);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });
    }

    private void startMyService(){

        startService(new Intent(this, MyService.class));

    }
    private void stopMyService(){

        stopService(new Intent(this, MyService.class));
    }
}
