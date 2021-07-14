package com.shubham.projectmap;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	public int id;
	String name;
	ArrayList<Project> list;
	
	public UserList(int id, String name, ArrayList<Project> list) {
		this.id = id;
		this.name = name;
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "\n {id: " + id + ", name: " + name + ", projects: " + list + "} \n";
	}
	
} 
