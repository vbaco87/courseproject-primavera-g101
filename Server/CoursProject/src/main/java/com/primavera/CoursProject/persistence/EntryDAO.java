package com.primavera.CoursProject.persistence;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

@Repository

public class EntryDAO implements com.primavera.CoursProject.application.daos.EntryDAO{



	private JdbcTemplate jdbcTemplate;

	

	public EntryDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void insertEntry(String id, EntryDTO entry)  {

		final var query = "INSERT INTO entries (quantity, type, account_id) VALUES (?,?,?)";
		
			 jdbcTemplate.update(query,entry.getQuantity(),entry.getType() , id);
		

	}
  


	@Override
	public void addEntry(String accountId, String currency, double quantity) {
		final var query = "INSERT INTO entries (quantity, type, account_id) VALUES (?,?,?)";
		 jdbcTemplate.update(query,currency, quantity , accountId);
	}







}