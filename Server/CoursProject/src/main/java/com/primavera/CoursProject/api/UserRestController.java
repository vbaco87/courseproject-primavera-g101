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
	
	@GetMapping("/available/{id}")
	public double getAvaliableMoney(@PathVariable int id) throws Exception {
		return userController.getAvaliableMoney(id);
	}

	@GetMapping("/account/{id}")
	public AccountDTO getAccount(@PathVariable int id) throws Exception {
		return userController.getAccount(id);
	}

	@PostMapping("/update/{accountId}")
	public void updateWallet(@PathVariable int accountId, @RequestBody EntryDTO entry) throws Exception {
        userController.updateWallet(accountId, entry);
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable String id){
        return userController.getUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(final UserDTO user){
        userController.updateUser(user);
    }
}
