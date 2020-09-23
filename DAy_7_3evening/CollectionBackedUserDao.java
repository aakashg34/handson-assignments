package com.hsbc.model.dao;

import java.util.ArrayList;

import com.hsbc.model.beans.User;

public class CollectionBackedUserDao implements UserDao {

	ArrayList<User> userList = new ArrayList<User>();
	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		 userList.add(user);
		return user; 
		 
	}

	@Override
	public User[] fetchUsers() {
		// TODO Auto-generated method stub
	
		User[] users = (User[]) userList.toArray(new User[userList.size()]);
		
		return users;
	}

	@Override
	public User fetchUserById(int userId) {
		// TODO Auto-generated method stub
		for(User user : userList)
		{
			if(user.getUserId() == userId)
			{
				return user;
			}
		}
		return null;
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		for(int i= 0 ;i<userList.size();i++)
		{
			if(user.getUserId() == userList.get(i).getUserId())
			{
				userList.add(i,user);
				break;
			}
		}
		return user;
		
	}

}
