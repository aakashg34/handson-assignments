package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.mode.service.UserSevice;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserSevice service = (UserSevice)UserFactory.getInstance("service");
		List<User> users = service.fetchAll();
		request.setAttribute("listKey", users);
		RequestDispatcher rd = request.getRequestDispatcher("displayAll.jsp");
		rd.forward(request, response);
		
	}

	
}
