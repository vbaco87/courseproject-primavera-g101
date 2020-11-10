package com.primavera.CoursProject.domain;

public class Purchase {
	
	private double amount;
	private String id;
	private double price;
	private Transaction transactionBroker;
	private Transaction transactionPlatform;
	
	public Purchase(double amount, String id, double price, Transaction transactionBroker, Transaction transactionPlatform) {
		this.amount = amount;
		this.id = id;
		this.price = price;
		this.transactionBroker = transactionBroker;
		this.transactionPlatform = transactionPlatform;
	}

	public Purchase() {

	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Transaction getTransactionBroker() {
		return transactionBroker;
	}

	public void setTransactionBroker(Transaction transactionBroker) {
		this.transactionBroker = transactionBroker;
	}

	public Transaction getTransactionPlatform() {
		return transactionPlatform;
	}

	public void setTransactionPlatform(Transaction transactionPlatform) {
		this.transactionPlatform = transactionPlatform;
	}

}
