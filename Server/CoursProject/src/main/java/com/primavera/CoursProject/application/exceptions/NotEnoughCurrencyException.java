package com.primavera.CoursProject.application.exceptions;

public class NotEnoughCurrencyException extends RuntimeException{
	   public NotEnoughCurrencyException(String userId, String currency){
	        super("User " + userId + " doesn't have enough " + currency + "to deal with this operation");
	    }
}
