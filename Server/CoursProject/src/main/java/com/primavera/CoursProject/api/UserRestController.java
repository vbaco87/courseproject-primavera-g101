package com.primavera.CoursProject.api;

import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class UserRestController {

    UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable String id){
        return userController.getUser(id);
    }
}
