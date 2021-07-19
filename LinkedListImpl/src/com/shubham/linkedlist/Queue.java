package com.shubham.linkedlist;

import java.util.Arrays;

public class Queue {
	final int MAX_SIZE = 10;
	private int[] arr = new int[MAX_SIZE];
	private static int count=0,current=0;
	private int num;
	public static void main(String[] args) throws OverFlow, UnderFlow {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.display();
		q.dequeue();
		q.display();
		q.enqueue(11);
		q.display();
//		q.enqueue(15);
		int number = q.peek();
		System.out.println(number);
		
	}
	
	public void enqueue(int data) throws OverFlow {
		if(count==MAX_SIZE)
			throw new OverFlow("OverFlow Condition Occured");
		else if(count==0) {
			arr[0]=data;
			count++;
		}
		else {
			for(int i=count;i>0;i--) {
				arr[i]=arr[i-1];
			}
			arr[current]=data;
			count++;
		}
	}
	
	public int dequeue() throws UnderFlow {
		if(count==0)
			throw new UnderFlow("UnderFlow Condition Occured");
		int num=arr[count-1];
		arr[count-1]=0;
		count--;
		return num;
	}
	
	public int peek() {
		if(count==0)
			System.out.println("No element present in Queue");
		return arr[count-1];
	}
	
	public void display() {
		for(int i=0;i<count;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

}

class OverFlow extends Exception{
	private static final long serialVersionUID = 1L;

	public OverFlow(String msg) {
		super(msg);
	}
}
class UnderFlow extends Exception{
	private static final long serialVersionUID = 1L;

	public UnderFlow(String msg) {
		super(msg);
	}
}
