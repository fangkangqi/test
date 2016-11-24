package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TimeReceiver extends BroadcastReceiver{
	


	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("recevice");
		context.startService(new Intent(context,NotifyService.class));
		
	}

}
