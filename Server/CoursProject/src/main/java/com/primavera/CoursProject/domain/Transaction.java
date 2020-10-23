package com.primavera.CoursProject.domain;

public class Transaction {
	
	private String date;
	private Entry entryMoney;
	private Entry entryBitcoin;

	public Transaction(String date) {
		super();
		this.date = date;
	}

	public Transaction() {

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
