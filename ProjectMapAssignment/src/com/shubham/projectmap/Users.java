package com.shubham.projectmap;

import java.util.ArrayList;
import java.util.List;

public class Users {
	public List<ArrayList<UserList>> myUsers;
	
	public Users(List<ArrayList<UserList>> myUsers) {
		this.myUsers = myUsers;
	}

	@Override
	public String toString() {
		return "Users= "+myUsers;
	}
	
}