package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.BidDTO;
import com.primavera.CoursProject.application.exceptions.AuctionDoesNotExistException;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.simpleflatmapper.jdbc.spring.ResultSetExtractorImpl;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;

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
    
    private final RowMapper<BidDTO> bidRowMapperWithUser = (resultSet, i) -> {
        BidDTO bid = new BidDTO();

        bid.setId(resultSet.getString("id"));
        bid.setBitcoins(resultSet.getDouble("bitcoins"));
        bid.setAmount(resultSet.getDouble("amount"));
        bid.setUserId(resultSet.getString("user_id"));

        return bid;
    };
    
    ResultSetExtractorImpl<BidDTO> bidsRowMapper =
			JdbcTemplateMapperFactory
					.newInstance()
					.addKeys("id")
					.newResultSetExtractor(BidDTO.class);
    
    public BidDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

	@Override
	public void addBid(BidDTO bid, String userId, String auctionId) {
		final String addBit = "INSERT INTO bids VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(addBit, bid.getId(), userId, auctionId, bid.getBitcoins(), bid.getAmount());
	}


	public BidDTO getBid(String bidId) throws Exception {
		final var query = "select * from bids where id = ?";
		try {
			return jdbcTemplate.queryForObject(query, bidRowMapper, bidId);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception(e);
		}
		 
	}


	public List<BidDTO> getUserBids(String userId) throws Exception {
		final var query = "select * from bids where id_user = ?";
		try {
			return jdbcTemplate.query(query, bidRowMapper, userId);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception(e);
		}
	}
	
	public BidDTO getBidByUserId(String userId, String auctionId) throws Exception {
		final var query = "select * from bids where user_id = ? and auction_id =?";
		try {
			return jdbcTemplate.queryForObject(query, bidRowMapper, userId, auctionId);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception(e);
		}
		 
	}
	 public List<BidDTO> getParticipants(String auctionId) {
			final var query = "SELECT id, user_id, auction_id, bitcoins, amount from bids WHERE auction_id = ? ORDER BY amount DESC;";
			try {
				return jdbcTemplate.query(query, bidRowMapperWithUser, auctionId);
			} catch (EmptyResultDataAccessException e) {
				throw new AuctionDoesNotExistException(auctionId);
			}
		}

	
    
}