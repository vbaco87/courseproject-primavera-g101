package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.AuctionDTO;

public interface AuctionDAO {

	public void addAuction(AuctionDTO auction, String userId);
	
}


