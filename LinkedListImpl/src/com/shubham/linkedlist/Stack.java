package com.shubham.linkedlist;

public class Stack {
	int[] arr = new int[10];
	static int count=0;
	int num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.display();
		st.pop();
		st.display();
		int number = st.peek();
		System.out.println(number);
		st.display();
	}
	
	public void push(int data) {
		if(count==10) {
			System.out.println("Stack Overflow Error");
			return;
		}
		arr[count]=data;
		count++;
	}
	
	public int pop() {
		if(count==0) {
			System.out.println("Stack Underflow Error");
			return 0;
		}
		num = arr[count-1];
		count--;
		return num;
	}
	
	public int peek() {
		if(count==0) {
			System.out.println("Nothing in stack!");
			return 0;
		}
		num=arr[count-1];
		return num;
	}
	
	public void display() {
		for(int i=count-1;i>=0;i--)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

}
