package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.EntryDAO;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;
import com.primavera.CoursProject.persistence.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class AccountController {
    public AccountDAO accountDAO;
    public EntryDAO entryDAO;

    public AccountController(AccountDAO accountDAO, EntryDAO entryDAO) {
        this.accountDAO = accountDAO;
        this.entryDAO = entryDAO;
    }

    public double getAvailableMoney(String userId) throws Exception {
        AccountDTO account = accountDAO.getAccount(userId);
        return account.getEuroBalance() - account.getBlockedEuros();
    }

    public AccountDTO getAccount(String userId) throws Exception {
        return accountDAO.getAccount(userId);
    }

    public void updateWallet(String accountId, EntryDTO entry) throws Exception {
        AccountDTO account = accountDAO.getAccount(accountId);
        entryDAO.insertEntry(accountId, entry);
        switch (entry.getType().toLowerCase()) {
            case "bitcoin":
                accountDAO.updateBitcoin(accountId, account.getBitcoinBalance() + entry.getQuantity());
                break;
            case "euros":
                accountDAO.updateEuro(accountId, account.getEuroBalance() + entry.getQuantity());
                break;
        }

    }
}
