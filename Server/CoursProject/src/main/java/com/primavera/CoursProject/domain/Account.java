package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Account {

    private Set<Entry> entry = new HashSet<Entry>();
    private double bitcoinBalance;
    private double euroBalance;
    private double blockedEuros;

    public Account () {

    }

    public Account(Set<Entry> entry, double bitcoinBalance, double euroBalance, double blockedEuros) {
		super();

		this.entry = entry;
		this.bitcoinBalance = bitcoinBalance;
		this.euroBalance = euroBalance;
		this.blockedEuros = blockedEuros;
	}

    public Account(Set<Entry> entry, double bitcoinBalance, double euroBalance) {
  		super();

  		this.entry = entry;
  		this.bitcoinBalance = bitcoinBalance;
  		this.euroBalance = euroBalance;
  	}

	public Set<Entry> getEntry() {
        return entry;
    }

    public void setEntry(Set<Entry> entry) {
        this.entry = entry;
    }

	public double getBitcoinBalance() {
		return bitcoinBalance;
	}

	public void setBitcoinBalance(double bitcoinBalance) {
		this.bitcoinBalance = bitcoinBalance;
	}

	public double getEuroBalance() {
		return euroBalance;
	}

	public void setEuroBalance(double euroBalance) {
		this.euroBalance = euroBalance;
	}

	public double getBlockedEuros() {
		return blockedEuros;
	}

	public void setBlockedEuros(double blockedEuros) {
		this.blockedEuros = blockedEuros;
	}
}
