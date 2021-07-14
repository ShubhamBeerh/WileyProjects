package com.shubham.projectmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	static 	List<ArrayList<Project>> pList = new ArrayList<ArrayList<Project>>();
	static int currentpList =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ArrayList<Project>> projList = createProject();
		List<ArrayList<UserList>> userList = createUser(projList);
		Map<MapKey,MapValue> hash = new LinkedHashMap<MapKey,MapValue>();
		Users u = new Users(userList);
//		System.out.println(u);
//		System.out.println("----------------------");
		List<UserList> us=u.myUsers.stream().flatMap(list->list.stream()).collect(Collectors.toList());
//		System.out.println(us);
		us.stream().forEach(x->x.list.stream()
				.forEach(y->
						{
							MapKey mapKey=new MapKey();
							mapKey.id=x.id;
							mapKey.name=x.name;
							mapKey.projID=y.projID;
							MapValue mapVal = new MapValue();
							mapVal.projID=y.projID;
							mapVal.projName=y.projName;
							hash.put(mapKey, mapVal);
//							System.out.println(x.id+"-"+x.name+"-"+y.projID+"-"+y.projName);
//							System.out.println(mapKey+"-----"+mapVal);
						}
					)
				);
		for(Map.Entry<MapKey,MapValue> map: hash.entrySet()) {
			System.out.println(map.getKey()+"  ::  "+map.getValue());
		}
	}

//--------------------------------------------------------------------------------------------------------------------
	public static List<ArrayList<Project>> createProject() {
		List<ArrayList<Project>> projList = new ArrayList<ArrayList<Project>>();
		Project p1 = new Project(1,"Proj1");
		Project p2 = new Project(2,"Proj2");
		Project p3 = new Project(3,"Proj3");
		ArrayList<Project> pl1= new ArrayList<Project>();
		pl1.add(p1);
		pl1.add(p2);
		ArrayList<Project> pl2= new ArrayList<Project>();
		pl2.add(p2);
		pl2.add(p3);
		ArrayList<Project> pl3= new ArrayList<Project>();
		pl3.add(p1);
		pl3.add(p3);
		projList.add(pl1);
		projList.add(pl2);
		projList.add(pl3);
		return projList;
	}
	
	public static List<ArrayList<UserList>> createUser(List<ArrayList<Project>> projList){
		List<ArrayList<UserList>> userList = new ArrayList<ArrayList<UserList>>();
		UserList u1 = new UserList(1,"User1",projList.get(0));
		UserList u2 = new UserList(2,"User2",projList.get(1));
		UserList u3 = new UserList(3,"User3",projList.get(2));
		ArrayList<UserList> ul1 = new ArrayList<UserList>();
		ul1.add(u1);
		ul1.add(u2);
		ul1.add(u3);
		ArrayList<UserList> ul2 = new ArrayList<UserList>();
		ul2.add(u1);
		ul2.add(u2);
		userList.add(ul1);
		userList.add(ul2);
		return userList;
	}
//--------------------------------------------------------------------------------------------------------------------


}

