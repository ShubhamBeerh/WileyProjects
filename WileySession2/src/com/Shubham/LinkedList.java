package com.Shubham;

public class LinkedList {
	
	class Node{
		int value;
		Node next;
		Node previous;
		Node(int value){
			this.value=value;
			this.next=null;
			this.previous=null;
		}
	}
	
	private Node first = null;
	private Node last = null;
	
	public void add(int val) {
		Node node = new Node(val);
		if(first==null) {
			first=node;
			last=node;
		}
		else {
			last.next=node;
			node.previous=last;
			last = node;
		}
	}

	public void print() {
		Node curr = first;
		if(first==null) {
			System.out.println("Empty List");
			return;
		}
		while(curr!=null) {
			System.out.println(curr.value);
			curr = curr.next;
		}
	}
	
	public void getElement(int num) {
		Node curr = first;
		if(first==null) {
			System.out.println("Empty Linked List");
			return;
		}
		else {
			int index=1;
			while(curr!=null) {
				if(curr.value==num) {
					try {
					System.out.println("Previous Element : "+curr.previous.value);
					}
					catch(NullPointerException e){
						System.out.println("Previous Element : null");
					}
					System.out.println("Element found at : "+index);
					try {
					System.out.println("Next Element : "+curr.next.value);
					}
					catch(NullPointerException e) {
						System.out.println("Next Element: null");
					}
					return;
				}
				index++;
				curr=curr.next;
			}
			System.out.println("Element Not Found!!");
		}
	}
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.getElement(20);
		l.print();
	}
	
}
