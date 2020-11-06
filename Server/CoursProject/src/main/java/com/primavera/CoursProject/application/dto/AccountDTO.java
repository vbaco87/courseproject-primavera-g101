package com.primavera.CoursProject.application.dto;

import java.util.HashSet;
import java.util.Set;



public class AccountDTO {
	  private Set<EntryDTO> entry = new HashSet<EntryDTO>();
	  private int id;
	    private double bitcoinBalance;
	    private double euroBalance;
	    private double blockedEuros;
		public AccountDTO() {

		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Set<EntryDTO> getEntry() {
			return entry;
		}
		public void setEntry(Set<EntryDTO> entry) {
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
