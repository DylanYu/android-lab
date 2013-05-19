package lab.center.app;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SingleModeReceiver extends BroadcastReceiver {

	private static final String TAG = "LocalService";
	
	@Override
	public void onReceive(Context context, Intent arg1) {
		Log.i(TAG, "SINGLE onReceive at " + new Date().getTime() / 1e3 % 1e6);
		Intent intent = new Intent(context, OwnWork.class);
//		Intent intent = new Intent();
//		intent.setClassName("com.channel.lab", "com.channel.lab.QueuedWork");
		context.startService(intent);
	}

}
