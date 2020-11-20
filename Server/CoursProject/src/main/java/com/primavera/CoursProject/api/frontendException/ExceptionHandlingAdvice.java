package com.primavera.CoursProject.api.frontendException;

import com.primavera.CoursProject.application.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ResponseBody
    @ExceptionHandler(UserDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String classroomNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(org.springframework.dao.DuplicateKeyException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    String objectAlreadyExists(Exception exception) {
        return "Duplicated key. Please choose another one.";
    }
    
    @ResponseBody
    @ExceptionHandler(AuctionDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String auctionNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }
    

}
