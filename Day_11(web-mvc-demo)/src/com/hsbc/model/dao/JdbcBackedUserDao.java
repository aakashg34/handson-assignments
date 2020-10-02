package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedUserDao implements UserDao{

	@Override
	public User authenticate(int userId, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery  = "select * from user_table where user_id = ? and password = ?";
			PreparedStatement ps = connection.prepareStatement(loginQuery);
			ps.setInt(1,userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));

				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getLong("phone"));
				return user;
				
			}
			rs.close();
			ps.close();
			connection.close();
	
		if(user == null)
		{
			throw new AuthenticationException("Sorry username or password entered is wrong");
		}
		}catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtility.getConnection();
			String insert  = "insert into user_table values(next value for user_seq,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(insert);
			/*Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Name you want to enter");
			String name = scanner.next();
			System.out.println("Enter the password you want to keep");
			String password = scanner.next();
			System.out.println("Enter the Phone no for communication");
			long phone = scanner.nextLong();
			*/
			ps.setString(1,user.getName());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getPhone());
			int resultSet = ps.executeUpdate();
			
			ps.close();
			connection.close();
			return user;
		}catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		
			List<User> users = new ArrayList<User>();
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery  = "select * from user_table ";
			PreparedStatement ps = connection.prepareStatement(loginQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));

				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getLong("phone"));
				users.add(user);
			}
		}catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtility.getConnection();
			String update  = "update user_table set name = ?,password = ?,phone = ? where user_id = ?";
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setString(1,user.getName());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getPhone());
			ps.setInt(4, userId);
			int resultSet = ps.executeUpdate();
		}catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User getUser(int userId) throws UserNotFoundException {
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery  = "select * from user_table where user_id = ?";
			PreparedStatement ps = connection.prepareStatement(loginQuery);
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));

				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getLong("phone"));
				return user;
				
			}
			rs.close();
			ps.close();
			connection.close();
	
		if(user == null)
		{
			throw new UserNotFoundException("Sorry username or password entered is wrong");
		}
		}catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;

	}

	
}
