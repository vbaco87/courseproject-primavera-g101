package com.primavera.CoursProject.application.dto;

import java.util.UUID;

import com.primavera.CoursProject.domain.Transaction;

public class BidDTO {
	
	private String id;
	private double bitcoins;
	private double amount;
	private Transaction transactionBroker;
	private Transaction transactionPlatform;
	private Transaction transactionBidder;

	public BidDTO() {
		this.id = UUID.randomUUID().toString();
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
