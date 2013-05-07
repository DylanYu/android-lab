package lab.service;

import util.Calculation;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class AIntentService extends IntentService {


	public AIntentService() {
		super("A Intent Service");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		Log.i("LocalService", "IntentService onHandle");
		Calculation.labForService();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("LocalService", "IntentService onCreate");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("LocalService", "IntentService onDestroy");
	}

}
