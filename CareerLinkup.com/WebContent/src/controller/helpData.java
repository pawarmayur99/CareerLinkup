package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao_help;
import com.bo.helpBo;

/**
 * Servlet implementation class helpData
 */
@WebServlet("/helpData")
public class helpData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helpData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<table border='1px solid black' width='100%'>");
		pw.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		
		pw.print("<div> <h1>User Message Data</h1> </div>");
		
		pw.print("<tr> <th>Id</th>  <th>Name</th>  <th>Contact</th>  <th>Email</th>  <th>Message</th>  <th>Delete</th></tr>");
		
		    List<helpBo> list = Dao_help.GetAllRegisterUser();
		
		for(helpBo sb:list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td> <td>"+sb.getContact()+"</td> <td>"+sb.getEmail()+"</td> <td>"+sb.getMessage()+"</td><td><a href='HelpDelete?id="+sb.getId()+"'>Delete</a></td> </tr>");			
		}
		pw.print("<table>");
	}
}
