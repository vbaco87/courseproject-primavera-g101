package com.primavera.CoursProject.api;

import java.security.Principal;

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
import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class AccountRestController {

	AccountController accountController;
	UserController userController;

	public AccountRestController(AccountController accountController, UserController userController) {
		this.accountController = accountController;
		this.userController = userController;
	}

	// /users/id/account?available=true
	@GetMapping("/users/{id}/account/available")
	public double getAvailableMoney(@PathVariable String id) throws Exception {

		return accountController.getAvailableMoney(id);
	}
	
	@GetMapping("/users/me/account/available")
	public double getMyAvailableMoney(Principal principal) throws Exception {
		String id = userController.getUserByEmail(principal.getName()).getId();
		return accountController.getAvailableMoney(id);
	}

	// /users/id/account
	@GetMapping("/users/{id}/account")
	public AccountDTO getAccount(@PathVariable String id) throws Exception {
		return accountController.getAccount(id);
	}

	@GetMapping("/users/me/account")
	public AccountDTO getMyAccount(Principal principal) throws Exception {
		String id = userController.getUserByEmail(principal.getName()).getId();
		return accountController.getAccount(id);
	}
	
	// /users/id/account

	 @RequestMapping(value = "/users/{id}/account", method = RequestMethod.POST)
	 @ResponseBody
	 public void updateWallet(@PathVariable String id, @RequestBody @Valid EntryDTO entry) throws Exception {
		accountController.updateWallet(id, entry);
	 }
	 
	 @RequestMapping(value = "/users/me/account", method = RequestMethod.POST)
	 @ResponseBody
	 public void updateMyWallet(@RequestBody @Valid EntryDTO entry, Principal principal) throws Exception {
		String id = userController.getUserByEmail(principal.getName()).getId();
		accountController.updateWallet(id, entry);
	 }
	 
	 @RequestMapping(value = "/users/{id}/account/blocked", method = RequestMethod.POST)
	 public void updateBlockedEuros(@PathVariable String id, @RequestBody @Valid EntryDTO entry) throws Exception {
		 accountController.updateBlockedEuros(id, entry.getQuantity());
	 }
	 
	 @RequestMapping(value = "/users/me/account/blocked", method = RequestMethod.POST)
	 public void updateMyBlockedEuros(@RequestBody @Valid EntryDTO entry,Principal principal) throws Exception{
		 String id = userController.getUserByEmail(principal.getName()).getId();
		 accountController.updateBlockedEuros(id, entry.getQuantity());
	 }
}
