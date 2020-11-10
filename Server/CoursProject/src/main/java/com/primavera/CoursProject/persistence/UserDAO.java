package com.primavera.CoursProject.persistence;

import com.primavera.CoursProject.application.dto.UserDTO;
import com.primavera.CoursProject.application.exceptions.UserDoesNotExistException;
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
        try{
            return jdbcTemplate.queryForObject(queryUser, userRowMapper, id);
        }
        catch (EmptyResultDataAccessException e){
            throw new UserDoesNotExistException(id);
        }
    }

    @Override
    public void updateUser(UserDTO user) {
        final String queryUpdateUser= "update users set name = ?, second_name = ?, phone_number = ?, city = ?, country = ?, city_home_address = ? where id = ?";
        jdbcTemplate.update(queryUpdateUser, user.getName(), user.getSecondName(), user.getPhoneNumber(), user.getCity(), user.getCountry(), user.getHomeAddress(), user.getId());
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        final String insertUser = "INSERT INTO users (id, name, second_name, email, phone_number, country, city, city_home_address, user_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertUser, user.getId(),user.getName(),user.getSecondName(),user.getEmail(),user.getPhoneNumber(), user.getCountry(), user.getCity(), user.getHomeAddress(), user.getUserType());
        return this.getUser(user.getId());
    }
}
