package com.primavera.CoursProject.api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.primavera.CoursProject.application.TransactionController;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Validated
public class TransactionRestController {
	TransactionController transactionController;

	public TransactionRestController(TransactionController transactionController) {
		this.transactionController = transactionController;
	}
	@PostMapping("/users/{brokerId}/buyBitcoins") 
	public void buyBitcoins(@PathVariable String brokerId, @RequestParam String bitcoins,@RequestParam String price) { //broker compra
		transactionController.buyBitcoins(brokerId,Integer.parseInt(bitcoins), Integer.parseInt(price));
	}
/*	@PostMapping("/asd")
	public void addTransaction(String userId, int bitcoins, int money){
		transactionController.addTransaction(userId, bitcoins, money);
	}
*/


}
