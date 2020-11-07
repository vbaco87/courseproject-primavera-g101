package com.primavera.CoursProject.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
@CrossOrigin(origins = "*")
@RestController
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

}
