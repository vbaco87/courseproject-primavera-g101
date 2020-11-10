package com.primavera.CoursProject.api;


import com.primavera.CoursProject.api.frontendException.IncorrectRESTParameter;
import com.primavera.CoursProject.application.UserController;
import com.primavera.CoursProject.application.dto.*;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

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

    @GetMapping("/users/{id}/transactions")
    public List<PurchaseDTO> getTransactions (@PathVariable String id, @RequestParam(defaultValue ="all") String status){
        if(status.equals("all")){
            return userController.getAllTransactions(id);
        }
        else if (status.equals("sold")){
            return userController.getSoldTransactions(id);
        }
        else if (status.equals("purchased")){
            return userController.getPurchasedTransactions(id);
        }
        else{
            throw new IncorrectRESTParameter("status", status);
        }
    }
}
