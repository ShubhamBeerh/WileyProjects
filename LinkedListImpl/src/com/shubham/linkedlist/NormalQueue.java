package com.shubham.linkedlist;

/*!!!MAINTAINED */
import java.util.Arrays;

public class NormalQueue {
	final int MAX_SIZE = 10;
	private int[] arr = new int[MAX_SIZE];
	private static int rear=0,front=0;
	private int num;
	public static void main(String[] args) throws OverFlow, UnderFlow {
		// TODO Auto-generated method stub
		NormalQueue q = new NormalQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.dequeue();
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.display();
		q.dequeue();
		q.dequeue();
		q.display();
//		q.enqueue(11);
		int number = q.peek();
		System.out.println(number);
		
	}
	
	public void enqueue(int data) throws OverFlow {
		if(rear==MAX_SIZE)
			throw new OverFlow("OverFlow Condition Occured");
		else {
			arr[rear]=data;
			rear++;
		}
	}
	
	public int dequeue() throws UnderFlow {
		if(rear==front)
			throw new UnderFlow("UnderFlow Condition Occured");
		int num=arr[front];
		arr[front]=0;
		front++;
		return num;
	}
	
	public int peek() {
		if(front==rear)
			System.out.println("No element present in Queue");
		return arr[front];
	}
	
	public void display() {
		for(int i=front;i<rear;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

}
