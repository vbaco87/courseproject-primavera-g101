package com.primavera.CoursProject.application;

import org.springframework.stereotype.Component;

import com.primavera.CoursProject.application.daos.AccountDAO;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
@Component
public class UserController {
	
	private AccountDAO accountDAO;

	public UserController(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
    public double getAvaliableMoney(int userId) throws Exception {

    	AccountDTO account  =accountDAO.getAccount(userId);
    	return account.getEuroBalance()-account.getBlockedEuros();
    }
    public AccountDTO getAccount(int userId) throws Exception {

    	return accountDAO.getAccount(userId);
    }

    public void updateWallet(int accountId , EntryDTO entry) throws Exception {
    	accountDAO.insertEntry(accountId, entry);
    	AccountDTO account = accountDAO.getAccount(accountId);
    	switch(entry.getType().toLowerCase()){
    		case "bitcoin": accountDAO.updateBitcoin(accountId, account.getBitcoinBalance()+entry.getQuantity()); break;
    		case "euros": accountDAO.updateEuros(accountId,account.getEuroBalance()+ entry.getQuantity()); break;
    	}
    }

}
