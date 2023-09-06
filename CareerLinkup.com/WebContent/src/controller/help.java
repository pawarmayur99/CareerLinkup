package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao_help;
import com.bo.helpBo;

/**
 * Servlet implementation class help
 */
@WebServlet("/help")
public class help extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public help() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter obj=response.getWriter();

		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		
	
		helpBo sb=new helpBo();
		sb.setName(name);
		sb.setContact(contact);
		sb.setEmail(email);
	    sb.setMessage(message);
	    	    
	   int status=Dao_help.help(sb);
	   
	   if(status>0)	
	   {
		   obj.print("<script> alert('Your query has been submitted successfully. We will get back to you within 2 working days.') </script>");
		   RequestDispatcher ps=request.getRequestDispatcher("helpPage.html");
		   ps.include(request, response);

	   }
	   else {
		 
		   obj.print("<script> alert('something went wrong !') </script>");
		  // RequestDispatcher ps=request.getRequestDispatcher("login.html");
		  // ps.include(request, response);

 
	   }
	}
}
