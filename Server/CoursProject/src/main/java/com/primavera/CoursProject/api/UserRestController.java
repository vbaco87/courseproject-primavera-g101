package com.primavera.CoursProject.api;

import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserRestController {

    UserRestController userRestController;

    public UserRestController(UserRestController userRestController) {
        this.userRestController = userRestController;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable String id){
        return userRestController.getUser(id);
    }
}
