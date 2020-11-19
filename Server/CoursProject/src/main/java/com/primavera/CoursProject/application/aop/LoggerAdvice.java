package com.primavera.CoursProject.application.aop;

import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.primavera.CoursProject.application.dto.AuctionDTO;

@Aspect
@Component
public class LoggerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

	
	@Pointcut("execution(public java.util.List<com.primavera.CoursProject.application.dto.AuctionDTO>  com.primavera.CoursProject.application.AuctionController.get*Auctions(..))")
	public void pointcutGetAuctions() {
	}
	@Around("pointcutGetAuctions()")
	public List<AuctionDTO> getAuctions(ProceedingJoinPoint jp ) {

		try {
			logger.info("Going to list auctions");
			List<AuctionDTO> res = (List<AuctionDTO>) jp.proceed();
			logger.info("Auctions are already listed");
			return res;
		} catch (Throwable throwable) {
			logger.info("Something went wrong while getting auctions");
			return new ArrayList<AuctionDTO>();
		}
	}

	
	@Pointcut("execution(public java.util.List<com.primavera.CoursProject.application.dto.AuctionDTO>  com.primavera.CoursProject.application.UserController.get*Auctions(..)) && args(userId)")
	public void pointcutGetBidderAuctions(String userId) {
	}

	@Around("pointcutGetBidderAuctions(userId)")
	public List<AuctionDTO> getBidderAuctions(ProceedingJoinPoint jp, String userId) {

		try {
			logger.info("Going to list auctions for user id: " + userId);
			List<AuctionDTO> res = (List<AuctionDTO>) jp.proceed();
			logger.info("Auctions for the user id: " + userId + " are already listed");
			return res;
		} catch (Throwable throwable) {
			logger.info("Something went wrong while getting auctions for user id: " + userId);
			return new ArrayList<AuctionDTO>();
		}
	}

	@Pointcut("execution(* com.primavera.CoursProject.application.UserController.updateCurrency(..)) && args(userId,quantity,currency)")
	public void pointcutUpdateCurrency(String userId, double quantity, String currency) {
	}

	@Around("pointcutUpdateCurrency(userId,quantity,currency)")
	public void updateCurrency(ProceedingJoinPoint jp, String userId, double quantity, String currency) throws Throwable {
		String status;
		if(quantity>0) {
			status = "Adding";
		}
		else {
			status = "Removing";
		}
		
		try {
			logger.info(status+" " +quantity + " " + currency +" to user id " + userId);
			jp.proceed();
			logger.info(status + " operation completed without issues");
		} catch (Throwable throwable) {
			logger.info("Error while " + status + " "+quantity + " " + currency + " to user id: " + userId);
		}
	}
	


}
