package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.BidDAO;
import com.primavera.CoursProject.application.dto.BidDTO;
import org.springframework.stereotype.Service;

@Service // same as @Component
public class BidController {

    public BidDAO bid;

    public BidController(BidDAO bid) {
        this.bid = bid;
    }

    public void addBid(BidDTO bid, String userId, String auctionId) {
    	this.bid.addBid(bid, userId, auctionId);
    }
}

