package com.primavera.CoursProject.api;

import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class UserRestController {

    UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable String id){
        return userController.getUser(id);
    }

    @PostMapping("/users")
    public void updateUser(@RequestBody UserDTO user){
        userController.updateUser(user);
    }

}
