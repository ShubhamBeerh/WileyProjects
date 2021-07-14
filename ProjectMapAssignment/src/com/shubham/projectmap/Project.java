package com.shubham.projectmap;

public class Project {
	public int projID;
	public String projName;
	
	public Project(int projID, String projName) {
		this.projID = projID;
		this.projName = projName;
	}
	
	@Override
	public String toString() {
		return "{projID: " + projID + ", projName: " + projName + "}";
	}
}
