package com.primavera.CoursProject.application;


import com.primavera.CoursProject.application.daos.UserDAO;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service // same as @Component
public class UserController {

    public UserDAO user;
    public UserController(UserDAO user) {
        this.user = user;
    }

    public UserDTO getUser (String id){
        return user.getUser(id);
    }

    public void updateUser(String id, UserDTO user) {
        user.setId(id);
        this.user.updateUser(user);
    }

    public UserDTO createUser(UserDTO user){
        user.setId(UUID.randomUUID().toString());
        return this.user.createUser(user);
    }

   public double getAvaliableMoney(int userId) throws Exception {

    	AccountDTO account  =accountDAO.getAccount(userId);
    	return account.getEuroBalance()-account.getBlockedEuros();
    }
    public AccountDTO getAccount(int userId) throws Exception {

    	return accountDAO.getAccount(userId);
    }

    public void updateWallet(int accountId , EntryDTO entry) throws Exception {
    	accountDAO.insertEntry(accountId, entry);
    	AccountDTO account = accountDAO.getAccount(accountId);
    	switch(entry.getType().toLowerCase()){
    		case "bitcoin": accountDAO.updateBitcoin(accountId, account.getBitcoinBalance()+entry.getQuantity()); break;
    		case "euros": accountDAO.updateEuros(accountId,account.getEuroBalance()+ entry.getQuantity()); break;
    	}

}
