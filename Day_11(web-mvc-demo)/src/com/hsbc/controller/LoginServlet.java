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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("user");
		int id = Integer.parseInt(userId);
		String password = request.getParameter("pass");
		UserSevice service = (UserSevice)UserFactory.getInstance("service");
		try {
			User user = service.login(id,password);
			HttpSession session = request.getSession();
			session.setAttribute("userKey", user);
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(request, response);
		}catch(AuthenticationException | com.hsbc.exception.AuthenticationException e) {
			RequestDispatcher rd = request.getRequestDispatcher("LoginFailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.include(request, response);
		} 
	}

}
