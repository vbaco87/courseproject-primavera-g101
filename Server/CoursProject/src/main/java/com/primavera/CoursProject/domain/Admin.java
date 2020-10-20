package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Admin extends AbsUser {

    Set<Bid> bids = new HashSet<Bid>();

    public Admin() {

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
}
