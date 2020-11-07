package com.primavera.CoursProject.application.dto;

import java.util.HashSet;
import java.util.Set;

import com.primavera.CoursProject.domain.Entry;

public class AccountDTO {
	private Set<Entry> entry = new HashSet<Entry>();
    private double bitcoinBalance;
    private double  euroBalance;
    private double blockedEuros;
    public AccountDTO () {

    }

    
    public AccountDTO(Set<Entry> entry, double bitcoinBalance, double euroBalance, double blockedEuros) {
		this.entry = entry;
		this.bitcoinBalance = bitcoinBalance;
		this.euroBalance = euroBalance;
		this.blockedEuros = blockedEuros;
	}
    
    public AccountDTO(Set<Entry> entry, double bitcoinBalance, double euroBalance) {
  		this.entry = entry;
  		this.bitcoinBalance = bitcoinBalance;
  		this.euroBalance = euroBalance;
  	}
    
    public AccountDTO(double bitcoinBalance, double euroBalance) {
  		this.entry = null;
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


	public AccountDTO update(EntryDTO entry2) {
		
		return this;
	}
	    
}
