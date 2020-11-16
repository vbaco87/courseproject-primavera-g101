package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.AccountDAO;
import com.primavera.CoursProject.application.daos.AuctionDAO;
import com.primavera.CoursProject.application.daos.BidDAO;
import com.primavera.CoursProject.application.daos.UserDAO;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import com.primavera.CoursProject.application.dto.BidDTO;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // same as @Component
public class UserController {

    public UserDAO user;
    public AuctionDAO auction;
    public BidDAO bid;
    public AccountDAO account;

    public UserController(UserDAO user, AuctionDAO auction, BidDAO bid, AccountDAO account) {
        this.user = user;
        this.auction = auction;
        this.bid = bid;
        this.account=account;
    }

    public UserDTO getUser(String id) {
        return user.getUser(id);
    }

    public void updateUser(String id, UserDTO user) {
        user.setId(id);
        this.user.updateUser(user);
    }

    public UserDTO createUser(UserDTO user) {
        user.setId(UUID.randomUUID().toString());
        return this.user.createUser(user);
    }
    
    public void addAuction(AuctionDTO auction, String userId) {
    	this.auction.addAuction(auction, userId);
    }
    
    public void addBid(BidDTO bid, String userId, String auctionId) {
    	this.bid.addBid(bid, userId, auctionId);
    }
    
    public List<UserDTO> getBidders(String auctionId){
    	return this.user.getBidders(auctionId);
    }
    
    public List<UserDTO> getWinners(String auctionId){
    	 return this.user.getWinners(auctionId);
    }
    
    public void unlockMoney(List<UserDTO> bidders, String auctionId) throws Exception {
    	Double amount;
    	for (UserDTO bidder : bidders) {
    		String userId= bidder.getId();
    		amount = this.bid.getBidByUserId(userId, auctionId).getAmount();
    		amount = this.account.getAccount(userId).getBlockedEuros() - amount;
    		this.account.updateBlockedEuros(userId, amount);
    	}
    }


}
