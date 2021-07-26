package com.shubham.binarytree;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Node root=createTree();
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
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
}
