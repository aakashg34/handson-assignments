package com.hsbc.model.utility;

import com.hsbc.model.dao.ArrayBackedAccount;
import com.hsbc.model.service.AccountServiceImpl;

public class AccountFactory {
	public static Object getInstance(Type type)
	{
		Object obj = null;
		switch(type) {
		case DAO: 
			obj = new ArrayBackedAccount();
			break;
		case SERVICE:
			obj = new AccountServiceImpl();
			break;
		}
		return obj;
	}
	
}
