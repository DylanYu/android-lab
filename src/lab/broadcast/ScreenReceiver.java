package lab.broadcast;

import util.Util;
import lab.service.R;
import lab.service.ServiceActivity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	private Context context;
	private NotificationManager mNM;
    // Unique Identification Number for the Notification.
    // We use it on Notification start, and to cancel it.
    private int NOTIFICATION = R.string.service_started;
	
	public ScreenReceiver(Context context, NotificationManager mNM) {
		super();
		this.mNM = mNM;
		this.context = context;
	}

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		showNotification();
	}
	
	/**
     * Show a notification while this service is running.
     */
    private void showNotification() {
        // In this sample, we'll use the same text for the ticker and the expanded notification
        String text = context.getString(R.string.broadcast_notification);
    	
        // Set the icon, scrolling text and timestamp
        Notification notification = new Notification(R.drawable.ic_launcher, text,
                System.currentTimeMillis());

        // The PendingIntent to launch our activity if the user selects this notification
//        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
//                new Intent(this, ServiceActivity.class), 0);

        // Set the info for the views that show in the notification panel.
        notification.setLatestEventInfo(context, context.getString(R.string.broadcast_notification),
                       text, null);

        // Send the notification.
        mNM.notify(NOTIFICATION, notification);
    }

}
