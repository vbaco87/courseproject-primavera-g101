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

	public void setActiveState(AuctionDTO a){
		auction.setActiveState(a);
	}
}

