package com.primavera.CoursProject.persistence;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
import com.primavera.CoursProject.application.exceptions.UserDoesNotExistException;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO implements com.primavera.CoursProject.application.daos.AccountDAO {

	private JdbcTemplate jdbcTemplate;

	private final RowMapper<AccountDTO> accountRowMapper = (resultSet, i) -> {
		AccountDTO account = new AccountDTO();
		account.setBitcoinBalance(resultSet.getDouble("bitcoin_balance"));
		account.setBlockedEuros(resultSet.getDouble("blocked_euros"));
		account.setEuroBalance(resultSet.getDouble("euro_balance"));
		return account;
	};

	public AccountDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public AccountDTO getAvaliableMoney(String userId) {
		final String queryUser = "SELECT bitcoin_balance,blocked_euros,euro_balance FROM accounts WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(queryUser, accountRowMapper, userId);
        }
        catch (EmptyResultDataAccessException e){
            throw new UserDoesNotExistException(userId);
        }
	}

	public void updateAccount(String userId, AccountDTO accountDTO) {
		final String queryUpdateUser= "update accountDTO set bitcoin_balance = ?,blocked_euros = ?,euro_balance = ? where id = ?";
        jdbcTemplate.update(queryUpdateUser, accountDTO.getBitcoinBalance(), accountDTO.getBlockedEuros(), accountDTO.getEuroBalance(), userId);
	}


	public AccountDTO getAccount(int id) throws Exception {
		final var query = "select * from account where id = ?";
		try {
			return jdbcTemplate.queryForObject(query, accountRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception(e); }

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
