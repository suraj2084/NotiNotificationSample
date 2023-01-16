package com.example.android.notificationsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final static String Channal_id="My Channal";
    private final static int notify_id=100;
    private final static int REQ_code=101;
    AppCompatButton Bigpicture;
    AppCompatButton InboxStyle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bigpicture=findViewById(R.id.BigPictureStyle);
        InboxStyle=findViewById(R.id.InboxStyle);
        Bitmap largeICon;
        largeICon = ((BitmapDrawable) (Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.pngwing, null)))).getBitmap();
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(new NotificationChannel(Channal_id,"New Channal",NotificationManager.IMPORTANCE_HIGH));


        Bigpicture.setOnClickListener((View view) -> {
            Notification noti;
            //      big Picture Style
            Notification.BigPictureStyle bigPictureStyle=new Notification.BigPictureStyle();
            bigPictureStyle.bigPicture(((BitmapDrawable) (Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.pngwing, null)))).getBitmap());
            bigPictureStyle.bigLargeIcon(largeICon);
            bigPictureStyle.setSummaryText("Image sent by Sameen");
            bigPictureStyle.setSummaryText("Image Message");
            //Inbox Style
            Notification.InboxStyle inboxStyle=new Notification.InboxStyle();
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho");
            inboxStyle.setBigContentTitle("Full Message");
            inboxStyle.setSummaryText("Message From ChanderMohan");
            Intent INOTIfi;
            INOTIfi=new Intent(this,MainActivity2.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_code, INOTIfi, PendingIntent.FLAG_UPDATE_CURRENT);
            INOTIfi.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            noti = new Notification.Builder(getApplicationContext())
                    .setLargeIcon(largeICon)
                    .setSmallIcon(R.drawable.pngwing)
                    .setContentText("New Message")
                    .setSubText("New Message From Sameen")
                    .setStyle(bigPictureStyle)
                    .setContentIntent(pendingIntent)
                    .setChannelId(Channal_id)
                    .setOngoing(true)
                    .build();
            notificationManager.notify(notify_id,noti);

        });
        InboxStyle.setOnClickListener((View view) -> {
            //Inbox Style
            Notification.InboxStyle inboxStyle=new Notification.InboxStyle();
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho app");
            inboxStyle.addLine("Hlo kese ho");
            inboxStyle.setBigContentTitle("Full Message");
            inboxStyle.setSummaryText("Message From ChanderMohan");
            Intent INOTIfi;
            INOTIfi=new Intent(this,MainActivity2.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_code, INOTIfi, PendingIntent.FLAG_UPDATE_CURRENT);
            INOTIfi.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Notification  noti = new Notification.Builder(getApplicationContext())
                    .setLargeIcon(largeICon)
                    .setSmallIcon(R.drawable.pngwing)
                    .setContentText("New Message")
                    .setSubText("New Message From Sameen")
                    .setStyle(inboxStyle)
                    .setContentIntent(pendingIntent)
                    .setChannelId(Channal_id)
                    .setOngoing(true)
                    .build();
            notificationManager.notify(notify_id,noti);
        });




    }
}