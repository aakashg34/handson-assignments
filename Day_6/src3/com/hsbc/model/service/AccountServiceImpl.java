package com.hsbc.model.service;

import javax.security.auth.login.AccountException;

import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.model.beans.Account;
import com.hsbc.model.dao.AccountDao;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.Type;


public class AccountServiceImpl implements AccountService {
	
	private AccountDao dao;
	public AccountServiceImpl() {
		dao = (AccountDao)AccountFactory.getInstance(Type.DAO);
	}
	
	@Override
	public Account createAccount(Account account) {
		Account createdAccount = dao.store(account);
		return createdAccount;
		
	}
	@Override
	public Account[] getAllUsers(){
		return dao.fetchAccouts();
		
	}
		
	@Override
	public Account getAccountById(int accountNumber) throws AccountNotFoundException{
		Account account = dao.fetchAccountById(accountNumber);
		
		if(account == null)
		{
			throw new AccountNotFoundException();
		}
		return account;
	}
	@Override
	public void transfer(int from, int to, double amount)  {
		Account source = dao.fetchAccountById(from);
		Account destination = dao.fetchAccountById(to);
		if(amount<=source.getBalance())
		{
			source.setBalance(source.getBalance() - amount);
			destination.setBalance(destination.getBalance()+amount);
			dao.updateAccount(from, source);
			dao.updateAccount(to, destination);
		}

		

	}
}
