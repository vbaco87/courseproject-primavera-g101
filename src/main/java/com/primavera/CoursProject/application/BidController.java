package com.primavera.CoursProject.application;


import com.primavera.CoursProject.application.daos.BidDAO;
import com.primavera.CoursProject.application.dto.BidDTO;

import java.util.List;

import org.springframework.stereotype.Service;

@Service // same as @Component
public class BidController {

    public BidDAO bid;

    public BidController(BidDAO bid) {
        this.bid = bid;
    }


	public BidDTO getBid(String bidId) throws Exception {
		return bid.getBid(bidId);
	}


}

