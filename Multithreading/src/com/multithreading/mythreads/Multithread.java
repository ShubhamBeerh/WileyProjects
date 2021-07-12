package com.multithreading.mythreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Multithread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 m1 = new MyThread1();
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m1);
		t1.start();
		t2.start();
		
	}

}
class MyThread1 implements Runnable{
	List<Integer> list = Collections.EMPTY_LIST;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		list = new ArrayList<Integer>();
		for(int i=0;i<=100;i++) {
			if(Thread.currentThread().getName().equals("Thread-0")&&i<=50) {
				list.add(i);
				System.out.println(Thread.currentThread().getName()+"-"+i);
			}
			else if(Thread.currentThread().getName().equals("Thread-1")&&i>50) {
				list.add(i);
				System.out.println(Thread.currentThread().getName()+"-"+i);
			}
		}
		
	}
	
}
