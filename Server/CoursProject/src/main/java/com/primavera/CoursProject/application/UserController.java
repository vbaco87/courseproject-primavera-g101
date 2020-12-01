package com.primavera.CoursProject.application;

import com.primavera.CoursProject.application.daos.*;
import com.primavera.CoursProject.application.dto.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // same as @Component
public class UserController {

    public UserDAO user;
    public AuctionDAO auction;
    public BidDAO bid;
    public AccountDAO account;
    public EntryDAO entry;
    public PurchaseDAO purchase;
    public SoldDAO sold;
	public TransactionDAO transaction;
	public AccountController accountController;
    
    public UserController(UserDAO user, AuctionDAO auction, BidDAO bid, PurchaseDAO purchase, SoldDAO sold, AccountDAO account, EntryDAO entry, TransactionDAO transaction, AccountController accountController) {
        this.user = user;
        this.auction = auction;
        this.bid = bid;
        this.purchase = purchase;
        this.sold = sold;
        this.account=account;
        this.entry = entry;
    	this.transaction = transaction;
    	this.accountController= accountController;
    }

    public UserDTO getUser(String id) {
        return user.getUser(id);
    }
    
    public UserDTO getUserByEmail(String email) {
        return user.getUserByEmail(email);
    }

    public void updateUser(String id, UserDTO user) {
        user.setId(id);
        this.user.updateUser(user);
    }

    public UserDTO createUser(UserDTO user) {
        user.setId(UUID.randomUUID().toString());
        return this.user.createUser(user);
    }
    
    public void addAuction(AuctionDTO auction, String userId) throws Exception {
    	auction.setBrokerId(userId);
    	this.auction.addAuction(auction, userId);
    	EntryDTO entry= new EntryDTO();
    	entry.setType("bitcoin");
    	entry.setQuantity(auction.getTotalBitcoins());
    	System.out.println("bitcoinsAuction = "+entry.getQuantity());

    	this.accountController.updateWallet(userId, entry);
    }
    
    public void addBid(BidDTO bid, String userId, String auctionId) throws Exception {
    	this.bid.addBid(bid, userId, auctionId);
    	this.account.updateBlockedEuros(userId, bid.getAmount());
    }
    
    public List<UserDTO> getBidders(String auctionId){
    	return this.user.getBidders(auctionId);
    }
    
    public void unlockMoney(List<UserDTO> bidders, String auctionId) throws Exception {
    	Double amount;
    	for (UserDTO bidder : bidders) {
    		String userId= bidder.getId();
    		amount = this.bid.getBidByUserId(userId, auctionId).getAmount();
    		amount = this.account.getAccount(userId).getBlockedEuros() - amount;
    		this.account.updateBlockedEuros(userId, amount);
    	}
    }

    public List<PurchaseDTO> getAllTransactions(String userId) { //getAllBitcoinsPurchased
        return purchase.getAllTransactions(userId);
    }

    public List<SoldDTO> getSoldTransactions(String userId) {
        return sold.getSoldTransactions(userId);
    }

    public List<PurchaseDTO> getPurchasedTransactions(String userId) {
        return purchase.getPurchasedTransactions(userId);
    }

    public List<PurchaseDTO> getAllPurchaseBitcoins() {
        return purchase.getAllPurchaseBitcoins();
    }
  
	public List<AuctionDTO> getBidderWonAuctions(String userId) {
		return auction.getWonAuctions(userId);
	}

	public List<AuctionDTO> getBidderAuctions(String userId) {
		return auction.getBidderAuctions(userId);
	}

	public List<AuctionDTO> getBidderActiveAuctions(String userId) {
		return auction.getBidderActiveAuctions(userId);
	}

	public List<AuctionDTO> getBidderInactiveAuctions(String userId) {
		return auction.getBidderInactiveAuctions(userId);
	}

    public List<SoldDTO> getAllSoldBitcoins() {
        return sold.getAllSoldBitcoins();
    }

    public void updateCurrency(String userId, double quantity, String currency) throws Exception {
		if(currency.equals("BTC")) {
			account.updateBitcoin(userId, quantity);
		}
		else if(currency.equals("EUR")) {
			account.updateEuro(userId, quantity);
		}
		entry.insertEntry(userId, new EntryDTO(quantity, currency));

	}

	public List<BidDTO> getUserBids(String userId) throws Exception {
		return bid.getUserBids(userId);
	}

	public BidDTO getUserBidInAuction(String userId, String auctionId) throws Exception {
		return bid.getBidByUserId(userId, auctionId);
	}
	public void buyBitcoins(String brokerId, double bitcoins, double price) throws Exception {	
		price = price+(price*0.0001);
		String purchaseId = transaction.buyBitcoins(brokerId, bitcoins, price);

		transaction.addTransaction(purchaseId, brokerId);
		System.out.println("bitcoins = " +bitcoins);
		EntryDTO entryDTO = new EntryDTO(bitcoins, "bitcoin");
		//entry.insertEntry(brokerId,entryDTO);
		accountController.updateWallet(brokerId, entryDTO);
		}


}
