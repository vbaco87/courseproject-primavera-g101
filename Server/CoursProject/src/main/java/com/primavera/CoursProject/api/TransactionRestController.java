package com.primavera.CoursProject.api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.primavera.CoursProject.application.TransactionController;
import com.primavera.CoursProject.application.dto.PurchaseDTO;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class TransactionRestController {
	TransactionController transactionController;

	public TransactionRestController(TransactionController transactionController) {
		this.transactionController = transactionController;
	}

	@RequestMapping(value = "/users/{brokerId}/buyBitcoins", method = RequestMethod.POST)
	@ResponseBody
	public void buyBitcoins(@PathVariable String brokerId,  PurchaseDTO purchase) { //broker compra
		transactionController.buyBitcoins(brokerId,purchase.getAmount(), purchase.getPrice() );
	}



}
