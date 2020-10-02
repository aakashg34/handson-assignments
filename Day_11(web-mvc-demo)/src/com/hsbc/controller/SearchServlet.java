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

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.mode.service.UserSevice;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("user");
		int userId =Integer.parseInt(userid);
		UserSevice service = (UserSevice)UserFactory.getInstance("service");
		try {
		User user = service.getUser(userId);
		HttpSession session = request.getSession();
		session.setAttribute("userKey", user);
		RequestDispatcher rd = request.getRequestDispatcher("SearchUser.jsp");
		rd.forward(request, response);
	}catch(UserNotFoundException e) {
		RequestDispatcher rd = request.getRequestDispatcher("NotFound.jsp");
		request.setAttribute("err", e.getMessage());
		rd.forward(request, response);
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
