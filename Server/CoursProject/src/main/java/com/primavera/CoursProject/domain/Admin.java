package com.primavera.CoursProject.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Admin extends AbsUser {

    Set<Bid> bids = new HashSet<Bid>();
    Set<Auction> auctions = new HashSet<Auction>();
    Set<Purchase> purchases = new HashSet<Purchase>();


    public Admin() {

    }

    public Admin(String id, String name, String secondName, String email, String password, String phoneNumber, Date birthday, String country, String city, String homeAddress) {
        super(id, name, secondName, email, password, phoneNumber, birthday, country, city, homeAddress);
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public boolean addBid(Bid bid){
        return bids.add(bid);
    }

    public boolean remBid(Bid bid){
        return false;
    }

    public void remAllBids(Set<Bid> bids){
        bids.removeAll(bids);
    }
    
    public Set<Auction> getAuction() {
        return auctions;
    }

    public boolean addAuction(Auction auction){
        return auctions.add(auction);
    }

    public boolean remAuction(Auction auctions){
        return false;
    }

    public void remAllAuction(Set<Purchase> auctionsToRemove){
        auctions.removeAll(auctionsToRemove);
    }

    public Set<Purchase> getPurchase() {
        return purchases;
    }

    public boolean addPurchase(Purchase purchase){
        return purchases.add(purchase);
    }

    public boolean remPurchase(Purchase purchases){
        return false;
    }

    public void remAllPurchase(Set<Purchase> purchasesToRemove){
        auctions.removeAll(purchasesToRemove);
    }

}
