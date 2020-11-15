package com.primavera.CoursProject.api;


import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.SoldDTO;
import com.primavera.CoursProject.application.dto.*;
import org.springframework.validation.annotation.Validated;

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
    public void addAuction(@RequestBody AuctionDTO auction, @PathVariable String userId) {
    	userController.addAuction(auction, userId);
    }
    
    @RequestMapping(value = "/users/{userId}/bids/auctions/{auctionId}", method = RequestMethod.POST)
    public void addBid(@RequestBody BidDTO bid, @PathVariable String userId,  @PathVariable String auctionId) {
    	userController.addBid(bid, userId, auctionId);
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

}
