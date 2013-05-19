package lab.center.app;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class OriginOwnWork extends IntentService {

	private static final String TAG = "LocalService";
	
	public OriginOwnWork() {
		super("Workload Intent Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i(TAG, "IntentService onHandle");
		Calculation.labForService(Integer.MAX_VALUE / 5000);
	}

}
