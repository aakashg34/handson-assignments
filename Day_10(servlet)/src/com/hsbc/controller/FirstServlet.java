package com.hsbc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //  private static int count = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		HttpSession session = request.getSession();
		List<String> itemList = null;
		
		String itemName = request.getParameter("item");
		if(session.getAttribute("itemList")==null)
		{
			itemList = new ArrayList<String>();
			itemList.add(itemName);
		}
		else {
			itemList = (List<String>) session.getAttribute("itemList");
			itemList.add(itemName);
			
		}
		
		session.setAttribute("itemList", itemList);
		
		printWriter.print("Count "+((List<String>) session.getAttribute("itemList")).size());
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}


}
