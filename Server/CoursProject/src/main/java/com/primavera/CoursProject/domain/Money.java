package com.primavera.CoursProject.domain;

public class Money implements IAsset {
	private int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}
