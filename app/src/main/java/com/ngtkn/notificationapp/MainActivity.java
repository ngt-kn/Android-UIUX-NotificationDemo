package com.ngtkn.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nex3z.notificationbadge.NotificationBadge;

public class MainActivity extends AppCompatActivity {
    final String CHANNEL_ID = "CHANNEL";
    NotificationBadge badge;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        badge = findViewById(R.id.badge);
    }

    public void simpleNotification(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Simple Notification")
                .setContentText("This is a simple notification");

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    public void largeTextNotification(View view) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();

        bigTextStyle.bigText(getString(R.string.lorem_ipsum))
                .setBigContentTitle("Big Text Style")
                .setSummaryText("This is Lorem ipsum");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(bigTextStyle)
                .setLargeIcon(bitmap)
                .setContentTitle("Big Text Notification")
                .setContentText("Demo");

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());
    }

    public void inboxNotification(View view) {

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("This is Inbox Style Notification");

        inboxStyle.addLine("Message 1");
        inboxStyle.addLine("Message 2");
        inboxStyle.addLine("Message 3");
        inboxStyle.addLine("Message 4");
        inboxStyle.addLine("Message 5");
        inboxStyle.addLine("Message 6");
        inboxStyle.setSummaryText("+10 More");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setStyle(inboxStyle)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Inbox Notification")
                .setContentText("Demo");

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

    }

    public void bigPictureNotification(View view) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(bitmap);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setStyle(bigPictureStyle)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Big Picture Style")
                .setContentText("Demo of big picture style notification");

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    // implementation 'com.nex3z:notification-badge:1.0.2' dependency for badge notification
    public void badgeNotification(View view) {
        badge.setNumber(++count);
    }
}
