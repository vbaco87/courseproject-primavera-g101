package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.UserDAO;
import org.springframework.stereotype.Service;

@Service // same as @Component
public class UserController {

    public UserDAO user;

    public UserController(UserDAO user) {
        this.user = user;
    }
}
