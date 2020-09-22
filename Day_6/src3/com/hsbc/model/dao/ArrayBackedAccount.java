package com.hsbc.model.dao;

import com.hsbc.model.beans.Account;


public class ArrayBackedAccount implements AccountDao {

	private static Account[] userArray = new Account[10];
	
	private static int index = 0;
	@Override
	public Account store(Account account) {
		return userArray[index++]  = account;
	}
	@Override
	public Account[] fetchAccouts() {
		return userArray;
	}
	@Override
	public Account fetchAccountById(int accountNumber) {
		Account account = null;
		for(int i = 0; i < index; i++) {
			if(userArray[i].getAccountNumber() == accountNumber) { 
				account = userArray[i];
				return account;
			}
		}
		return null;
	}
	
	@Override
	public Account updateAccount(int accountNumber, Account account) {
		
		for(int i = 0;i<index;i++)
		{
			if(userArray[i].getAccountNumber() == accountNumber)
			{
				userArray[i] = account;
				break;
			}
		}
		return account;
	}
	
}
