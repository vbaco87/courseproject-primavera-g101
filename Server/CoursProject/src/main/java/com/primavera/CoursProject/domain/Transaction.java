package com.primavera.CoursProject.domain;

public class Transaction {
	
	private String date;
	//private Entry entry;

	public Transaction(String date) {
		super();
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
