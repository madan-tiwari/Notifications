package com.madantiwari.notifications.broadcastreceiver;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.madantiwari.notifications.R;
import com.madantiwari.notifications.createchannel.CreateChannel;

public class BroadcastReceiverExample extends android.content.BroadcastReceiver {

    private int counter=0;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    public void onReceive(Context context, Intent intent) {
        CreateChannel createChannel=new CreateChannel(context);
        createChannel.createChannel();
        boolean noConnectivity;
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity=intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                    false
            );

            if (noConnectivity){
                //Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();

                DisplayPopUpNotification(context,"Wifi status", "Disconnected");


            }else {
//                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                DisplayPopUpNotification(context,"Wifi status", "Connected");
            }
        }
    }


    private void DisplayPopUpNotification(Context context,String title, String message){
        Notification notification=new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setContentText(message)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        counter=counter+1;

        notificationManagerCompat.notify(counter,notification);
    }


}
