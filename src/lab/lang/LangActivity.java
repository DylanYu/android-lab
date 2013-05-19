package lab.lang;

import yu.lab.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LangActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lang);
	}

	@Override
	protected void onPause() {
		super.onPause();
		doStopService();
	}

	@Override
	protected void onResume() {
		super.onResume();
		doStartService();
	}
	
	private void doStartService() {
		Intent intent = new Intent(LangActivity.this, CalculationService.class);
		startService(intent);
	}
	
	private void doStopService() {
		Intent intent = new Intent(LangActivity.this, CalculationService.class);
		stopService(intent);
	}

}
