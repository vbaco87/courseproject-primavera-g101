package com.primavera.CoursProject.application;
import org.springframework.stereotype.Service;

import com.primavera.CoursProject.application.daos.TransactionDAO;

@Service
public class TransactionController {
	public TransactionDAO transactionDAO;
public TransactionController(TransactionDAO transactionDAO) {
	this.transactionDAO = transactionDAO;
}

	public void buyBitcoins(String brokerId, int bitcoins, int price) {	//broker compra
	 String purchaseId = transactionDAO.buyBitcoins(brokerId, bitcoins, price);
	 transactionDAO.addTransaction(purchaseId, brokerId);
	}


}
