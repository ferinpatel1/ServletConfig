package com.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

import com.bean.user;
import com.dao.userdao;

@WebFilter("/Controller")
public class MyFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		user u = new user();
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("signup")) {
			u.setFname(request.getParameter("fname"));;
			u.setLname(request.getParameter("lname"));;
			u.setEmail(request.getParameter("email"));
			u.setMobile(Long.parseLong(request.getParameter("mobile")));;
			u.setPassword(request.getParameter("password"));;
			boolean b=userdao.checkemail(u);
			
			if(b) {
				chain.doFilter(request, response);
		}
			else {
				request.setAttribute("msg"," Mail Alredy Exist ");
				request.setAttribute("u",u);
				request.getRequestDispatcher("signup.jsp").forward(request, response);;

				
			}
		}
		
	}


}
