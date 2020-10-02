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

import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;

/**
 * Servlet implementation class EditContacts
 */
@WebServlet("/EditContacts")
public class EditContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contact_id=request.getParameter("id");
		HttpSession session = request.getSession();
		Contact profile = (Contact)session.getAttribute("userKey");
		User user = (User)session.getAttribute("userKey");
		UserService service=(UserService)UserFactory.getInstance("service");
		int status=service.editContact(user, profile.getName(), profile.getPhone());
		PrintWriter pw=response.getWriter();
		
		
		if(status == 1) {
			pw.print("<html><body><h1>");
			pw.print("Your contact id is valid");
			pw.print("</h1></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
			rd.include(request, response);
		}
		
	}

}
