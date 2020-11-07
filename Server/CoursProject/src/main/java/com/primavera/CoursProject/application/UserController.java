package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.UserDAO;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service // same as @Component
public class UserController {

    public UserDAO user;

    public UserController(UserDAO user) {
        this.user = user;
    }

    public UserDTO getUser(String id) {
        return user.getUser(id);
    }

    public void updateUser(String id, UserDTO user) {
        user.setId(id);
        this.user.updateUser(user);
    }

    public UserDTO createUser(UserDTO user) {
        user.setId(UUID.randomUUID().toString());
        return this.user.createUser(user);
    }


}
