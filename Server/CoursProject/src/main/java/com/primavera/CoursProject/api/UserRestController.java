package com.primavera.CoursProject.api;


import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.SoldDTO;
import com.primavera.CoursProject.application.dto.*;
import org.springframework.validation.annotation.Validated;
import java.security.InvalidParameterException;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import com.primavera.CoursProject.application.dto.AccountDTO;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import com.primavera.CoursProject.application.dto.BidDTO;
import com.primavera.CoursProject.application.dto.EntryDTO;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class UserRestController {

    UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable String id){
        return userController.getUser(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable String id, @Validated final UserDTO user){
        userController.updateUser(id, user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void createUser(@Validated final UserDTO user){
        userController.createUser(user);
    }

    @RequestMapping(value = "/users/{userId}/auctions", method = RequestMethod.POST)
    public void addAuction(@RequestBody @Valid AuctionDTO auction, @PathVariable String userId) {
    	userController.addAuction(auction, userId);
    }
    
    @RequestMapping(value = "/users/{userId}/bids/auctions/{auctionId}", method = RequestMethod.POST)
    public void addBid(@RequestBody @Valid BidDTO bid, @PathVariable String userId,  @PathVariable String auctionId) {
    	userController.addBid(bid, userId, auctionId);
    }
    
    @GetMapping("/users/{userId}/auctions") 
    public List<AuctionDTO> getBidderParticipatedAuctions(@PathVariable String userId, @RequestParam(defaultValue ="all") String status, @RequestParam(defaultValue ="false") boolean onlyWon){
    	if(onlyWon) {
    		return userController.getBidderWonAuctions(userId);   
    	}
    	if(status.equals("all")) {
    		return userController.getBidderAuctions(userId);
    	}
    	else if(status.equals("active")) {
    		return userController.getBidderActiveAuctions(userId);
    	}
    	
    	else if(status.equals("inactive")) { 
    		return userController.getBidderInactiveAuctions(userId); 
    	}
    	  
    	return null;
    }

    @GetMapping("/users/{id}/purchasedBitcoins")
    public List<PurchaseDTO> getPurchasedBitcoins(@PathVariable String id){
        return userController.getPurchasedTransactions(id);
    }

    @GetMapping("/users/{id}/soldBitcoins")
    public List<SoldDTO> getSoldBitcoins(@PathVariable String id){
        return userController.getSoldTransactions(id);
    }

    @GetMapping("/users/purchaseBitcoins")
    public List<PurchaseDTO> getAllPurchaseBitcoins(){
        return userController.getAllPurchaseBitcoins();
    }

    @GetMapping("/users/soldBitcoins")
    public List<SoldDTO> getAllSoldBitcoins(){
        return userController.getAllSoldBitcoins();
    }

    @GetMapping("/user/{userId}/auction/{auctionId}/bid")
    public BidDTO getUserBid(@PathVariable String userId, @PathVariable String auctionId) throws Exception{
    	return userController.getUserBidInAuction(userId,auctionId);
    }
    
    @PostMapping("/users/{userId}/account/{currency}")
    public void updateCurrency(@PathVariable String userId, @PathVariable String currency, @RequestParam double quantity) {
    	userController.updateCurrency(userId, quantity, currency.toUpperCase());
    }
}
