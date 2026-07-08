package com.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.Cookie;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	@Override
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response)
	        throws ServletException, IOException {

	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    String username;

	    if(email != null && email.contains("@")) {
	        username = email.split("@")[0];
	    }
	    else {
	        username = "Unknown";
	    }
	    
	    Cookie userCookie =
	            new Cookie("savedUsername", username);

	    userCookie.setMaxAge(60 * 60);

	    response.addCookie(userCookie);


	    if(email != null && email.endsWith("@admin.com")) {

	    	response.sendRedirect("Admin.jsp");

	    }
	    else {

	    	response.sendRedirect("User.jsp");

	    }
	}

}
