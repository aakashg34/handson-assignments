package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;

public interface UserService {
	public User login(int userid,String password) throws UserNotFoundException;
	public User register(User user);
	public int editProfile(User user,String password,long contact);
	public int addContacts(User u,String name,long phone);
	public int editContact(User user,String name,long phone);
	public List<Contact>viewContacts(User user);
	
	public int deleteContacts(User user,int contactId) throws UserNotFoundException;
	
	public User deleteProfile(User user);

}
