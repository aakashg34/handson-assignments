package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;

public interface UserDao {
	public User authentication(int userid,String password);
	public User store(User user);
	public int editProfile(User user,String newPassword, long newContact);
	public int addContacts(User u,String friendname,long friendphone);
	
	public int editContacts(User user,String name,long phone);
	
	public	List<Contact> viewContacts(User user);
	public int deleteContacts(User user,int contactid);
	public User deleteProfile(User user);
	
	

		
}
