package com.hsbc.mode.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.UserFactory;

public class UserServiceImpl implements UserSevice{
	
	private UserDao userDao = null;
	public  UserServiceImpl() {
		// TODO Auto-generated constructor stub
		userDao = (UserDao)UserFactory.getInstance("dao");
	}
	
	@Override
	public User login(int userId, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user = userDao.authenticate(userId, password);
		if(user == null) {
			throw new AuthenticationException("Sorry something went Wrong");
		}
		return user;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User createdUser = userDao.store(user);
		return createdUser;
	}

	@Override
	public User updatePhone(int userId, long phone) {
		// TODO Auto-generated method stub
		List<User> users = userDao.fetchAllUsers();
		User user = null;
		for(User temp : users)
		{
			if(temp.getUserId() == userId)
			{
				user = temp;
				break;
			}
		}
		user.setPhone(phone);
		User updatedUser=userDao.updateUser(userId, user);
		return updatedUser;
		
	}

	@Override
	public User updatePassword(int userId, String password) {
		// TODO Auto-generated method stub
		List<User> users = userDao.fetchAllUsers();
		User user = null;
		for(User temp : users)
		{
			if(temp.getUserId() == userId)
			{
				user = temp;
				break;
			}
		}
		user.setPassword(password);
		User updatedUser=userDao.updateUser(userId, user);
		return updatedUser;
	}

	@Override
	public User getUser(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> users = userDao.fetchAllUsers();
		User user = null;
		
		for(User temp : users)
		{
			if(temp.getUserId() == userId)
			{
				user =  temp;
				break;
			}
			if(user == null) {
				throw new UserNotFoundException("Sorry no user found");
			}
		
		}
	
		
		return user;
	}

	@Override
	public List<User> fetchAll() {
		// TODO Auto-generated method stub
		List<User> users = userDao.fetchAllUsers();
		
		return users;
	}

	

}
