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

/**
 * Servlet implementation class resetPassword
 */
@WebServlet("/resetPassword")
public class resetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	    String Email=request.getParameter("Email");
	    String Password=request.getParameter("Password");
	    
	   if(Dao.reset(Email, Password))
	   {
		   pw.print("<script> alert('Password reset successfully') </script>");
		   RequestDispatcher rd=request.getRequestDispatcher("login.html");
		   rd.include(request, response);
		   		   
	   }
	   else
	   {
		   pw.print("<script> alert('Password not reset successfully. Please try again.'') </script>");
		   RequestDispatcher rd=request.getRequestDispatcher("login.html");
		   rd.include(request, response); 
	   }
	    
   
	}
	}

