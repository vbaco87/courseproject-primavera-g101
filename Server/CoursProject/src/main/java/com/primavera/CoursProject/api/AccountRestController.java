package com.primavera.CoursProject.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.primavera.CoursProject.application.AccountController;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
public class AccountRestController {

	AccountController accountController;

	public AccountRestController(AccountController accountController) {
		this.accountController = accountController;
	}

	@GetMapping("/account/{userId}")
	public AccountDTO getAvaliableMoney(@PathVariable String userId) {
		return accountController.getAvaliableMoney(userId);
	}

	@GetMapping("/account/{userId}/entry/{entry}")
	public void updateAccount(String userId, EntryDTO entry) {
		accountController.updateAccount(userId, entry);
	}
}
