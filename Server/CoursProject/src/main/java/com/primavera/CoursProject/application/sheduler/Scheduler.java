package com.primavera.CoursProject.application.sheduler;

import com.primavera.CoursProject.application.AccountController;
import com.primavera.CoursProject.application.daos.*;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import com.primavera.CoursProject.application.dto.BidDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class Scheduler {

    AuctionDAO auctionDAO;
    UserDAO userDAO;
    AccountDAO accountDAO;
    BidDAO bidDAO;
    TransactionDAO transaction;
    AccountController accountController;

    public Scheduler(AuctionDAO auctionDAO, UserDAO userDAO, AccountDAO accountDAO, BidDAO bidDAO, TransactionDAO transaction, AccountController accountController) {
        this.auctionDAO = auctionDAO;
        this.userDAO = userDAO;
        this.accountDAO = accountDAO;
        this.bidDAO = bidDAO;
        this.transaction = transaction;
        this.accountController = accountController;
    }

    @Scheduled(cron="*/5 * * * * *")
    public void doSomething() throws Exception {
        System.out.println("5 SECONDS");
        updateNewFinishedAuctions();
    }

    public void updateNewFinishedAuctions() throws Exception{
        List<AuctionDTO> auctions = auctionDAO.getNewFinishedAuctions();
        if(!auctions.isEmpty()){
            for(AuctionDTO a : auctions){
                System.out.println(a.toString());
                auctionDAO.setActiveState(a);
                updateWinners(a);
            }
        }
    }

    public void updateWinners (AuctionDTO auction) throws Exception{
        List<BidDTO> participants = bidDAO.getParticipants(auction.getId());
        double qttBitcoins = auction.getTotalBitcoins();
        List<BidDTO> winners = new LinkedList<>();
        double euros = 0.0;

        for (BidDTO p : participants){
            if(qttBitcoins<=0){
                break;
            }
            else{
                if(qttBitcoins - p.getBitcoins()>0){
                    euros += p.getAmount();
                    accountDAO.updateBitcoin(p.getUserId(), p.getBitcoins());
                    qttBitcoins -= p.getBitcoins();
                    accountDAO.updateBlockedEuros(p.getUserId(), -(p.getAmount()));
                    accountController.updateWallet(p.getUserId(), new EntryDTO (p.getAmount(), "euros"));
                    userDAO.saveWinners(p, auction.getId(), p.getBitcoins());
                    winners.add(p);
                }
                else{
                    euros += p.getAmount();
                    accountDAO.updateBitcoin(p.getUserId(), qttBitcoins);
                    accountDAO.updateBlockedEuros(p.getUserId(), -p.getAmount());
                    accountController.updateWallet(p.getUserId(), new EntryDTO (p.getAmount(), "euros"));
                    userDAO.saveWinners(p, auction.getId(), qttBitcoins);
                    winners.add(p);
                    qttBitcoins = 0;
                }
            }
        }
        System.out.println(euros - euros*0.01);
        if(qttBitcoins>0){
            accountDAO.updateBitcoin(auction.getCreatorId(), qttBitcoins);

        }
        accountController.updateWallet(auction.getCreatorId(), new EntryDTO(euros - euros*0.01, "euros"));
        participants.removeAll(winners); // nomès els que no han guanyat

        for (BidDTO p : participants){
            accountDAO.updateBlockedEuros(p.getUserId(), -p.getAmount());
        }
    }
}

