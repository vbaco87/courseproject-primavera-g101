package com.primavera.CoursProject.domain;

public class Bitcoin implements IAsset {
	private int amount;
	
	public Bitcoin(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
