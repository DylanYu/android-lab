package lab.broadcast;

import lab.service.R;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class BroadcastReceiverActivity extends Activity{

	private NotificationManager mNM;
	private ScreenReceiver mScreenReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.broadcast);
		this.mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		IntentFilter screenFilter = new IntentFilter();
		screenFilter.addAction(Intent.ACTION_SCREEN_ON);
		mScreenReceiver = new ScreenReceiver(this, mNM);
	}

	@Override
	protected void onStop() {
		super.onStop();
		unregisterReceiver(mScreenReceiver);
	}

	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter screenFilter = new IntentFilter();
		screenFilter.addAction(Intent.ACTION_SCREEN_ON);
		registerReceiver(mScreenReceiver, screenFilter);
	}

}
