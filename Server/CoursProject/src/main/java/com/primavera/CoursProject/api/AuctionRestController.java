package com.primavera.CoursProject.api;

import com.primavera.CoursProject.application.AuctionController;
import com.primavera.CoursProject.application.dto.AuctionDTO;

import java.util.List;

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

      
    @GetMapping("/auctions")
    public List<AuctionDTO> getBrokerAuctions(@RequestParam(defaultValue ="all") String status) {
    	if(status.equals("all")) {
    		return auctionController.getAuctions();
    	}
    	else if(status.equals("active")) {
    		return auctionController.getActiveAuctions();
    	} 
    	
    	else if(status.equals("inactive")) {
    		return auctionController.getInactiveAuctions(); 
    	}
    	   
    	return null; 
    }

}
