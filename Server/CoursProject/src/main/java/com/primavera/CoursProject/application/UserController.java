package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.AccountDAO;
import com.primavera.CoursProject.application.daos.AuctionDAO;
import com.primavera.CoursProject.application.daos.BidDAO;
import com.primavera.CoursProject.application.daos.EntryDAO;
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
    public EntryDAO entry;
    
    public UserController(UserDAO user, AuctionDAO auction, BidDAO bid, AccountDAO account, EntryDAO entry) {
        this.user = user;
        this.auction = auction;
        this.bid = bid;
        this.account = account;
        this.entry = entry;
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

	public void updateBitcoin(String userId, double quantity) {
		account.updateBitcoin(userId, quantity);
		entry.addEntry(userId, quantity, "BTC");
	}

	public void updateMoney(String userId, double quantity) {
		account.updateEuro(userId, quantity);
		entry.addEntry(userId, quantity, "EUR");
	}


}
