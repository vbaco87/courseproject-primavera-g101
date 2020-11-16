package com.primavera.CoursProject.application.aop;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.primavera.CoursProject.application.dto.AuctionDTO;

@Aspect
@Component
public class LoggerAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

	
	@Pointcut("execution(public java.util.List<com.primavera.CourseProject.application.dto.AuctionDTO>  com.primavera.CourseProject.application.AuctionController.get*Auctions(..))")
	public void pointcutGetAuctions( ) {
	}
	@Around("pointcutGetBidderWonAuctions()")
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

	
	@Pointcut("execution(public java.util.List<com.primavera.CourseProject.application.dto.AuctionDTO>  com.primavera.CourseProject.application.UserController.get*Auctions(..) && args(userId)")
	public void pointcutGetBidderAuctions(String userId) {
	}

	@Around("pointcutGetBidderWonAuctions(userId)")
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

	@Pointcut("execution(* com.primavera.CourseProject.application.UserController.updateBitcoin(..) && args(userId,quantity)")
	public void pointcutUpdateBitcoin(String userId, double quantity) {
	}

	@Around("pointcutUpdateCurrency(userId,quantity)")
	public void updateBitcoin(ProceedingJoinPoint jp, String userId, double quantity) {
		String status;
		if(quantity>0) {
			status = "Adding";
		}
		else {
			status = "Removing";
		}
		
		try {
			logger.info(status+" " +quantity + "BTC to user id " + userId);
			jp.proceed();
			logger.info(status + "operation completed without issues");
		} catch (Throwable throwable) {
			logger.info("Error while " + status + " "+quantity +"BTC to user id: " + userId);
		}
	}
	
	@Pointcut("execution(* com.primavera.CourseProject.application.UserController.updateMoney(..) && args(userId,quantity)")
	public void pointcutUpdateMoney(String userId, double quantity) {
	}

	@Around("pointcutUpdateCurrency(userId,quantity)")
	public void updateMoney(ProceedingJoinPoint jp, String userId, double quantity) {
		String status;
		if(quantity>0) {
			status = "Adding";
		}
		else {
			status = "Removing";
		}
		
		try {
			logger.info(status+" " +quantity + "EUR to user id " + userId);
			jp.proceed();
			logger.info(status + "operation completed without issues");
		} catch (Throwable throwable) {
			logger.info("Error while " + status + " "+quantity +"EUR to user id: " + userId);
		}
	}


}
