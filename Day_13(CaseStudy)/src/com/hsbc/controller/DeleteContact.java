package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/DeleteContact")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contact_id=request.getParameter("contactid");
		int id=Integer.parseInt(contact_id);
		HttpSession session = request.getSession();
		User u=(User)session.getAttribute("user_key");
		UserService service=(UserService)UserFactory.getInstance("service");
		try
		{
			service.deleteContacts(u,id);
			PrintWriter pw=response.getWriter();
			pw.print("<html><body><h1>");
			pw.print("Contact deleted successfully");
			pw.print("</h1></body></html>");
		} 
		catch (UserNotFoundException e)
		{
			PrintWriter pw=response.getWriter();
			pw.print("<html><body><p>");
			pw.print("Invalid Contact Id");
			pw.print("</p></body></html>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
		rd.include(request, response);
	}

}
