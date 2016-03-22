package com.example.androidtest8cyc;

import android.R.integer;

public class Child {
	private int imageId;
	private String name;
	public Child(int imageId, String name) {
		super();
		this.imageId = imageId;
		this.name = name;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
