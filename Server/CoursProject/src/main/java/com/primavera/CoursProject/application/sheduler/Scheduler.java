package com.primavera.CoursProject.application.sheduler;

import com.primavera.CoursProject.application.daos.AccountDAO;
import com.primavera.CoursProject.application.daos.AuctionDAO;
import com.primavera.CoursProject.application.daos.BidDAO;
import com.primavera.CoursProject.application.daos.UserDAO;
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

    public Scheduler(AuctionDAO auctionDAO, UserDAO userDAO, AccountDAO accountDAO, BidDAO bidDAO) {
        this.auctionDAO = auctionDAO;
        this.userDAO = userDAO;
        this.accountDAO = accountDAO;
        this.bidDAO =bidDAO;
    }

    @Scheduled(cron="*/5 * * * * *")
    public void doSomething() {
        updateNewFinishedAuctions();
    }

    public void updateNewFinishedAuctions(){
        List<AuctionDTO> auctions = auctionDAO.getNewFinishedAuctions();
        if(!auctions.isEmpty()){
            for(AuctionDTO a : auctions){
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
            if(qttBitcoins==0){
                break;
            }
            else{
                userDAO.saveWinners(p, auction.getId());
                if(qttBitcoins - p.getBitcoins()>=0){
                    euros += p.getAmount();
                    accountDAO.updateBitcoin(p.getUserId(), p.getBitcoins());
                    qttBitcoins -= p.getAmount();
                    accountDAO.updateBlockedEuros(p.getUserId(), -p.getAmount());
                }
                else{
                    euros += p.getAmount();
                    accountDAO.updateBitcoin(p.getUserId(), qttBitcoins);
                    accountDAO.updateBlockedEuros(p.getUserId(), -p.getAmount());
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

