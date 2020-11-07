package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.AuctionDAO;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import org.springframework.stereotype.Service;

@Service // same as @Component
public class AuctionController {

    public AuctionDAO auction;

    public AuctionController(AuctionDAO auction) {
        this.auction = auction;
    }

    public void addAuction(AuctionDTO auction, String userId) {
    	this.auction.addAuction(auction, userId);
    }
}

