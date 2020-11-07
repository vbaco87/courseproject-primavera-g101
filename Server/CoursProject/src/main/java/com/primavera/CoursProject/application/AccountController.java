package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
import com.primavera.CoursProject.persistence.AccountDAO;

public class AccountController {
	public AccountDAO account;
	

	    public AccountController(AccountDAO account) {
	        this.account = account;
	    }
	public AccountDTO getAvaliableMoney(String userId) {
		return account.getAvaliableMoney(userId);
	}

	public void updateAccount(String userId, EntryDTO entry) {
		AccountDTO updatedAccount = new AccountDTO().update(entry);
		account.updateAccount(userId, updatedAccount);
		
	}
}
