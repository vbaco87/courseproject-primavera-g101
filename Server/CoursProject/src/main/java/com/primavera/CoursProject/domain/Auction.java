package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Auction {
	
	private String id;
	private int total_bitcoins;
	private double price;
	private String opening_date;
	private String close_date;
	Set<Bid> bids = new HashSet<Bid>();
	
	public Auction(String id, int total_bitcoins, double price, String opening_date, String close_date) {
		this.id = id;
		this.total_bitcoins = total_bitcoins;
		this.price = price;
		this.opening_date = opening_date;
		this.close_date = close_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTotal_bitcoins() {
		return total_bitcoins;
	}

	public void setTotal_bitcoins(int total_bitcoins) {
		this.total_bitcoins = total_bitcoins;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(String opening_date) {
		this.opening_date = opening_date;
	}

	public String getClose_date() {
		return close_date;
	}

	public void setClose_date(String close_date) {
		this.close_date = close_date;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

}
