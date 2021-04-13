package com.primavera.CoursProject.application.exceptions;

public class AuctionDoesNotExistException extends RuntimeException {
    public AuctionDoesNotExistException (String auctionId){
        super("Auction" + auctionId + " doesn't exist");
    }
}
