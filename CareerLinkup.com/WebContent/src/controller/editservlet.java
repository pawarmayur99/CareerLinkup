package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.bo.SignupBo;

@WebServlet("/editServlet")
public class editservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public editservlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		int id =Integer.parseInt(request.getParameter("id"));
		
		SignupBo sb = Dao.getEmployeeDataById(id);
		
		
		pw.print("<title>Edit Form</title>");
		pw.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"edit.css\">");
		
		pw.print("<form action='UpdateController' method='post'>");
		
		pw.print("<h1>Form</h1>");
		
		pw.print("<table>");
		
		pw.print("<tr><td>Id: </td> <td> <input type='text' name='id' value='"+sb.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name: </td> <td> <input type='text' name='Name' value='"+sb.getName()+"'/></td></tr>");
		pw.print("<tr><td>Email: </td> <td> <input type='text' name='Email' value='"+sb.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Mobile: </td> <td> <input type='text' name='Mobile' value='"+sb.getMobile()+"'/></td></tr>");
		pw.print("<tr><td>Password: </td> <td> <input type='text' name='Password' value='"+sb.getPassword()+"'/></td></tr>");
		
	
		pw.print("<tr> <td><div> <input type='submit' value='Update' class='btn'/> </div></td></tr>");
		
		pw.print("</table>");
		
		pw.print("</form>");
    }
}
