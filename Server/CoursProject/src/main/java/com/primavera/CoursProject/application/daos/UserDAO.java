package com.primavera.CoursProject.application.daos;

import java.util.List;

import com.primavera.CoursProject.application.dto.UserDTO;

public interface UserDAO {

    public UserDTO getUser(String id);

    public void updateUser(UserDTO user);

    public UserDTO createUser(UserDTO user);

    public List<UserDTO> getBidders(String auctionId);
    
    
}
