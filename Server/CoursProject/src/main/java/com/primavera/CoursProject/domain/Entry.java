package com.primavera.CoursProject.domain;

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

public class Entry {

    private int quantity;
    Set<Assert> asserts = new HashSet<Assert>();

    public Entry() {

    }

    public Entry(int quantity, Set<Assert> asserts) {
        this.quantity = quantity;
        this.asserts = asserts;
    }

    public Set<Assert> getAsserts() {
        return asserts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAsserts(Set<Assert> asserts) {
        this.asserts = asserts;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
