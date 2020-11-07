package com.primavera.CoursProject.application;


import com.primavera.CoursProject.application.daos.UserDAO;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service // same as @Component
public class UserController {

    public UserDAO user;
	private AccountDAO accountDAO;
    public UserController(UserDAO user,AccountDAO accountDAO) {
        this.user = user;
      	this.accountDAO = accountDAO;
    }

    public UserDTO getUser (String id){
        return user.getUser(id);
    }

    public void updateUser(UserDTO user) {
        this.user.updateUser(user);
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
