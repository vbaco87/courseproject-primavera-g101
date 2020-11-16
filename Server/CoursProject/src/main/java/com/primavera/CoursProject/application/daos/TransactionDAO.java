package com.primavera.CoursProject.application.daos;

public interface TransactionDAO {
	public String buyBitcoins(String brokerId, int bitcoins, int money);
	public void addTransaction(String purchaseId, String brokerId);
}
