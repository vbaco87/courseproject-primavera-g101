package com.primavera.CoursProject.application.sheduler;

import com.primavera.CoursProject.application.daos.AccountDAO;
import com.primavera.CoursProject.application.daos.AuctionDAO;
import com.primavera.CoursProject.application.daos.UserDAO;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import com.primavera.CoursProject.application.dto.UserDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scheduler {

    AuctionDAO auctionDAO;
    UserDAO userDAO;
    AccountDAO accountDAO;

    public Scheduler(AuctionDAO auctionDAO, UserDAO userDAO, AccountDAO accountDAO) {
        this.auctionDAO = auctionDAO;
        this.userDAO = userDAO;
        this.accountDAO = accountDAO;
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
        List<UserDTO> winners = userDAO.getWinners(auction.getId());

        for (UserDTO winner : winners){
            userDAO.saveWinner(winner, auction);
            accountDAO.updateBitcoin(winner.getId(), QUANTITAT ¿? );
        }

        List<UserDTO> bidders = userDAO.getBidders(auction.getId()); // tots els participants
        bidders.removeAll(winners); // nomès els que no han guanyat
    }
}
