package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.AuctionDAO;
import com.primavera.CoursProject.application.daos.BidDAO;
import com.primavera.CoursProject.application.daos.PurchaseDAO;
import com.primavera.CoursProject.application.daos.UserDAO;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import com.primavera.CoursProject.application.dto.BidDTO;
import com.primavera.CoursProject.application.dto.PurchaseDTO;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // same as @Component
public class UserController {

    public UserDAO user;
    public AuctionDAO auction;
    public BidDAO bid;
    public PurchaseDAO purhcase;

    public UserController(UserDAO user, AuctionDAO auction, BidDAO bid, PurchaseDAO purhcase) {
        this.user = user;
        this.auction = auction;
        this.bid = bid;
        this.purhcase = purhcase;
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

    public List<PurchaseDTO> getAllTransactions(String userId) {
        return purhcase.getAllTransactions(userId);
    }

    public List<PurchaseDTO> getSoldTransactions(String userId) {
        return purhcase.getSoldTransactions(userId);
    }

    public List<PurchaseDTO> getPurchasedTransactions(String userId) {
        return purhcase.getPurchasedTransactions(userId);
    }
}
