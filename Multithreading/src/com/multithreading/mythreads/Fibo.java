package com.multithreading.mythreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Series s = new Series(1);
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		F1 f1 = new F1(s,list);
		F2 f2 = new F2(s,list);
		Thread t1 = new Thread(f1);
		Thread t2 = new Thread(f2);
		t1.start();
		Thread.sleep(500);
		t2.start();
	}

}

class F1 implements Runnable{
	volatile List<Integer> list;
	Series s;
	public F1(Series s,List<Integer> list) {
		this.s=s;
		this.list=list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			s.T1(list);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class F2 implements Runnable{
	volatile List<Integer> list;
	Series s;
	public F2(Series s,List<Integer> list){
		this.s=s;
		this.list=list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			s.T2(list);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
class Series{
	static int last;
	public Series(int last) {
		this.last=last;
	}
	public void T1(List<Integer> list) throws InterruptedException{
		while(list.size()!=10) {
		synchronized(this) {
			last++;
			list.add(list.get(last-2)+list.get(last-1));
			System.out.println(Thread.currentThread().getName()+list);
			this.wait();
			System.out.println("T1 Resumed");
			this.notify();
		}
		
	}
}
	public void T2(List<Integer> list) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Thread.sleep(500);
		while(list.size()!=10) {
			synchronized(this) {
				last++;
				list.add(list.get(last-2)+list.get(last-1));
				notify();
				System.out.println(Thread.currentThread().getName()+list);
				this.wait();
				System.out.println("T2 Resumed");
//				Thread.sleep(500);
			
			}
		}
		
	}
}
