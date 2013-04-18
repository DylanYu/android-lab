package lab.service;

import java.math.BigInteger;
import java.util.Date;


import lab.service.R;

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

	private LocalService mBoundService;
	private boolean mIsBound;
	
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
//		doBindService();
		doStartService();
//		new Thread(new Calculate(Integer.MAX_VALUE / 10000)).start();
	}
	
	@Override
	public void onStop() {
		super.onStop();
//		doUnbindService();
		doStopService();
	}



	private ServiceConnection mConnection = new ServiceConnection() {
	    public void onServiceConnected(ComponentName className, IBinder service) {
	        // This is called when the connection with the service has been
	        // established, giving us the service object we can use to
	        // interact with the service.  Because we have bound to a explicit
	        // service that we know is running in our own process, we can
	        // cast its IBinder to a concrete class and directly access it.
	        mBoundService = ((LocalService.LocalBinder)service).getService();

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

	void doStartService() {
		Intent intent = new Intent(ServiceActivity.this, LocalService.class);
		startService(intent);
	}
	
	void doStopService() {
		Intent intent = new Intent(ServiceActivity.this, LocalService.class);
		stopService(intent);
	}
	
	void doBindService() {
	    // Establish a connection with the service.  We use an explicit
	    // class name because we want a specific service implementation that
	    // we know will be running in our own process (and thus won't be
	    // supporting component replacement by other applications).
	    bindService(new Intent(this, 
	            LocalService.class), mConnection, Context.BIND_AUTO_CREATE);
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
}
