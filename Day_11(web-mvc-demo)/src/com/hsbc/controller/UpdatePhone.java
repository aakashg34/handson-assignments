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
 * Servlet implementation class UpdatePhone
 */
@WebServlet("/UpdatePhone")
public class UpdatePhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		String phone = request.getParameter("phone");
		UserSevice service = (UserSevice)UserFactory.getInstance("service");
		try {
			User user = service.updatePassword(userId, phone);
			HttpSession session = request.getSession();
			session.setAttribute("userKey", user);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateSuccess.jsp");
			rd.forward(request, response);
		}catch(AuthenticationException e) {
			RequestDispatcher rd = request.getRequestDispatcher("UpdateFailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		} 
	}

}
