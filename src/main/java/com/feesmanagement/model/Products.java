package com.feesmanagement.model;

public class Products {
    private int id;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getWalletpoints() {
		return walletpoints;
	}


	public void setWalletpoints(int walletpoints) {
		this.walletpoints = walletpoints;
	}


	private String name;
	
	
	private long price;
	
	
	private String imageUrl;
	
	
	private int walletpoints;

}
