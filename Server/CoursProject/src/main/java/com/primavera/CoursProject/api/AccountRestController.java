package com.primavera.CoursProject.api;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.primavera.CoursProject.application.AccountController;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class AccountRestController {

	AccountController accountController;

	public AccountRestController(AccountController accountController) {
		this.accountController = accountController;
	}

	// /users/id/account?available=true
	@GetMapping("/users/{id}/account/available")
	public double getAvailableMoney(@PathVariable String id) throws Exception {

		return accountController.getAvailableMoney(id);
	}

	// /users/id/account
	@GetMapping("/users/{id}/account")
	public AccountDTO getAccount(@PathVariable String id) throws Exception {
		return accountController.getAccount(id);
	}

	// /users/id/account

	 @RequestMapping(value = "/users/{id}/account", method = RequestMethod.POST)
	 @ResponseBody
	public void updateWallet(@PathVariable String id,  @Valid EntryDTO entry) throws Exception {
		accountController.updateWallet(id, entry);
    }
}
