package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public LoginServlet() 
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.jsp").include(request,response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(password.equals("Ani01@"))
		{
			out.println("Login Successfull");
			Cookie cookie=new Cookie("name",username);
			response.addCookie(cookie);
		}
		else
		{
			out.println("Invalid Username or Password");
			request.getRequestDispatcher("login.jsp").include(request,response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
