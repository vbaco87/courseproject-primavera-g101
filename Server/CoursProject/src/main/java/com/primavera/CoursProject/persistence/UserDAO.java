package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.BidDTO;
import com.primavera.CoursProject.application.dto.UserDTO;
import com.primavera.CoursProject.application.exceptions.AuctionDoesNotExistException;
import com.primavera.CoursProject.application.exceptions.UserDoesNotExistException;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements com.primavera.CoursProject.application.daos.UserDAO {
	private JdbcTemplate jdbcTemplate;

	private final RowMapper<UserDTO> userRowMapper = (resultSet, i) -> {
		UserDTO user = new UserDTO();

		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setSecondName(resultSet.getString("second_name"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		user.setPhoneNumber(resultSet.getString("phone_number"));
		user.setBirthday(resultSet.getDate("birthday"));
		user.setCountry(resultSet.getString("country"));
		user.setCity(resultSet.getString("city"));
		user.setHomeAddress(resultSet.getString("city_home_address"));

		return user;
	};

	public UserDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserDTO getUser(String id) {
		final String queryUser = "SELECT id, name, second_name, email, password, phone_number, birthday, country, city, city_home_address FROM users WHERE id = ?";
		try {
			return jdbcTemplate.queryForObject(queryUser, userRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			throw new UserDoesNotExistException(id);
		}
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		final String queryUser = "SELECT id, name, second_name, email, password, phone_number, birthday, country, city, city_home_address FROM users WHERE email = ?";
		try {
			return jdbcTemplate.queryForObject(queryUser, userRowMapper, email);
		} catch (EmptyResultDataAccessException e) {
			throw new UserDoesNotExistException(email);
		}
	}

	@Override
	public void updateUser(UserDTO user) {
		final String queryUpdateUser = "update users set name = ?, second_name = ?, phone_number = ?, city = ?, country = ?, city_home_address = ? where id = ?";
		jdbcTemplate.update(queryUpdateUser, user.getName(), user.getSecondName(), user.getPhoneNumber(),
				user.getCity(), user.getCountry(), user.getHomeAddress(), user.getId());
	}

	@Override
	public UserDTO createUser(UserDTO user) {
		final String insertUser = "INSERT INTO users (id, name, second_name, email, phone_number, country, city, city_home_address) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(insertUser, user.getId(), user.getName(), user.getSecondName(), user.getEmail(),
				user.getPhoneNumber(), user.getCountry(), user.getCity(), user.getHomeAddress(), user.getUserType());
		createAccount(user.getId());
		createAuthority(user.getEmail(), user.getUserType());
		return this.getUser(user.getId());
	}

	private void createAuthority(String email, int userType) {
		String role = "";
		switch (userType) {
		case 0:
			role = "ADMIN";
		case 1:
			role = "BROKER";
		case 2:
			role = "BIDDER";
		}

		final String createUserAuthority = "INSERT INTO accounts (email, role) VALUES (?, ?)";
		jdbcTemplate.update(createUserAuthority, email, role);

	}

	public void createAccount(String userId) {
		final String createUserAccount = "INSERT INTO accounts (user_id, bitcoin_balance, euro_balance, blocked_euros) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(createUserAccount, userId, 50, 50, 0);
	}

	public List<UserDTO> getBidders(String auctionId) {
		final var query = "SELECT u.id, u.name, u.second_name, u.email, u.password, u.phone_number, u.birthday, u.country, u.city, u.city_home_address FROM users u JOIN bids b ON(u.id = b.user_id) WHERE b.auction_id = ?";
		try {
			return jdbcTemplate.query(query, userRowMapper, auctionId);
		} catch (EmptyResultDataAccessException e) {
			throw new AuctionDoesNotExistException(auctionId);
		}
	}

	public void saveWinners(BidDTO bid, String auctionId, double qttBitcoins) {
		final String query = "INSERT INTO winners (amount, price, auction_id, user_id) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(query, qttBitcoins, bid.getAmount(), auctionId, bid.getUserId());
	}

	@Override
	public String getRole(String name) {
		final String query = "SELECT role FROM authorities where email = ?";

		try {
			return jdbcTemplate.queryForObject(query, String.class, name);
		} catch (EmptyResultDataAccessException e) {
			throw new AuctionDoesNotExistException(name);
		}
	}

}
