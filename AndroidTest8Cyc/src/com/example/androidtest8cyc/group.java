package com.example.androidtest8cyc;

import java.util.ArrayList;

import android.R.integer;

public class group {
	private int imggeId;
	private String name;
	private ArrayList<Child> aChilds;
	public group(int imggeId, String name, ArrayList<Child> aChilds) {
		super();
		this.imggeId = imggeId;
		this.name = name;
		
		//==========зЂвт==============
		this.aChilds =new ArrayList<Child>(aChilds);
	}
	public int getImggeId() {
		return imggeId;
	}
	public void setImggeId(int imggeId) {
		this.imggeId = imggeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Child> getaChilds() {
		return aChilds;
	}
	public void setaChilds(ArrayList<Child> aChilds) {
		this.aChilds = new ArrayList<Child>(aChilds);	
	} 
	
	
}
