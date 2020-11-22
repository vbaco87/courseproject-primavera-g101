package com.primavera.CoursProject.application.daos;

import java.util.List;

import com.primavera.CoursProject.application.dto.BidDTO;

public interface BidDAO {

    public void addBid(BidDTO bid, String userId, String auctionId);
    public BidDTO getBid(String bidId) throws Exception;
    public List<BidDTO> getUserBids(String userId) throws Exception;
    public BidDTO getBidByUserId(String userId, String auctionId) throws Exception;
    public List<BidDTO> getWinners(String auctionId);
}
