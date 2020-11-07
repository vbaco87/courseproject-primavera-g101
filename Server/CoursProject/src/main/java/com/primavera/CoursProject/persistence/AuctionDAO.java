package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.AuctionDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AuctionDAO implements com.primavera.CoursProject.application.daos.AuctionDAO {
	
    private JdbcTemplate jdbcTemplate;

    /*
    private final RowMapper<AuctionDTO> bidRowMapper = (resultSet, i) -> {
        AuctionDTO auction = new AuctionDTO();

        auction.setId(resultSet.getString("id"));
        auction.setTotalBitcoins(resultSet.getDouble("bitcoins"));
        auction.setPrice(resultSet.getDouble("price"));

        return auction;
    };*/

    public AuctionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public void addAuction(AuctionDTO auction, String creatorId) {
		final String insertAllocation = "INSERT INTO auctions VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertAllocation, auction.getId(), creatorId, auction.getTotalBitcoins(), auction.getPrice(), auction.getOpeningDate(), auction.getCloseDate());
	}
	
    
}
