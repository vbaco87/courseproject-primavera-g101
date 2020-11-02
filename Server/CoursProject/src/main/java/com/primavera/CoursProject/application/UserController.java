package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.UserDAO;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service // same as @Component
public class UserController {

    public UserDAO user;

    public UserController(UserDAO user) {
        this.user = user;
    }

    public UserDTO getUser (String id){
        return user.getUser(id);
    }

    public void updateUser(UserDTO user) {
        this.user.updateUser(user);
    }
}
