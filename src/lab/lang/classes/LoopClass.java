package lab.lang.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import android.util.Log;

public class LoopClass {
	private static ArrayList<Integer> arrayList;
	private static LinkedList<Integer> linkedList;
	private static int length = Integer.MAX_VALUE / 100000;
//	private static int length = Integer.MAX_VALUE / 2000;
	
//	static {
//		makeLinkedList();
//		makeArrayList();
//	}
	
	public LoopClass() {
		makeLinkedList();
		makeArrayList();
	}
	
	public static void makeArrayList() {
		arrayList = new ArrayList<Integer>();
		Date d0 = new Date();
		for(int i = 0; i < length; i++) {
			arrayList.add(i);
		}
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "MakeArrayLoop:" + String.valueOf(time));
	}
	
	public static void makeLinkedList() {
		linkedList = new LinkedList<Integer>();
		Date d0 = new Date();
		for(int i = 0; i < length; i++) {
			linkedList.add(i);
		}
		Date d1 = new Date();
		long time = d1.getTime() - d0.getTime();
		Log.i("TAG", "MakeLinkedLoop:" + String.valueOf(time));
	}
	
	public static void worserLinkedLoop() {
		int a;
		for(int i = 0; i < linkedList.size(); i++)
			a = linkedList.get(i);
	}
	
	public static void traditionalLinkedLoop() {
		int a;
		int size = linkedList.size();
		for(int i = 0; i < size; i++)
			a = linkedList.get(i);
	}
	
	public static void foreachLinkedLoop() {
		int a;
		for(int i: linkedList)
			a = i;
	}
	
	public static void worserArrayLoop() {
		int a;
		for(int i = 0; i < arrayList.size(); i++)
			a = arrayList.get(i);
	}
	
	public static void traditionalArrayLoop() {
		int a;
		int size = arrayList.size();
		for(int i = 0; i < size; i++)
			a = arrayList.get(i);
	}
	
	public static void foreachArrayLoop() {
		int a;
		for(int i: arrayList)
			a = i;
	}
}
