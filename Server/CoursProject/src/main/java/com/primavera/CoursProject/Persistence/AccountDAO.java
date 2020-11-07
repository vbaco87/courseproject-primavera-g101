package com.primavera.CoursProject.Persistence;

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
		account.setId(resultSet.getInt("id"));
		account.setBitcoinBalance(resultSet.getDouble("bitcoin"));
		account.setEuroBalance(resultSet.getDouble("eurosTotal"));
		account.setBlockedEuros(resultSet.getDouble("eurosLocked"));

		return account;
	};
	private final RowMapper<EntryDTO> entryRowMapper = (resultSet, i) -> {
		EntryDTO entry = new EntryDTO();
		
		entry.setQuantity(resultSet.getDouble("quantity"));
		entry.setType(resultSet.getString("type"));


		return entry;
	};
	
	public AccountDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public AccountDTO getAccount(int id) throws Exception {

		final var query = "select * from account where id = ?";
		try {
			return jdbcTemplate.queryForObject(query, accountRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception(e);
		}

	}	
	public void insertEntry(int id, EntryDTO entry)  {

		final var query = "INSERT INTO entry (quantity, type, account_id) VALUES (?,?,?)";

			 jdbcTemplate.update(query,entry.getQuantity(),entry.getType() , id);
		

	}

	public void updateBitcoin(int id, double quantity){
		final var query = "UPDATE account SET bitcoin =? WHERE id=?";

		 jdbcTemplate.update(query,quantity , id);
	}
	public void updateEuros(int id, double quantity){
		final var query = "UPDATE account SET eurosTotal =? WHERE id=?";

		 jdbcTemplate.update(query,quantity , id);
	}
}
