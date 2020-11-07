package com.primavera.CoursProject.api;


import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
  import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
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

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable String id, @Validated final UserDTO user){
        userController.updateUser(id, user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void createUser(@Validated final UserDTO user){
        userController.createUser(user);
    }


}
