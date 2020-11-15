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
}
