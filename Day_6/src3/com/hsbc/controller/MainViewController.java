package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.model.beans.Account;
import com.hsbc.model.service.AccountService;
import com.hsbc.model.service.AccountServiceImpl;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.Type;


public class MainViewController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		// This is getting service object
		AccountService service = (AccountService)AccountFactory.getInstance(Type.SERVICE);
		int option = 0;
		do {
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All 3: Find User by id  4: Transfer  5: Exit");
			System.out.println("*****************************************************************************************");
			option = scanner.nextInt();
			switch(option) {
			case 1: 
				Account account = new Account();
				System.out.println("Enter name");		
				account.setCustomerName(scanner.next());
//				String name = scanner.next();
//				user.setName(name);
				
				System.out.println("Enter Contact Number");	
				account.setContactNumber(scanner.nextLong());
				System.out.println("Enter balance");	
				account.setBalance(scanner.nextDouble());
				
				Account newAccount = service.createAccount(account);
				System.out.println("User created with an Account Number: " + newAccount.getAccountNumber());
				break;
			case 2: 
				Account[] accounts = service.getAllUsers();
				for(Account temp : accounts) {
					if(temp!=null)
					System.out.println(temp);
				}
				break;
			case 3:
				System.out.println("Enter user id");
				try {
					Account accountFound = service.getAccountById(scanner.nextInt());
					// print on different device
					System.out.println(accountFound);
				} catch (AccountNotFoundException e) {
					// print error on different device
					System.err.println("ERROR:"+e.getMessage());
				}
				break;
			
			
			case 4:
				System.out.println("Enter the userId of whom you wan to transfer  from , to and the amount");
				
					service.transfer(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
					System.out.println("Transcation finished");
				
			}
		} while(option != 5);
		
		scanner.close();
		System.exit(0);
			}

	}

		
	
