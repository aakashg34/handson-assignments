package com.hsbc.model.util;

import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import com.hsbc.mode.service.UserServiceImpl;
import com.hsbc.model.dao.JdbcBackedUserDao;

public class UserFactory {
	public static Object getInstance(String type) {
		if(type.equals("dao"))
			return new JdbcBackedUserDao();
		if(type.equals("service"))
		{
			return new UserServiceImpl();
			
		}
		return null;
	}
}
