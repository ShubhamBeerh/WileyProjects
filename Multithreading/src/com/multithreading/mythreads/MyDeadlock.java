package com.multithreading.mythreads;

public class MyDeadlock {
	static Object o1 = new Object();
	static Object o2 = new Object();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = () -> {
			while(true) {
				synchronized(o1) {
					try {
						System.out.println(Thread.currentThread().getName()+"has locked Object o1");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(o2) {
						System.out.println(Thread.currentThread().getName()+"locking o2");
					}
				}
			}
		};
		
		Runnable r2 = () -> {
			while(true) {
				synchronized(o2) {
					try {
						System.out.println(Thread.currentThread().getName()+"has locked Object o2");
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized(o1) {
						System.out.println(Thread.currentThread().getName()+"locking o1");
					}
				}
			}
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	}

}
