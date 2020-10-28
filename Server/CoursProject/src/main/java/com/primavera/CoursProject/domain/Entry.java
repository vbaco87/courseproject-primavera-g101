package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Entry {

    private int quantity;
    Set<IAsset> asserts = new HashSet<IAsset>();

    public Entry() {

    }

    public Entry(int quantity, Set<IAsset> asserts) {
        this.quantity = quantity;
        this.asserts = asserts;
    }

    public Set<IAsset> getAsserts() {
        return asserts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAsserts(Set<IAsset> asserts) {
        this.asserts = asserts;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
