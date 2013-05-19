package lab.center.center;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class QueuedWork extends IntentService {

	private static final String TAG = "LocalService";
	
	public QueuedWork() {
		super("Workload Intent Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i(TAG, "Channel Queued IntentService onHandle");
		Calculation.labForService(Integer.MAX_VALUE / 10000);
	}

}
