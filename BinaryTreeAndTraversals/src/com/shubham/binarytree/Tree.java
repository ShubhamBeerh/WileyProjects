package com.shubham.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node{
	Node left,right;
	int data;
	public Node(int data) {
		this.data = data;
	}
}

public class Tree {
	static Scanner sc = null;
	static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		root=createTree();
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		levelOrder(root);
		System.out.println();
		searchNode(10);
		searchNode(4);
		searchNode(3);
		searchNode(9);
		insertNode(8);
		preOrder(root);
	}
	
	static Node createTree() {
		Node root=null;
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		if(data==-1) return null;
		root = new Node(data);
		System.out.println("Enter left for :"+data);
		root.left=createTree();
		System.out.println("Enter right for :"+data);
		root.right=createTree();
		return root;
	}
	
	static void preOrder(Node node) {
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void inOrder(Node node) {
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	static void postOrder(Node node) {
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	static void levelOrder(Node node) {
		if(node==null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			System.out.print(current.data+" ");
			if(current.left!=null) queue.add(current.left);
			if(current.right!=null) queue.add(current.right);
		}
	}
	
	static void searchNode(int value) {
		if(root==null) {
			System.out.println("Empty Tree");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			if(current.data==value) {
				System.out.println(value+" found in Tree!!");
				return;
			}
			if(current.left!=null) queue.add(current.left);
			if(current.right!=null) queue.add(current.right);
		}
		System.out.println(value+" not present in Tree!!");
	}
	
	static void insertNode(int value) {
		if(root==null) {
			System.out.println("Inserted Node");
			root=new Node(value);
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			if(current.left!=null)
				queue.add(current.left);
			else {
				current.left=new Node(value);
				System.out.println("Inserted Node at Left");
				return;
			}
			if(current.right!=null) 
				queue.add(current.right);
			else {
				current.right=new Node(value);
				System.out.println("Inserted Node at Right");
				return;
			}
		}
	}
}
