package com.servlet;
import com.bean.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.userdao;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user u = new user();
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("signup")) {
			u.setFname(request.getParameter("fname"));;
			u.setLname(request.getParameter("lname"));;
			u.setEmail(request.getParameter("email"));
			u.setMobile(Long.parseLong(request.getParameter("mobile")));;
			u.setPassword(request.getParameter("password"));;
			userdao.signup(u);
			
			request.setAttribute("msg"," User Registered Successfully ");
			request.getRequestDispatcher("signup.jsp").forward(request, response);;
			
		}
		
	}


}
