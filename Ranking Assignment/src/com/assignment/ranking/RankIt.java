package com.assignment.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RankIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address a1 = new Address("BLR","440088");
		Address a2 = new Address("BLR","240088");
		Address a3 = new Address("DEL","110092");
		Address a4 = new Address("DEL","110031");
		Address a5 = new Address("DEL","110032");
		Address a6 = new Address("MUM","229897");
		Address a7 = new Address("GUJ","887879");
		Address a8 = new Address("RAJ","334567");
		
		List<Address> ad1 = new ArrayList<Address>();
		List<Address> ad2 = new ArrayList<Address>();
		List<Address> ad3 = new ArrayList<Address>();
		List<Address> ad4 = new ArrayList<Address>();
		
		ad1.add(a1);
		ad1.add(a2);
		ad1.add(a3);
		
		ad2.add(a2);
		ad2.add(a6);
		
		ad3.add(a3);
		ad3.add(a7);
		
		ad4.add(a8);
		
		User u1 = new User(1,"Albert",ad1);
		User u2 = new User(1,"Albert",ad2);
		User u3= new User(1,"Albert",ad3);
		User u4= new User(1,"Albert",ad4);
		
		List<User> user = new ArrayList<User>();
		user.add(u1);
		user.add(u2);
		user.add(u3);
		user.add(u4);
		user.stream().forEach(System.out::println);
		System.out.println("----------");
//-----------------------------------------------------------------------------------------------------------------
		
		LinkedHashMap<Address,Integer> addMap = new LinkedHashMap<Address,Integer>();
		
		for(int i=0;i<user.size();i++) {
//			addMap.get(i) = user.get(i).getAdr().stream().collect(Collectors.groupingBy(Address::getZipCode,Collectors.counting()));
			for(int j=0;j<user.get(i).getAdr().size();j++) {
				if(!addMap.containsKey(user.get(i).getAdr().get(j)))
					addMap.put(user.get(i).getAdr().get(j),1);
				else
					addMap.put(user.get(i).getAdr().get(j),addMap.get(user.get(i).getAdr().get(j))+1);
			}
		}
		
		LinkedHashMap<Address,Integer> revMap = new LinkedHashMap<Address,Integer>();
		
		addMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).forEach(x->revMap.put(x.getKey(),x.getValue()));
//		revMap.entrySet().stream().forEach(System.out::println);
		ArrayList<Map.Entry<Address,Integer>> finalArr = new ArrayList<>(revMap.entrySet());
		Collections.sort(finalArr,(a,b)->{
			if(a.getValue()==b.getValue()){
				return a.getKey().getCity().compareTo(b.getKey().getCity());
			}
			return 0;});
		finalArr.stream().forEach(System.out::println);

	}
}

