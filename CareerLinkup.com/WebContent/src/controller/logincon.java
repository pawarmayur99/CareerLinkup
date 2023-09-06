package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Dao;

@WebServlet("/logincon")
public class logincon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logincon() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	    String Email=request.getParameter("Email");
	    String Password=request.getParameter("Password");
	    
	   if(Dao.login(Email, Password))
	   {
		   pw.print("<script> alert('login successfully') </script>");
		   HttpSession session=request.getSession();
			session.setAttribute("Email", Email);
		   RequestDispatcher rd=request.getRequestDispatcher("index.html");
		   rd.include(request, response);
		   
		   
			//pw.print("<a href='index.html'>HomeController</a>");
		   		   
	   }
	   else
	   {
		   pw.print("<script> alert('wrong password try again') </script>");
		   RequestDispatcher rd=request.getRequestDispatcher("login.html");
		   rd.include(request, response); 
	   }
		
	    
	    
	}
}
