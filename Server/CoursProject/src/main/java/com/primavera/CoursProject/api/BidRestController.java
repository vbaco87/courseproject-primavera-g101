package com.primavera.CoursProject.api;

import com.primavera.CoursProject.application.BidController;
import com.primavera.CoursProject.application.dto.BidDTO;

import java.util.List;

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

    @GetMapping("/bid/{bidId}")
    public BidDTO getBid(@PathVariable String bidId) throws Exception{
    	return bidController.getBid(bidId);
    }

    // /users/id/bids
    @GetMapping("/bids/{userId}")
    public List<BidDTO> getUserBids(@PathVariable String userId) throws Exception{
    	return bidController.getUserBids(userId);
    }
}
