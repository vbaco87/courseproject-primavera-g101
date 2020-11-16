package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.AuctionDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AuctionDAO implements com.primavera.CoursProject.application.daos.AuctionDAO {
	
    private JdbcTemplate jdbcTemplate;

    
    private final RowMapper<AuctionDTO> auctionRowMapper = (resultSet, i) -> {
        AuctionDTO auction = new AuctionDTO();
        
        auction.setId(resultSet.getString("id"));
        auction.setTotalBitcoins(resultSet.getDouble("total_bitcoins"));
        auction.setPrice(resultSet.getDouble("price"));
        auction.setOpeningDate(resultSet.getDate("opening_date"));
        auction.setCloseDate(resultSet.getDate("closing_date"));
        return auction;
    };

    public AuctionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public void addAuction(AuctionDTO auction, String creatorId) {
		final String insertAllocation = "INSERT INTO auctions VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertAllocation, auction.getId(), creatorId, auction.getTotalBitcoins(), auction.getPrice(), auction.getOpeningDate(), auction.getCloseDate());
	}


	@Override
	public List<AuctionDTO> getAuctions() { 
		final var query = "select * from auctions";
		return jdbcTemplate.query(query, auctionRowMapper);
	}


	@Override
	public List<AuctionDTO> getActiveAuctions() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		final var query = "select * from auctions where ? between opening_date and closing_date";
		return jdbcTemplate.query(query, auctionRowMapper, now);
	}


	@Override
	public List<AuctionDTO> getInactiveAuctions() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		final var query = "select * from auctions where closing_date < ?";
		return jdbcTemplate.query(query, auctionRowMapper, now);
	}

 
	@Override
	public List<AuctionDTO> getWonAuctions(String userId) {
		final var query = "select a.id, a.creator_id, a.total_bitcoins, a.price, a.opening_date, a.closing_date from auctions a join winners w  on a.id =w.auction_id where w.user_id = ?";
		return jdbcTemplate.query(query, auctionRowMapper, userId); 
	}


	@Override
	public List<AuctionDTO> getBidderAuctions(String userId) {
		final var query = "SELECT a.id, a.total_bitcoins, a.price, a.opening_date, a.closing_date"
				+ " FROM auctions a"
				+ " JOIN bids b ON a.id = b.auction_id"
				+ " where b.user_id = ?";
		return jdbcTemplate.query(query, auctionRowMapper, userId); 

	}


	@Override
	public List<AuctionDTO> getBidderActiveAuctions(String userId) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		final var query = "SELECT a.id, a.total_bitcoins, a.price, a.opening_date, a.closing_date"
				+ " FROM auctions a"
				+ " JOIN bids b ON a.id = b.auction_id"
				+ " where b.user_id = ? and opening_date between ? and closing_date";
		return jdbcTemplate.query(query, auctionRowMapper, userId, now); 
	}

 
	@Override
	public List<AuctionDTO> getBidderInactiveAuctions(String userId) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		final var query = "SELECT a.id, a.total_bitcoins, a.price, a.opening_date, a.closing_date"
				+ " FROM auctions a"
				+ " JOIN bids b ON a.id = b.auction_id"
				+ " where b.user_id = ? and closing_date < ?";
		return jdbcTemplate.query(query, auctionRowMapper, userId, now); 
	}
	
    
}
