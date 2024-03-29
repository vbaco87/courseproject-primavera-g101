package com.primavera.CoursProject.persistence;

import java.util.Date;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.primavera.CoursProject.application.exceptions.UserDoesNotExistException;
@Repository
public class TransactionDAO implements com.primavera.CoursProject.application.daos.TransactionDAO {
	private JdbcTemplate jdbcTemplate;
	//private int transactionCounter = 4;
	public TransactionDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public String buyBitcoins(String brokerId, double bitcoins, double money) {
		String id =UUID.randomUUID().toString();
		
		final var query = "INSERT INTO purchases VALUES(?,?,?,?) ";
		try {
		jdbcTemplate.update(query,id, bitcoins,money, brokerId);
		return id;
		}
		catch( EmptyResultDataAccessException e) {
			throw new UserDoesNotExistException(brokerId);
		}
	}
	public void addTransaction(String purchaseId, String brokerId) {
		String id= UUID.randomUUID().toString();
		Date date = new Date();
		final var query = "INSERT INTO transactions VALUES(?, ?,?,null) ";
		jdbcTemplate.update(query,id,date, purchaseId);
	}

	public void addTransactionBid(String bidId, String bidderId) {

	}

}
