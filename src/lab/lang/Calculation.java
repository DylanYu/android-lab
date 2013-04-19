package lab.lang;

import java.util.Date;

import lab.lang.classes.FinalClass;
import lab.lang.classes.LoopClass;
import lab.lang.classes.NoFinalClass;
import lab.lang.classes.PrivateFieldClass;
import lab.lang.classes.PublicFieldClass;

import android.util.Log;


public class Calculation implements Runnable {

	@Override
	public void run() {
		/* Lab for final
		calculate4NoFinal();
		calculate4Final();
//		calculate4Final();
//		calculate4NoFinal(); 
		 */
		
//		calculate4PublicClass();
//		calculate4PrivateClass();
//		calculate4PrivateClass();
//		calculate4PublicClass();

//		LoopClass.makeArrayList();
		new LoopClass();
		Log.i("TAG", "List Maked");
		
		this.calculate4ForeachLinkedLoop();
		this.calculate4TraditionalLinkedLoop();
		this.calculate4WorserLinkedLoop();
		
		calculate4ForeachArrayLoop();
		calculate4TraditionalArrayLoop();
		calculate4WorserArrayLoop();
		Log.i("TAG", "Finished");
	}
	
	private void calculate4WorserLinkedLoop() {
		Date d0 = new Date();
		LoopClass.worserLinkedLoop();
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "WorserLinkedLoop:" + String.valueOf(time));
	}
	
	private void calculate4TraditionalLinkedLoop() {
		Date d0 = new Date();
		LoopClass.traditionalLinkedLoop();
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "TraditionalLinkedLoop:" + String.valueOf(time));
	}
	
	private void calculate4ForeachLinkedLoop() {
		Date d0 = new Date();
		LoopClass.foreachLinkedLoop();
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "ForeachLinkedLoop:" + String.valueOf(time));
	}
	
	private void calculate4WorserArrayLoop() {
		Date d0 = new Date();
		LoopClass.worserArrayLoop();
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "WorserArrayLoop:" + String.valueOf(time));
	}
	
	private void calculate4TraditionalArrayLoop() {
		Date d0 = new Date();
		LoopClass.traditionalArrayLoop();
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "TraditionalArrayLoop:" + String.valueOf(time));
	}
	
	private void calculate4ForeachArrayLoop() {
		Date d0 = new Date();
		LoopClass.foreachArrayLoop();
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "ForeachArrayLoop:" + String.valueOf(time));
	}
	
	private void calculate4NoFinal() {
		Date d0 = new Date();
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			int a = NoFinalClass.intVal;
			String s = NoFinalClass.strVal;
		}
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "0:" + String.valueOf(time));
	}
	
	private void calculate4Final() {
		Date d0 = new Date();
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			int a = FinalClass.intVal;
			String s = FinalClass.strVal;
		}
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "1:" + String.valueOf(time));
	}
	
	private void calculate4PublicClass() {
		PublicFieldClass obj = new PublicFieldClass();
		int tmp;
		Date d0 = new Date();
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			obj.a = i;
			tmp = obj.a;
		}
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "Public:" + String.valueOf(time));
	}
	
	private void calculate4PrivateClass() {
		PrivateFieldClass obj = new PrivateFieldClass();
		int tmp;
		Date d0 = new Date();
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			obj.setA(i);
			tmp = obj.getA();
		}
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "Private:" + String.valueOf(time));
	}

}
