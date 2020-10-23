package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Account {
    private Set<Entry> entry = new HashSet<Entry>();
    private int balance;

    public Account () {

    }

    public Account(Set<Entry> entry, int balance) {
        this.entry = entry;
        this.balance = balance;
    }

    public Set<Entry> getEntry() {
        return entry;
    }

    public int getBalance() {
        return balance;
    }

    public void setEntry(Set<Entry> entry) {
        this.entry = entry;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
