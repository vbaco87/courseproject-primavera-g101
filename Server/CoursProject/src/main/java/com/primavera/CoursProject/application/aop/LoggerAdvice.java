package com.primavera.CoursProject.application.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.primavera.CoursProject.application.dto.EntryDTO;



import org.aspectj.lang.annotation.*;

@Aspect
@Component
public class LoggerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

	@Pointcut("execution(* com.primavera.CoursProject.application.AccountController.getAccount(..))&& args(userId)")
	public void pointcutGetAccount(String userId) {
	}


	@Before("pointcutGetAccount(userId)")
	public void beforeGetAccount(String userId) {
		logger.info("Getting full account of user: " + userId);
	}

	@Pointcut("execution(* com.primavera.CoursProject.application.AccountController.getAvailableMoney(..))&& args(userId)")
	public void pointcutGetAvailable(String userId) {
	}


	@Before("pointcutGetAccount(userId)")
	public void beforeGetAvailable(String userId) {
		logger.info("Getting available money of user: " + userId);
	}

	@Pointcut("execution(* com.primavera.CoursProject.application.AccountController.updateWallet(..))&& args(accountId,entry)")
	public void pointcutUpdateWallet(String accountId, EntryDTO entry) {
	}

	@Around("pointcutUpdateWallet(accountId,entry)")
	public void dealRequestParam(ProceedingJoinPoint jp, String accountId, EntryDTO entry) throws Throwable {
		String action;
		if (entry.getQuantity()<0) {
	action = "Removing ";
}
		else action = "Adding ";
		
		try {
			logger.info(action + entry.getType() + " to account: " + accountId);
			jp.proceed();
			logger.info("Update for account "+accountId+" successful");

		} catch (Throwable e) {
			logger.info("Something went wrong when uppdating account of user " + accountId);
			throw e;
		}
	}
	@Pointcut("execution(* com.primavera.CoursProject.application.TransacrionController.buyBitcoins(..))&& args(brokerId, bitcoins, price)")
	public void pointcutUpdateWallet(String brokerId, double bitcoins, double price) {
	}

	@Around("pointcutUpdateWallet(brokerId, bitcoins, price)")
	public void dealRequestParam(ProceedingJoinPoint jp, String brokerId,double bitcoins, double price) throws Throwable {
	try {
			logger.info("Broker with id " + brokerId + " is buying " + bitcoins + " bitcoins for " + price);
			jp.proceed();
			logger.info("Purchase for broker "+brokerId+" successful");

		} catch (Throwable e) {
			logger.info("Something went wrong when purchasing bitcoins of broker " + brokerId);
			throw e;
		}
	}
}
