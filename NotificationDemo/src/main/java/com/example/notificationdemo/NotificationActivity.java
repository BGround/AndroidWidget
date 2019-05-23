package com.example.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RemoteViews;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_com;
    private Button bt_fold;
    private Button bt_hang;
    private RadioGroup radioGroup;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private void findViewById() {
        bt_com = findViewById(R.id.bt_com);
        bt_fold = findViewById(R.id.bt_fold);

        bt_com.setOnClickListener(this);
        bt_fold.setOnClickListener(this);

        radioGroup = findViewById(R.id.rb_all);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_com:
                sendNotificationComm();
                break;
            case R.id.bt_fold:
                sendNotificationFold();
                break;
        }
    }

    private void sendNotificationComm() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.setContentTitle("普通通知");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        notificationManager.notify(0,builder.build());
    }

    private void sendNotificationFold() {
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.setContentTitle("折叠通知");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.view_fold);
        Notification notification = builder.build();
        notification.bigContentView = remoteViews;
        notificationManager.notify(1,notification);
    }

}
