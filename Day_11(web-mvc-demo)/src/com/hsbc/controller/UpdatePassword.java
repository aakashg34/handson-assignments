package com.hsbc.controller;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.mode.service.UserSevice;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String password = request.getParameter("pass");
			UserSevice service = (UserSevice)UserFactory.getInstance("service");
		
			HttpSession session = request.getSession();
			User temp = (User)session.getAttribute("userKey");
			int userid = temp.getUserId();
			User user = service.updatePassword(userid, password);
			
			//session.setAttribute("userKey", user);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateSuccess.jsp");
			rd.forward(request, response);
		 
		
	}

}
