package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.AuctionDAO;
import com.primavera.CoursProject.application.dto.AuctionDTO;

import java.util.List;

import org.springframework.stereotype.Service;

@Service // same as @Component
public class AuctionController {

    public AuctionDAO auction;

    public AuctionController(AuctionDAO auction) {
        this.auction = auction;
    }

	public List<AuctionDTO> getAuctions() {
		return auction.getAuctions();
	}

	public List<AuctionDTO> getActiveAuctions() {
		return auction.getActiveAuctions();
	}

	public List<AuctionDTO> getInactiveAuctions() {
		return auction.getInactiveAuctions(); 
	}

	public List<AuctionDTO> getBidderWonAuctions(String userId) {
		return auction.getWonAuctions(userId);
	}

	public List<AuctionDTO> getBidderAuctions(String userId) {
		return auction.getBidderAuctions(userId);
	}

	public List<AuctionDTO> getBidderActiveAuctions(String userId) {
		return auction.getBidderActiveAuctions(userId);
	}

	public List<AuctionDTO> getBidderInactiveAuctions(String userId) {
		return auction.getBidderInactiveAuctions(userId);
	}
}

