package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.mode.service.UserServiceImpl;
import com.hsbc.mode.service.UserSevice;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("user");
		String password = request.getParameter("pass");
		String ph = request.getParameter("phone");
		long phone = Long.parseLong(ph);
		User newUser = new User();
		newUser.setName(userName);
		newUser.setPassword(password);
		newUser.setPhone(phone);
		UserSevice service = (UserSevice)UserFactory.getInstance("service");
		User createdUser = service.createUser(newUser);
		HttpSession session = request.getSession();
		session.setAttribute("userKey", createdUser);
		RequestDispatcher rd = request.getRequestDispatcher("RegisterSuccess.jsp");
		rd.forward(request, response);
		
	}

}
