package com.shubham.projectmap;

public class MapValue {
	int projID;
	String projName;
	public int getProjID() {
		return projID;
	}
	public void setProjID(int projID) {
		this.projID = projID;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	@Override
	public String toString() {
		return "MapValue:{projID:" + projID + ", projName:" + projName + "}";
	}
	
}
