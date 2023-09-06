package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.bo.SignupBo;
import java.io.PrintWriter;



/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id =Integer.parseInt(request.getParameter("id"));
		
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String Mobile = request.getParameter("Mobile");
		String Password = request.getParameter("Password");

		SignupBo sb = new SignupBo();
		
		sb.setId(id);
		sb.setName(Name);
		sb.setEmail(Email);
		sb.setMobile(Mobile);
		sb.setPassword(Password);
		
		int status = Dao.getupdateEmployee(sb);
				if(status>0)
		{
			pw.print("<script> alert('Data has been updated successfully...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("AllData.html");
			
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("AllData.html");
			
			rd.include(request, response);
			
			
		}
}
	}