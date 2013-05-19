package lab.center.app;

import yu.lab.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class AActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
	}

	@Override
	protected void onResume() {
//		Intent intent = new Intent();
//		intent.setClassName("test.btest", "test.btest.BActivity");
//		startActivity(intent);
		super.onResume();
	}

}
