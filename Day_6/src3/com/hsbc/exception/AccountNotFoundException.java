package com.hsbc.exception;

// Add constructors inside AccountNotFoundException
public class AccountNotFoundException extends Exception {
	
	public AccountNotFoundException() {
		super("Sorry Account not found");
	}
	public AccountNotFoundException(String message) {
		super(message);
	}
	
	

}
