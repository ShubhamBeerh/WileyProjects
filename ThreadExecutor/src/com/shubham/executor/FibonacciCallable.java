package com.shubham.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciCallable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> myList = new ArrayList<Integer>();
		System.out.println("!!!Last index of List contains the sum of Fibonacci!!!");
		ExecutorService service = Executors.newFixedThreadPool(1);
		Series s = new Series(myList);
		Future<List<Integer>> future= service.submit(s);
		Thread.sleep(1000);
		if(future.isDone()) {
			System.out.println(future.get());
		}
		service.shutdown();
	}
}
class Series implements Callable<List<Integer>>{
	List<Integer> list;
	public Series(List<Integer> list) throws Exception{
		this.list=list;
	}
	@Override
	public List<Integer> call() throws Exception {
		// TODO Auto-generated method stub
		List<Integer> custom = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		FibonacciSeries(list);
		list.add(list.stream().reduce(0,(a,b)->a+b));
		return list;
	}
	
	public List<Integer> FibonacciSeries(List<Integer> list){
		for(int i=2;i<=5;i++) {
			list.add(list.get(i-2)+list.get(i-1));
		}
		return list;
	}
	
}
