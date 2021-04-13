package com.primavera.CoursProject.application.daos;

public interface TransactionDAO {
	public String buyBitcoins(String brokerId, double bitcoins, double money);
	public void addTransaction(String purchaseId, String brokerId);
}
