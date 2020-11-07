package com.primavera.CoursProject.domain;

import java.util.UUID;

public class Bid {
	
	private String id;
	private double bitcoins;
	private double amount;
	private Transaction transactionBroker;//le da dinero al broker
	private Transaction transactionPlatform;//la comision para la plataforma
	private Transaction transactionBidder;//le quita dinero al bidder

	//redefinir equals
	public Bid() {

	}

	public Bid(String id, double bitcoins, double amount) {
		this.id = UUID.randomUUID().toString();
		this.bitcoins = bitcoins;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBitcoins() {
		return bitcoins;
	}

	public void setBitcoins(double bitcoins) {
		this.bitcoins = bitcoins;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public Transaction getTransactionBidder() {
		return transactionBidder;
	}

	public void setTransactionBidder(Transaction transactionBidder) {
		this.transactionBidder = transactionBidder;
	}
}
