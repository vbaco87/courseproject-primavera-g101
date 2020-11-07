package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
import com.primavera.CoursProject.persistence.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class AccountController {
	public AccountDAO accountDAO;

	public AccountController(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}


	   public double getAvaliableMoney(String userId) throws Exception {

	    	AccountDTO account  =accountDAO.getAccount(userId);
	    	return account.getEuroBalance()-account.getBlockedEuros();
	    }
	    public AccountDTO getAccount(String userId) throws Exception {

	    	return accountDAO.getAccount(userId);
	    }

	    public void updateWallet(String accountId , EntryDTO entry) throws Exception {
	        accountDAO.insertEntry(accountId, entry);
	        AccountDTO account = accountDAO.getAccount(accountId);
	        switch (entry.getType().toLowerCase()) {
	            case "bitcoin":
	                accountDAO.updateBitcoin(accountId, account.getBitcoinBalance() + entry.getQuantity());
	                break;
	            case "euros":
	                accountDAO.updateEuros(accountId, account.getEuroBalance() + entry.getQuantity());
	                break;
	        }
	    }
}
