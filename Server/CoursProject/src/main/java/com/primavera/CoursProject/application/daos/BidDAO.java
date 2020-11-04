package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.BidDTO;

public interface BidDAO {

    public void addBid(BidDTO bid, String userId, String auctionId);

}
