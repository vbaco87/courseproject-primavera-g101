package com.primavera.CoursProject.application.dto;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import com.primavera.CoursProject.domain.Bid;

public class AuctionDTO {
	
	private String id;
	
	@Range(min=0)
	@NotNull(message = "TotalBitcoins cannot be null")
	private double totalBitcoins;
	
	@Range(min=0)
	@NotNull(message = "Price cannot be null")
	private double price;
	
	@NotNull(message = "OpeningDate cannot be null")
	private Date openingDate;
		
	@NotNull(message = "CloseDate cannot be null")
	private Date closeDate;

	private String creatorId;
	
	@Range(min=0, max=1)
	private int active;

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorId() {
		return creatorId;
	}

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

	public int isActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "AuctionDTO{" +
				"id='" + id + '\'' +
				", totalBitcoins=" + totalBitcoins +
				", price=" + price +
				", openingDate=" + openingDate +
				", closeDate=" + closeDate +
				", creatorId='" + creatorId + '\'' +
				", bids=" + bids +
				'}';
	}
}

