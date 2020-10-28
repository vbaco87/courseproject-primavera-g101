package com.primavera.CoursProject.domain;

import java.util.HashSet;
import java.util.Set;

public class Account {
    private Set<Entry> entry = new HashSet<Entry>();
    private int bitcoinBalance;
    private int euroBalance;
    private int blockedEuros;
    public Account () {

    }

    
    public Account(Set<Entry> entry, int bitcoinBalance, int euroBalance, int blockedEuros) {
		super();
		this.entry = entry;
		this.bitcoinBalance = bitcoinBalance;
		this.euroBalance = euroBalance;
		this.blockedEuros = blockedEuros;
	}
    
    public Account(Set<Entry> entry, int bitcoinBalance, int euroBalance) {
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

	public int getBitcoinBalance() {
		return bitcoinBalance;
	}


	public void setBitcoinBalance(int bitcoinBalance) {
		this.bitcoinBalance = bitcoinBalance;
	}


	public int getEuroBalance() {
		return euroBalance;
	}


	public void setEuroBalance(int euroBalance) {
		this.euroBalance = euroBalance;
	}


	public int getBlockedEuros() {
		return blockedEuros;
	}


	public void setBlockedEuros(int blockedEuros) {
		this.blockedEuros = blockedEuros;
	}
    
}
