package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

public interface AccountDAO {

	public AccountDTO getAccount(int id)throws Exception ;
	public void insertEntry(int id, EntryDTO entry) ;
	public void updateBitcoin(int id, double quantity);
	public void updateEuros(int id, double quantity);


}
