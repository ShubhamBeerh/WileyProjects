package com.multithreading.mythreads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FibonacciThread {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		// 0 1 1 2 3 5 8 13
		Fibonacci f = Fibonacci.getObj(5);
		Thread t1 = new Thread(f);
		Thread t2 = new Thread(f);
//		System.out.println(f.getList());
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(500);
		System.out.println("---------------------------------");
		System.out.println(f.getList());
		System.out.println("---------------------------------");
		int fibSum =f.getList().stream().reduce(0,(a,b)->a+b);
		System.out.println("Final Fibonacci Sum = "+fibSum);
	}

}
class Fibonacci implements Runnable{
	private int num;
	private static Fibonacci f=null;
	ArrayList<Integer> currentResult = new ArrayList<Integer>();
	int lastResult=1;
	List<Integer> list = new ArrayList<Integer>();

	public Fibonacci(int num) {
		list.add(0);
		list.add(1);
		this.num=num;
	}

	public static Fibonacci getObj(int num) {
		if(f == null)
			return new Fibonacci(num);
		return f;
	}
	@Override
	public void run() {
		Fibonacci f = Fibonacci.getObj(5);
		for(int i=2;i<=f.num;i++) {
			if(Thread.currentThread().getName().equals("Thread-0")) {
			currentResult.add(this.list.get(i-2)+this.list.get(i-1));
			System.out.println("*********************************");
			System.out.println("Fibonacci Pattern");
			System.out.println(list.get(i-2)+"+"+list.get(i-1)+"="+currentResult.get(i-2));
			list.add(currentResult.get(i-2));
			}
			if(Thread.currentThread().getName().equals("Thread-1")) {
			System.out.println("---------------------------------");
			System.out.println("Print Pattern");
			System.out.println(lastResult+"+"+currentResult.get(i-2)+"="+(lastResult+currentResult.get(i-2)));
			lastResult=lastResult+currentResult.get(i-2);
			}
		}
	}
	
	public List<Integer> getList(){
		return list;
	}
	
}
