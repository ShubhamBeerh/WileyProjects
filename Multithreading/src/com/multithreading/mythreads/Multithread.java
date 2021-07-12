package com.multithreading.mythreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Multithread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread1 m1 = new MyThread1();
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m1);
		t1.start();
		Thread.sleep(10);
		t2.start();
		System.out.println(m1.getList());
		
	}

}
class MyThread1 implements Runnable{
	List<Integer> list = Collections.EMPTY_LIST;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		list = new ArrayList<Integer>();
		for(int i=0;i<=100;i++) {
			if(!list.contains(i))
				list.add(i);
		}
	}
	public List<Integer> getList() {
		return list;
	}	
	
}
