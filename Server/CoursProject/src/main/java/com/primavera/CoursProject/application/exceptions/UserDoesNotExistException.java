package com.primavera.CoursProject.application.exceptions;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException (String userId){
        super("User " + userId + " doesn't exist");
    }
}
