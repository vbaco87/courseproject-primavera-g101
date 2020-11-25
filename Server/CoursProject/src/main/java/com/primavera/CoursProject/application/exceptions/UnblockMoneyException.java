package com.primavera.CoursProject.application.exceptions;

public class UnblockMoneyException extends RuntimeException {
	  public UnblockMoneyException (String userId){
	        super("User " + userId + " tried to unblock more money than he has.");
	    }
}