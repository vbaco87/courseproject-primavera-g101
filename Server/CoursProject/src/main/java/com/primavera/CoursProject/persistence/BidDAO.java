package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.BidDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BidDAO implements com.primavera.CoursProject.application.daos.BidDAO {
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<BidDTO> bidRowMapper = (resultSet, i) -> {
        BidDTO bid = new BidDTO();

        bid.setId(resultSet.getString("id"));
        bid.setBitcoins(resultSet.getDouble("bitcoins"));
        bid.setAmount(resultSet.getDouble("amount"));

        return bid;
    };

    public BidDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

	@Override
	public void addBid(BidDTO bid, String userId, String auctionId) {
		final String insertAllocation = "INSERT INTO bids VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertAllocation, bid.getId(), userId, auctionId, bid.getBitcoins(), bid.getAmount());
	}
	
    
}