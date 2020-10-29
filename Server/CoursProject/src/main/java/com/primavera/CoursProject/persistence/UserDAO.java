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

        user.setName(resultSet.getString("name"));
        user.setSecondName(resultSet.getString("secondname"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setPhoneNumber(resultSet.getString("phoneNumber"));
        user.setBirthday(resultSet.getDate("birthday"));
        user.setCountry(resultSet.getString("country"));
        user.setSecondName(resultSet.getString("city"));
        user.setHomeAddress(resultSet.getString("cityhomeAddress"));

        return user;
    };

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDTO getUser(String id) {
        final String queryUser = "SELECT name, secondName, email, password, phoneNumber, birthday, country, city, cityhomeAddress FROM users WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(queryUser, userRowMapper, id);
        }
        catch (EmptyResultDataAccessException e){
            throw new UserDoesNotExistException(id);
        }
    }

    @Override
    public void updateUser(UserDTO user) {

    }

    @Override
    public void createUser(UserDTO user) {

    }
}
