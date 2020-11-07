package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

public interface AccountDAO {

	public AccountDTO getAvaliableMoney(String userId);
	void updateAccount(String userId, AccountDTO accountDTO);
}
