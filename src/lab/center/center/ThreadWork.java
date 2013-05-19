package lab.center.center;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ThreadWork extends Service {

	public class LocalBinder extends Binder {
		ThreadWork getService() {
			return ThreadWork.this;
		}
	}

	@Override
	public void onCreate() {
		Log.i("LocalService", "Channel NormalService onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
//		Log.i("LocalService", "NormalService Received start id " + startId + ": " + intent);
		new Thread(new Calculation(Integer.MAX_VALUE / 10000)).start();
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		Log.i("LocalService", "NormalService onDestroy");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("LocalService", "NormalService onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("LocalService", "NormalService onBind");
		return mBinder;
	}

	// This is the object that receives interactions from clients. See
	// RemoteService for a more complete example.
	private final IBinder mBinder = new LocalBinder();
}
