package lab.center.app;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CenterModeReceiver extends BroadcastReceiver {

	private static final String TAG = "LocalService";
	
	@Override
	public void onReceive(Context context, Intent arg1) {
		Log.i(TAG, "CHANNEL onReceive at " + new Date().getTime() / 1e3 % 1e6);
		Intent intent = new Intent();
		intent.setClassName("test.btest", "test.btest.QueuedWork");
//		intent.setAction("com.yu.lab.channel.queued");
//		intent.setAction("android.intent.action.TEST_ACTION_Another");
		context.startService(intent);
	}

}
