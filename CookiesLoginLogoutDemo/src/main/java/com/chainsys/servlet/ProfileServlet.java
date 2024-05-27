package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public ProfileServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.jsp").include(request, response);
		Cookie cookie[]=request.getCookies();
		if(cookie != null)
		{
			String name=cookie[0].getValue();
			if(!name.equals("")||name!=null)
			{
				out.println("<b>Welcome to Profile</b>");
//				out.println("<br>Welcome"+name);
			}
		}
		else
		{
			out.print("Please Login First");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
