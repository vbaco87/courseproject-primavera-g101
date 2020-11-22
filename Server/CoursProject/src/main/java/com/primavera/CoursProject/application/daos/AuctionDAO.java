package com.primavera.CoursProject.application.daos;

import java.util.List;

import com.primavera.CoursProject.application.dto.AuctionDTO;

public interface AuctionDAO {

	public void addAuction(AuctionDTO auction, String userId);

	public List<AuctionDTO> getAuctions();

	public List<AuctionDTO> getActiveAuctions();

	public List<AuctionDTO> getInactiveAuctions();

	public List<AuctionDTO> getWonAuctions(String userId);

	public List<AuctionDTO> getBidderAuctions(String userId);

	public List<AuctionDTO> getBidderActiveAuctions(String userId);

	public List<AuctionDTO> getBidderInactiveAuctions(String userId);
	
	public List<AuctionDTO> getNewFinishedAuctions();

    public void setActiveState(AuctionDTO a);
}


