package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedUserDao implements UserDao{

	@Override
	public User authentication(int userid, String password) {
		User user=null;
		String query="Select * from profiles where user_id=? and password=?";
		try
		{
			Connection con= DBUtility.getConnection();	
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, userid);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhone(rs.getLong(4));
				user.setDob(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

	@Override
	public User store(User user) {
		int id = 0;
		PreparedStatement ps;
		try
		{
			Connection con = DBUtility.getConnection();
			ps = con.prepareStatement("values(next value for id)");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				id=rs.getInt(1);
			}
			ps=con.prepareStatement("insert into people values(?,?,?,?,?)");
			user.setUserId(id);
			ps.setInt(1, id);
			ps.setString(2,user.getName());
			ps.setString(3,user.getPassword());
			ps.setLong(4, user.getPhone());
			ps.setString(5, user.getDob());
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch (SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public int editProfile(User user, String password, long contact) {
		int status=0;
		PreparedStatement ps;
		try
		{
			Connection con = DBUtility.getConnection();
			ps=con.prepareStatement("update people set password=? and phone=? where user_id=?");
			ps.setString(1,password);
			ps.setLong(2,contact);
			ps.setInt(3,user.getUserId());
			status=ps.executeUpdate();			
			ps.close();
			con.close();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int addContacts(User user, String name, long phone) {
		int id = 0;
		PreparedStatement ps;
		try
		{
			Connection con=DBUtility.getConnection();
			ps = con.prepareStatement("values(next value for id2)");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				id=rs.getInt(1);
			}
			ps=con.prepareStatement("insert into contacts values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setLong(3,phone);
			ps.setLong(4, user.getUserId());
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch (SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return id;
	}

	@Override
	public int editContacts(User user, String name, long phone) {
		
		int status=0;
		String query="Update contacts set name=? and contact=? where user_id=? ";
		try
		{
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setLong(2,phone);
			ps.setInt(3,user.getUserId());
			status=ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	@Override
	public List<Contact> viewContacts(User user) {
		
		String query="Select * from contacts where id_ref=?";
		List<Contact> contacts=new ArrayList<>();	
		try
		{
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,user.getUserId());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				contacts.add(new Contact(rs.getString(2),rs.getLong(3)));
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return contacts;
	}

	@Override
	public int deleteContacts(User user, int contactid) {
		int status=0;
		
		String query="delete from contacts where id_ref=? ";
		try
		{
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,contactid);
			status=ps.executeUpdate();
			System.out.println(status);
			ps.close();
			con.close();
		}
		catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return status;

	}

	@Override
	public User deleteProfile(User user) {
		
		String query="delete from contacts where id_ref=? ";
		try
		{
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, user.getUserId());
			ps.execute();
			query="delete from profiles where profile_id=? "; 
			ps=con.prepareStatement(query);
			ps.setInt(1, user.getUserId());
			ps.execute();
			ps.close();
			con.close();
		}
		catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	
}


