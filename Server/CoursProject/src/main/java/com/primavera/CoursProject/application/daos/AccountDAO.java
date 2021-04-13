package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

public interface AccountDAO {

	public AccountDTO getAccount(String userId)throws Exception ;

	public void updateBitcoin(String userId, double quantity) throws Exception;

	public void updateEuro(String userId, double quantity);
  
    public void updateBlockedEuros(String userId, double quantity) throws Exception;
  
}



