package com.example.androidtest6cyc;

public class Goods {
	private int imageId;
	private int newPrice;
	private int oldPrice;
	public Goods(int imageId, int newPrice, int oldPrice) {
		super();
		this.imageId = imageId;
		this.newPrice = newPrice;
		this.oldPrice = oldPrice;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}
	public int getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
	}
	
	
}
