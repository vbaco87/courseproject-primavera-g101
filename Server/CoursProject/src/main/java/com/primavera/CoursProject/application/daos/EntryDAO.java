package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.EntryDTO;

public interface EntryDAO {

	public void insertEntry(String accountId, EntryDTO entry) ;
	public void addEntry(String accountId, String currency, double quantity);

}
