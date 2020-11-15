package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.*;
import com.primavera.CoursProject.application.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // same as @Component
public class UserController {

    public UserDAO user;
    public AuctionDAO auction;
    public BidDAO bid;
    public PurchaseDAO purchase;
    public SoldDAO sold;

    public UserController(UserDAO user, AuctionDAO auction, BidDAO bid, PurchaseDAO purchase, SoldDAO sold) {
        this.user = user;
        this.auction = auction;
        this.bid = bid;
        this.purchase = purchase;
        this.sold = sold;
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

    public List<PurchaseDTO> getAllTransactions(String userId) { //getAllBitcoinsPurchased
        return purchase.getAllTransactions(userId);
    }

    public List<SoldDTO> getSoldTransactions(String userId) {
        return sold.getSoldTransactions(userId);
    }

    public List<PurchaseDTO> getPurchasedTransactions(String userId) {
        return purchase.getPurchasedTransactions(userId);
    }

    public List<PurchaseDTO> getAllPurchaseBitcoins() {
        return purchase.getAllPurchaseBitcoins();
    }

    public List<SoldDTO> getAllSoldBitcoins() {
        return sold.getAllSoldBitcoins();
    }
}
