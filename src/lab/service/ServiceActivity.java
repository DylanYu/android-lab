package lab.service;

import java.util.Date;

import yu.lab.R;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class ServiceActivity extends Activity {

	private ANormalService mBoundService;
	private boolean mIsBound;
	private Date mStartTime;
	private Date mEndTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service);
		mIsBound = false;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.service, menu);
        return true;
    }
	
	@Override
	public void onResume() {
		super.onResume();
		mStartTime = new Date();
		Log.i("LocalService", "Services started at " + mStartTime.getTime() / 1e3 % 1e6);
//		doBindService();
//		doStartNormalService(30);
		doStartIntentService(30);
	}
	
	@Override
	public void onPause() {
		mEndTime = new Date();
		Log.i("LocalService", (mEndTime.getTime() / 1e3 % 1e6 - mStartTime.getTime() / 1e3 % 1e6) + "");
		super.onPause();
	}
	
	@Override
	public void onStop() {
		super.onStop();
//		doUnbindService();
//		doStopNormailService();
		doStopIntentService();
	}



	private ServiceConnection mConnection = new ServiceConnection() {
	    public void onServiceConnected(ComponentName className, IBinder service) {
	        // This is called when the connection with the service has been
	        // established, giving us the service object we can use to
	        // interact with the service.  Because we have bound to a explicit
	        // service that we know is running in our own process, we can
	        // cast its IBinder to a concrete class and directly access it.
	        mBoundService = ((ANormalService.LocalBinder)service).getService();

	        // Tell the user about this for our demo.
	        Toast.makeText(getApplication(), R.string.service_connected,
	                Toast.LENGTH_SHORT).show();
	    }

	    public void onServiceDisconnected(ComponentName className) {
	        // This is called when the connection with the service has been
	        // unexpectedly disconnected -- that is, its process crashed.
	        // Because it is running in our same process, we should never
	        // see this happen.
	        mBoundService = null;
	        Toast.makeText(getApplication(), R.string.service_disconnected,
	                Toast.LENGTH_SHORT).show();
	    }
	};

	void doStartIntentService(int n) {
		Intent intent = new Intent(ServiceActivity.this, AIntentService.class);
		for (int i = 0; i < n; i++) {
			startService(intent);
		}
	}
	
	void doStopIntentService() {
		Intent intent = new Intent(ServiceActivity.this, AIntentService.class);
		stopService(intent);
	}
	
	void doStartNormalService(int n) {
		Intent intent = new Intent(ServiceActivity.this, ANormalService.class);
		for (int i = 0; i < n; i++) {
			startService(intent);
		}
	}
	
	void doStopNormailService() {
		Intent intent = new Intent(ServiceActivity.this, ANormalService.class);
		stopService(intent);
	}
	
	void doBindService() {
	    // Establish a connection with the service.  We use an explicit
	    // class name because we want a specific service implementation that
	    // we know will be running in our own process (and thus won't be
	    // supporting component replacement by other applications).
	    bindService(new Intent(this, 
	            ANormalService.class), mConnection, Context.BIND_AUTO_CREATE);
	    mIsBound = true;
	}

	void doUnbindService() {
	    if (mIsBound) {
	        // Detach our existing connection.
	        unbindService(mConnection);
	        mIsBound = false;
	    }
	}

	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    doUnbindService();
	}
}
