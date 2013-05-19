package lab.center.center;

import java.math.BigInteger;
import java.util.Date;
import android.util.Log;

public class Calculation implements Runnable {

	private String mType;
	private int mSize;
	
	public Calculation() {
		mType = "LAB_FOR_LANG";
	}
	
	public Calculation(String type) {
		mType = type;
	}
	
	public Calculation(int size) {
		mSize = size;
	}

	@Override
	public void run() {
		labForService(mSize);
	}

	public static void labForService() {
//		Log.i("LocalService", "Calculation started");
		BigInteger count = new BigInteger("0");
		for (int i = 0; i < Integer.MAX_VALUE / 20000; i++) {
			count.add(new BigInteger(String.valueOf(i)));
		}
		Log.i("LocalService", "Channel Calcultion finished at " + new Date().getTime() / 1e3 % 1e6);
	}
	
	public static void labForService(int size) {
//		Log.i("LocalService", "Calculation started");
		BigInteger count = new BigInteger("0");
		for (int i = 0; i < size; i++) {
			count.add(new BigInteger(String.valueOf(i)));
		}
		Log.i("LocalService", "Channel Calcultion finished at " + new Date().getTime() / 1e3 % 1e6);
	}
	


	

}
