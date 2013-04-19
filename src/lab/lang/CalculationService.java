package lab.lang;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CalculationService extends Service {
	
	private final IBinder mBinder = new LocalBinder();
	
	public class LocalBinder extends Binder {
		CalculationService getService() {
            return CalculationService.this;
        }
    }
	
	@Override
    public void onCreate() {
        Log.i("TAG", "onCreate");
        new Thread(new Calculation()).start();
    }

	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TAG", "Received start id " + startId + ": " + intent);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }
	
    @Override
    public void onDestroy() {
        // Cancel the persistent notification.
//        mNM.cancel(NOTIFICATION);
        Log.i("TAG", "onDestroy");
        // Tell the user we stopped.
//        Toast.makeText(this, R.string.service_stopped, Toast.LENGTH_SHORT).show();
    }

    @Override
	public boolean onUnbind(Intent intent) {
    	Log.i("TAG", "onUnbind");
		return super.onUnbind(intent);
	}
    
    @Override
    public IBinder onBind(Intent intent) {
    	Log.i("TAG", "onBind");
        return mBinder;
    }
}
