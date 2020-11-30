package com.primavera.CoursProject.api;


import com.primavera.CoursProject.application.BitcoinController;
import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.SoldDTO;
import com.primavera.CoursProject.application.dto.*;
import org.springframework.validation.annotation.Validated;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import com.primavera.CoursProject.application.dto.BidDTO;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class UserRestController {

    UserController userController;
    BitcoinController bitcoinController;

    public UserRestController(UserController userController, BitcoinController bitcoinController) {
        this.userController = userController;
        this.bitcoinController= bitcoinController;
    }
    
    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable String id){
        return userController.getUser(id);
    }
    
    @GetMapping("users/me")
    public UserDTO getMyUser(Principal principal){
        return userController.getUserByEmail(principal.getName());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable String id, @Validated final UserDTO user){
        userController.updateUser(id, user);
    }
    
    @RequestMapping(value = "/users/me", method = RequestMethod.PUT)
    @ResponseBody
    public void updateMyUser( @Validated final UserDTO user, Principal principal){
    	String id = userController.getUserByEmail(principal.getName()).getId();
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
    
    @RequestMapping(value = "/users/me/auctions", method = RequestMethod.POST)
    public void addMyAuction(@RequestBody @Valid AuctionDTO auction, Principal principal) {
    	String id = userController.getUserByEmail(principal.getName()).getId();
    	userController.addAuction(auction, id);
    }
    
    @RequestMapping(value = "/users/{userId}/bids/auctions/{auctionId}", method = RequestMethod.POST)
    public void addBid(@RequestBody @Valid BidDTO bid, @PathVariable String userId,  @PathVariable String auctionId) {
    	userController.addBid(bid, userId, auctionId);
    }
    
    @RequestMapping(value = "/users/me/bids/auctions/{auctionId}", method = RequestMethod.POST)
    public void addMyBid(@RequestBody @Valid BidDTO bid, @PathVariable String auctionId, Principal principal) {
    	String id = userController.getUserByEmail(principal.getName()).getId();
    	userController.addBid(bid, id, auctionId);
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
    
    @GetMapping("/users/me/auctions") 
    public List<AuctionDTO> getMyBidderParticipatedAuctions(@RequestParam(defaultValue ="all") String status, @RequestParam(defaultValue ="false") boolean onlyWon, Principal principal){
    	String userId = userController.getUserByEmail(principal.getName()).getId();
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
    
    @GetMapping("/users/me/purchasedBitcoins")
    public List<PurchaseDTO> getMyPurchasedBitcoins(Principal principal){
    	String id = userController.getUserByEmail(principal.getName()).getId();
        return userController.getPurchasedTransactions(id);
    }

    @GetMapping("/users/{id}/soldBitcoins")
    public List<SoldDTO> getSoldBitcoins(@PathVariable String id){
        return userController.getSoldTransactions(id);
    }
    
    @GetMapping("/users/me/soldBitcoins")
    public List<SoldDTO> getMySoldBitcoins(Principal principal){
    	String id = userController.getUserByEmail(principal.getName()).getId();
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
    
    @GetMapping("/user/me/auction/{auctionId}/bid")
    public BidDTO getMyUserBid(@PathVariable String auctionId, Principal principal) throws Exception{
    	String userId = userController.getUserByEmail(principal.getName()).getId();
    	return userController.getUserBidInAuction(userId,auctionId);
    }
    
    @PostMapping("/users/{userId}/account/{currency}")
    public void updateCurrency(@PathVariable String userId, @PathVariable String currency, @RequestParam double quantity) throws Exception {
    	userController.updateCurrency(userId, quantity, currency.toUpperCase());
    }
    
    @PostMapping("/users/me/account/{currency}")
    public void updateMyCurrency(@PathVariable String currency, @RequestParam double quantity, Principal principal) {
    	String userId = userController.getUserByEmail(principal.getName()).getId();
    	userController.updateCurrency(userId, quantity, currency.toUpperCase());
    }
    
    @PostMapping( "/users/{brokerId}/buyBitcoins")
	public void buyBitcoins(@PathVariable String brokerId, @RequestParam double bitcoins) throws Exception { 
    	double price =  bitcoinController.buyBitcoins(bitcoins);
		userController.buyBitcoins(brokerId,bitcoins, price );
	}
    
    @PostMapping( "/users/me/buyBitcoins")
	public void buyMyBitcoins(@RequestParam double bitcoins, @RequestParam double price, Principal principal) { 
    	String brokerId = userController.getUserByEmail(principal.getName()).getId();
		userController.buyBitcoins(brokerId,bitcoins, price );
	}

}
