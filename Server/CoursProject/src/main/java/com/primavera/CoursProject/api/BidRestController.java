package com.primavera.CoursProject.api;

import com.primavera.CoursProject.application.BidController;
import com.primavera.CoursProject.application.dto.BidDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class BidRestController {

	BidController bidController;

    public BidRestController(BidController bidController) {
        this.bidController = bidController;
    }

    @RequestMapping(value = "/bids/{userId}/{auctionId}", method = RequestMethod.POST)
    public void addBid(@RequestBody BidDTO bid, @PathVariable String userId,  @PathVariable String auctionId) {
    	bidController.addBid(bid, userId, auctionId);
    }

}
