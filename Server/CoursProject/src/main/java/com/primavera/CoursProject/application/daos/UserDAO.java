package com.primavera.CoursProject.application.daos;

import com.primavera.CoursProject.application.dto.UserDTO;

public interface UserDAO {

    public UserDTO getUser(String id);

    public void updateUser(UserDTO user);

    public UserDTO createUser(UserDTO user);

}
