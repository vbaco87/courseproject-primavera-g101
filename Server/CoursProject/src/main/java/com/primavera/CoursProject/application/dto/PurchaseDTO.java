package com.primavera.CoursProject.application.dto;

import com.primavera.CoursProject.domain.Transaction;

public class PurchaseDTO {

    private double amount;
    private String id;
    private double price;
    private Transaction transactionBroker;
    //private Transaction transactionPlatform;

    public PurchaseDTO() {
    }

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Transaction getTransactionBroker() {
        return transactionBroker;
    }

//    public Transaction getTransactionPlatform() {
//        return transactionPlatform;
//    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTransactionBroker(Transaction transactionBroker) {
        this.transactionBroker = transactionBroker;
    }

//    public void setTransactionPlatform(Transaction transactionPlatform) {
//        this.transactionPlatform = transactionPlatform;
//    }

}
