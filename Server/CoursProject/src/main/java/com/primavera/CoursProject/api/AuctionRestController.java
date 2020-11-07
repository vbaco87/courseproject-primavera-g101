package com.primavera.CoursProject.api;

import com.primavera.CoursProject.application.AuctionController;
import com.primavera.CoursProject.application.dto.AuctionDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class AuctionRestController {

	AuctionController auctionController;

    public AuctionRestController(AuctionController auctionController) {
        this.auctionController = auctionController;
    }

    @RequestMapping(value = "/auctions/{userId}", method = RequestMethod.POST)
    public void addAuction(@RequestBody AuctionDTO auction, @PathVariable String userId) {
    	auctionController.addAuction(auction, userId);
    }

}
