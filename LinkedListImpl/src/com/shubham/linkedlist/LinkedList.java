package com.shubham.linkedlist;

public class LinkedList {
	private Node head;
	private Node current;
	
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.display();
		list.remove(3);
		list.remove(2);
		list.remove(5);
		list.display();
	}
	
	public void add(int data) {
		Node node=new Node(data);
		if(head==null) {
			head=node;
			current=head;
		}
		else {
			current.next=node;
			current=node;
		}
	}
	
	public void remove(int data) {
		if(head==null) {
			System.out.println("Empty Linked List!");
		}
		else {
			Node temp=head;
			Node previous=temp;
			while(temp!=null) {
				if(temp==head&&temp.data==data) {
					head=head.next;
					return;
				}
				else if(temp.data==data) {
					previous.next=temp.next;
					temp.next=null;
					return;
					
				}
				previous=temp;
				temp=temp.next;
			}
			System.out.println("No such element exists!");
		}
	}
	
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}

}
