package com.primavera.CoursProject.domain;

public class Purchase {
	
	private double amount;
	private String id;
	private double price; //este no está en la bbdd pero creo que es enecesario(?)
	private Transaction transactionBroker;//le quita dinero al broker
	private Transaction transactionPlatform;//la comision para la plataforma
	
	public Purchase(double amount, String id, double price, Transaction transactionBroker, Transaction transactionPlatform) {
		this.amount = amount;
		this.id = id;
		this.price = price;
		this.transactionBroker = transactionBroker;
		this.transactionPlatform = transactionPlatform;
	}

	//redefinir equals
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
