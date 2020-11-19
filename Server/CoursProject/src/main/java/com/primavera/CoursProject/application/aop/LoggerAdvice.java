package com.primavera.CoursProject.application.aop;

import com.primavera.CoursProject.application.dto.UserDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;

@Aspect
@Component
public class LoggerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

    @Pointcut("execution(* com.primavera.CoursProject.application.UserController.*(com.primavera.CoursProject.application.dto.UserDTO))")
    public void pointcutUser() {}

    @Before("pointcutUser()")
    public void afterPointcutUser() {
        logger.info("Creating a new user");
    }

    @Pointcut("execution(public void com.primavera.CoursProject.application.UserController.*(..))&& args(id, user)")
    public void pointcutUpdateUser(String id, UserDTO user) {}

    @Around("pointcutUpdateUser(id, user)")
    public void dealRequestParam(ProceedingJoinPoint jp, String id, UserDTO user) {
        try {
            logger.info("Before updating user " + user.toString());
            UserDTO res = (UserDTO) jp.proceed();
            logger.info("After updating user " + user.toString());

        } catch (Throwable throwable) {
            logger.info("Something went wrong");
            throwable.printStackTrace();
        }
    }

    @Pointcut("execution(public com.primavera.CoursProject.application.dto.UserDTO com.primavera.CoursProject.application.UserController.*(..))&& args(id)")
    public void pointcutGetUser(String id) {}

    @After("pointcutGetUser(id)")
    public void beforePointcutUser(String id) {
        logger.info("Working with user with id = " + id);
    }

    @Pointcut("execution(* com.primavera.CoursProject.application.UserController.getSoldTransactions(..))&& args(id)")
    public void pointcutListUserSoldTransactions(String id) {}

    //Before advice of a pointcut
    @Before("pointcutListUserSoldTransactions(id)")
    public void beforListUserSoldTransactions(String id) {
        logger.info("Going to list all sold transactions of user with id " + id);   
    }

    @Pointcut("execution(* com.primavera.CoursProject.application.UserController.getPurchasedTransactions(..))&& args(id)")
    public void pointcutListUserPurchasedTransactions(String id) {}

    //Before advice of a pointcut
    @Before("pointcutListUserPurchasedTransactions(id)")
    public void beforListUserPurchasedTransactions(String id) {
        logger.info("Going to list all purchased transactions of user with id " + id);
    }

    @Pointcut("execution(* com.primavera.CoursProject.application.UserController.getAllPurchaseBitcoins(..))")
    public void pointcutListAllPurchasedTransactions() {}

    //Before advice of a pointcut
    @Before("pointcutListAllPurchasedTransactions()")
    public void beforAllUserPurchasedTransactions() {
        logger.info("Going to list all purchased transactions");
    }

    @Pointcut("execution(* com.primavera.CoursProject.application.UserController.getAllSoldBitcoins(..))")
    public void pointcutListAllSoldTransactions() {}

    //Before advice of a pointcut
    @Before("pointcutListAllSoldTransactions()")
    public void beforListAllPurchasedTransactions() {
        logger.info("Going to list all sold transactions");
    }
    
    @Pointcut("execution(* com.primavera.CoursProject.application.UserController.getUserBids(..)) && args(userId,auctionId)")
    public void pointcutListAlBidsFromUser(String userId, String auctionId) {}

    //Before advice of a pointcut
    @Before("pointcutListAlBidsFromUser(userId,auctionId)")
    public void beforeListingAllBidsFromUser(String userId, String auctionId) {
        logger.info("Going to get the bid for userId ' "+userId+"' for auction '" + auctionId+"'");
    }
}
