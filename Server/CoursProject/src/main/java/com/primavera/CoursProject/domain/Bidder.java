package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Bidder extends AbsUser{

    Set<Bid> bids = new HashSet<Bid>();

    public Bidder() {

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

    public void remAllBids(Set<Bid> bidsToRemove){
        bids.removeAll(bidsToRemove);
    }

}
