package com.hsbc.exception;

public class UserNotFoundException extends Exception{

	public UserNotFoundException() {
		super("Sorry user not presetn");
		
	}
	public UserNotFoundException(String arg) {
		super(arg);
}
}
