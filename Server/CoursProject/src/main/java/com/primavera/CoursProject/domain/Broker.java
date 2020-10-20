package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Broker extends AbsUser {

    Set<Auction> auctions = new HashSet<Auction>();
    Set<Purchase> purchases = new HashSet<Purchase>();

    public Broker() {

    }

    public Set<Auction> getAuction() {
        return auctions;
    }

    public boolean addAuction(Auction auctions){
        return auctions.add(bid);
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
        auctions.removeAll(purchasesoRemove);
    }

}
