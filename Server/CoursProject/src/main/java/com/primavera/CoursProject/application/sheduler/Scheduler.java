package com.primavera.CoursProject.application.sheduler;

import com.primavera.CoursProject.application.daos.*;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import com.primavera.CoursProject.application.dto.BidDTO;
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

    public Scheduler(AuctionDAO auctionDAO, UserDAO userDAO, AccountDAO accountDAO, BidDAO bidDAO, TransactionDAO transaction) {
        this.auctionDAO = auctionDAO;
        this.userDAO = userDAO;
        this.accountDAO = accountDAO;
        this.bidDAO = bidDAO;
        this.transaction = transaction;
    }

    @Scheduled(cron="*/5 * * * * *")
    public void doSomething() {
        System.out.println("5 SECONDS");
        updateNewFinishedAuctions();
    }

    public void updateNewFinishedAuctions(){
        List<AuctionDTO> auctions = auctionDAO.getNewFinishedAuctions();
        if(!auctions.isEmpty()){
            for(AuctionDTO a : auctions){
                System.out.println(a.toString());
                auctionDAO.setActiveState(a);
                updateWinners(a);
            }
        }
    }

    public void updateWinners (AuctionDTO auction){
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
                    accountDAO.updateBlockedEuros(p.getUserId(), -(p.getAmount()+p.getAmount()*0.01));
                    userDAO.saveWinners(p, auction.getId(), p.getBitcoins());
                }
                else{
                    euros += p.getAmount();
                    accountDAO.updateBitcoin(p.getUserId(), qttBitcoins);
                    accountDAO.updateBlockedEuros(p.getUserId(), -(p.getAmount()+p.getAmount()*0.01));
                    userDAO.saveWinners(p, auction.getId(), qttBitcoins);
                    qttBitcoins = 0;
                }
            }
        }
        if(qttBitcoins>0){
            accountDAO.updateBitcoin(auction.getBrokerId(), qttBitcoins);
            accountDAO.updateEuro(auction.getBrokerId(), euros);
        }

        participants.removeAll(winners); // nomès els que no han guanyat

        for (BidDTO p : participants){
            accountDAO.updateBlockedEuros(p.getUserId(), -p.getAmount());
            accountDAO.updateEuro(p.getUserId(), p.getAmount());
        }
    }
}

