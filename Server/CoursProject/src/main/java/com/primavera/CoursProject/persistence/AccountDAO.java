package com.primavera.CoursProject.persistence;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

@Repository
public class AccountDAO implements com.primavera.CoursProject.application.daos.AccountDAO {
	private JdbcTemplate jdbcTemplate;

	private final RowMapper<AccountDTO> accountRowMapper = (resultSet, i) -> {
		AccountDTO account = new AccountDTO();
		account.setBitcoinBalance(resultSet.getDouble("bitcoin"));
		account.setEuroBalance(resultSet.getDouble("eurosTotal"));
		account.setBlockedEuros(resultSet.getDouble("eurosLocked"));

		return account;
	};
	//pasar a entryDAO
	private final RowMapper<EntryDTO> entryRowMapper = (resultSet, i) -> {
		EntryDTO entry = new EntryDTO();
		
		entry.setQuantity(resultSet.getDouble("quantity"));
		entry.setType(resultSet.getString("type"));


		return entry;
	};
	
	public AccountDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public AccountDTO getAccount(String userId) throws Exception {

		final var query = "select * from accounts where user_id = ?";
		try {
			return jdbcTemplate.queryForObject(query, accountRowMapper, userId);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception(e);
		}

	}
	
	//entryDAO
	public void insertEntry(String id, EntryDTO entry)  {

		final var query = "INSERT INTO entries (quantity, type, account_id) VALUES (?,?,?)";
		
			 jdbcTemplate.update(query,entry.getQuantity(),entry.getType() , id);
		

	}

	public void updateBitcoin(String userId, double quantity){
		final var query = "UPDATE accounts SET bitcoin =? WHERE user_id=?";

		 jdbcTemplate.update(query,quantity , userId);
	}
	
	public void updateEuros(String userId, double quantity){
		final var query = "UPDATE accounts SET eurosTotal =? WHERE user_id=?";

		 jdbcTemplate.update(query,quantity , userId);
	}


}
