package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.bo.SignupBo;


@WebServlet("/conn")
public class conn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public conn() {
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter obj=response.getWriter();

		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		String Mobile=request.getParameter("Mobile");
		String Password=request.getParameter("Password");
		
		
		SignupBo sb=new SignupBo();
		
		sb.setName(Name);
		sb.setEmail(Email);
		sb.setMobile(Mobile);
	    sb.setPassword(Password);
	    	    
	   int status=Dao.Signup(sb);
	   
	   if(status>0)	
	   {  
		   obj.print("<script> alert('Data has been successfully insert') </script>");
		   RequestDispatcher ps=request.getRequestDispatcher("login.html");
		   ps.include(request, response);
	   }
	   else {
		   obj.print("<script> alert('something went wrong !') </script>");
		   RequestDispatcher ps=request.getRequestDispatcher("Signup.html");
		   ps.include(request, response);
 
	   }	    
  }
}