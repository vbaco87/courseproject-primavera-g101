package com.primavera.CoursProject.application.dto;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import com.primavera.CoursProject.domain.Bid;

public class AuctionDTO {
	
	private String id;
	private double totalBitcoins;
	private double price;
	private Date openingDate;
	private Date closeDate;
	Set<Bid> bids = new HashSet<Bid>();
	
	public AuctionDTO() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public double getTotalBitcoins() {
		return totalBitcoins;
	}

	public void setTotalBitcoins(double totalBitcoins) {
		this.totalBitcoins = totalBitcoins;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
	
}

