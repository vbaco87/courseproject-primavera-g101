package com.primavera.CoursProject.application.daos;

import java.util.List;

import com.primavera.CoursProject.application.dto.BidDTO;
import com.primavera.CoursProject.application.dto.UserDTO;

public interface UserDAO {

    public UserDTO getUser(String id);
    
    public UserDTO getUserByEmail(String email);

    public void updateUser(UserDTO user);

    public UserDTO createUser(UserDTO user);

    public List<UserDTO> getBidders(String auctionId);
    
    public void saveWinners(BidDTO bid, String auctionId, double qttBitcoins);

    String getRole(String name);
}
