package lab.service;

import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;


import lab.service.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class LocalService extends android.app.Service {

	 private NotificationManager mNM;

	    // Unique Identification Number for the Notification.
	    // We use it on Notification start, and to cancel it.
	    private int NOTIFICATION = R.string.service_started;

	    /**
	     * Class for clients to access.  Because we know this service always
	     * runs in the same process as its clients, we don't need to deal with
	     * IPC.
	     */
	    public class LocalBinder extends Binder {
	    	LocalService getService() {
	            return LocalService.this;
	        }
	    }

	    @Override
	    public void onCreate() {
	        mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

	        // Display a notification about us starting.  We put an icon in the status bar.
//	        showNotification();
	        Log.i("LocalService", "onCreate");
	        new Thread(new Calculate(Integer.MAX_VALUE / 10000)).start();
	    }

	    @Override
	    public int onStartCommand(Intent intent, int flags, int startId) {
	        Log.i("LocalService", "Received start id " + startId + ": " + intent);
	        // We want this service to continue running until it is explicitly
	        // stopped, so return sticky.
	        return START_STICKY;
	    }

	    @Override
	    public void onDestroy() {
	        // Cancel the persistent notification.
//	        mNM.cancel(NOTIFICATION);
	        Log.i("LocalService", "onDestroy");
	        // Tell the user we stopped.
//	        Toast.makeText(this, R.string.service_stopped, Toast.LENGTH_SHORT).show();
	    }

	    @Override
		public boolean onUnbind(Intent intent) {
	    	Log.i("LocalService", "onUnbind");
			return super.onUnbind(intent);
		}

		@Override
	    public IBinder onBind(Intent intent) {
	    	Log.i("LocalService", "onBind");
	        return mBinder;
	    }

	    // This is the object that receives interactions from clients.  See
	    // RemoteService for a more complete example.
	    private final IBinder mBinder = new LocalBinder();

	    class Calculate implements Runnable {
	    	private int n;
	    	Calculate(int n) {
	    		this.n = n;
	    	}
	    	private void calculate() {
	    		Date t0 = new Date();
		    	BigInteger sum = new BigInteger("0");
		    	for(int i = 0; i < n; i++) {
		    		sum = sum.add(new BigInteger(String.valueOf(i)));
		    		if(i % 100000 == 0)
		    			Log.i("LocalService", (double)i / n + "");
		    	}
		    	Date t1 = new Date();
		    	
		    	Log.i("LocalService", sum.toString() + "");
		    	Log.i("LocalService", (double)(t1.getTime() - t0.getTime()) / 1000 + "");
		    }
	    	
	    	public void run() {
	    		calculate();
	    	}
	    }
	    
	    
	    
	    /**
	     * Show a notification while this service is running.
	     */
	    private void showNotification() {
	        // In this sample, we'll use the same text for the ticker and the expanded notification
	        CharSequence text = getText(R.string.service_started);

	        // Set the icon, scrolling text and timestamp
	        Notification notification = new Notification(R.drawable.ic_launcher, text,
	                System.currentTimeMillis());

	        // The PendingIntent to launch our activity if the user selects this notification
	        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
	                new Intent(this, ServiceActivity.class), 0);

	        // Set the info for the views that show in the notification panel.
	        notification.setLatestEventInfo(this, getText(R.string.service_label),
	                       text, contentIntent);

	        // Send the notification.
	        mNM.notify(NOTIFICATION, notification);
	    }

}
