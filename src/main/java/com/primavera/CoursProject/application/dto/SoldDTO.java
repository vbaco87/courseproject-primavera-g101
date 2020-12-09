package com.primavera.CoursProject.application.dto;

import java.util.Date;

public class SoldDTO {
    private double amount;
    private String id;
    private double price;
    private Date closingDate;

    public SoldDTO() {
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

    public Date getClosingDate() {
        return closingDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    @Override
    public String toString() {
        return "SoldDTO{" +
                "amount=" + amount +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", CLOSING_DATE=" + closingDate +
                '}';
    }
}
