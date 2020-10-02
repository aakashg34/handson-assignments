package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.UserFactory;


public class UserServiceImpl implements UserService{
	private UserDao userDao = null;
	 public UserServiceImpl() {
			userDao = (UserDao)UserFactory.getInstance("dao");
		}
	@Override
	public User login(int userid, String password) throws UserNotFoundException {
		 User user= userDao.authentication(userid,password);
		  if(user==null)
		  {
			  throw new UserNotFoundException();
		  }
		  return user;
	}

	@Override
	public User register(User user) {
		return userDao.store(user);
	}

	@Override
	public int editProfile(User user, String password, long contact) {
		return userDao.editProfile(user,password,contact);
	}

	@Override
	public int addContacts(User user, String name, long phone) {
		return userDao.addContacts(user, name, phone);
	}

	@Override
	public int editContact(User user, String name, long phone) {
		return userDao.editContacts(user,name, phone);
	}

	@Override
	public List<Contact> viewContacts(User user) {
		return userDao.viewContacts(user);
	}

	@Override
	public int deleteContacts(User user, int contactId) throws UserNotFoundException {
		int status=userDao.deleteContacts(user,contactId);
		if(status!=1)
		{
			throw new UserNotFoundException("Contact not found");
		}
		return status;
	}

	@Override
	public User deleteProfile(User user) {
		return userDao.deleteProfile(user);
	}
}
