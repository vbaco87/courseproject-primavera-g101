package com.primavera.CoursProject.persistence;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
import com.primavera.CoursProject.application.exceptions.UserDoesNotExistException;

public class AccountDAO implements com.primavera.CoursProject.application.daos.AccountDAO {

	private JdbcTemplate jdbcTemplate;
	
	 private final RowMapper<AccountDTO> userRowMapper = (resultSet, i) -> {
	        AccountDTO account = new AccountDTO();

	        account.setBitcoinBalance(resultSet.getDouble("bitcoin_balance"));
	        account.setBlockedEuros(resultSet.getDouble("blocked_euros"));
	        account.setEuroBalance(resultSet.getDouble("euro_balance"));

	        return account;
	    };

	    public AccountDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    
	@Override
	public AccountDTO getAvaliableMoney(String userId) {
		final String queryUser = "SELECT bitcoin_balance,blocked_euros,euro_balance FROM accounts WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(queryUser, userRowMapper, userId);
        }
        catch (EmptyResultDataAccessException e){
            throw new UserDoesNotExistException(userId);
        }
	}

	@Override
	public void updateAccount(String userId, AccountDTO accountDTO) {
		
		final String queryUpdateUser= "update accountDTO set bitcoin_balance = ?,blocked_euros = ?,euro_balance = ? where id = ?";
        jdbcTemplate.update(queryUpdateUser, accountDTO.getBitcoinBalance(), accountDTO.getBlockedEuros(), accountDTO.getEuroBalance(), userId);
   
		
	}


}
