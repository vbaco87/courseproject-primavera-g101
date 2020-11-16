package com.primavera.CoursProject.persistence;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class TransactionDAO implements com.primavera.CoursProject.application.daos.TransactionDAO {
	private JdbcTemplate jdbcTemplate;
	private int transactionCounter = 4;
	public TransactionDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public String buyBitcoins(String brokerId, int bitcoins, int money) {
		String id = "idpurchase"+ Integer.toString(transactionCounter);
		
		final var query = "INSERT INTO purchases VALUES(?,?,?,?) ";
		jdbcTemplate.update(query,id,money, bitcoins, brokerId);
		return id;
	}
	public void addTransaction(String purchaseId, String brokerId) {
		String id= "idtransaction"+transactionCounter;
		transactionCounter ++;
		Date date = new java.util.Date();
		final var query = "INSERT INTO transactions VALUES(?, ?,?) ";
		jdbcTemplate.update(query,id,date, purchaseId);
	}

}
