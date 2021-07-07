package com.Shubham;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
	public int id;
	public String city;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(1,"BLR");
		Employee e2 = new Employee(5,"AHM");
		Employee e3 = new Employee(2,"MUM");
		Employee e4 = new Employee(2,"KAR");
		Employee e5 = new Employee(3,"GUJ");
		Employee e6 = new Employee(4,"PUN");
		Employee e7 = new Employee(4,"LAD");
		List list = Arrays.asList(e1,e2,e3,e4,e5,e6,e7);
		Collections.sort(list,new SortbyIDandCity());
		for(Object obj:list) {
			Employee emp = (Employee)obj;
			System.out.println("ID: "+emp.id+"||"+emp.city);
		}
		
		
	}
	public Employee(int id, String city) {
		this.id = id;
		this.city = city;
	}

}
class SortbyIDandCity implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Employee e1 = (Employee)o1;
		Employee e2 = (Employee)o2;
		if(e1.id>e2.id)
			return 1;
		else if(e1.id<e2.id)
			return -1;
		else
			return e1.city.compareTo(e2.city);
	}
	
}
