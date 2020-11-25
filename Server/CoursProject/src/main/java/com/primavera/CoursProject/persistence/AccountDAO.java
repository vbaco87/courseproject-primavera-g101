package com.primavera.CoursProject.persistence;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.exceptions.UnblockMoneyException;


@Repository
public class AccountDAO implements com.primavera.CoursProject.application.daos.AccountDAO {
	private JdbcTemplate jdbcTemplate;

	private final RowMapper<AccountDTO> accountRowMapper = (resultSet, i) -> {
		AccountDTO account = new AccountDTO();
		account.setBitcoinBalance(resultSet.getDouble("bitcoin_balance"));
		account.setEuroBalance(resultSet.getDouble("euro_balance"));
		account.setBlockedEuros(resultSet.getDouble("blocked_euros"));

		return account;
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

	public void updateBitcoin(String userId, double quantity){
		final var query = "UPDATE accounts SET bitcoin_balance =  ? WHERE user_id=?";
		 jdbcTemplate.update(query,quantity , userId);
	}
	
	public void updateEuro(String userId, double quantity){
		final var query = "UPDATE accounts SET euro_balance = euro_balance + ? WHERE user_id=?";

		 jdbcTemplate.update(query,quantity , userId);
	}

	public void updateAccount(String userId, AccountDTO updatedAccount) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateBlockedEuros(String userId, double quantity)  throws Exception {
		AccountDTO account;
		
			account = getAccount(userId);
			if ( (quantity+account.getBlockedEuros())<0)
				throw new UnblockMoneyException(userId);
	

		
		final var query = "UPDATE accounts SET blocked_euros =? WHERE user_id=?";

		 jdbcTemplate.update(query,quantity+account.getBlockedEuros() , userId);
	}
}