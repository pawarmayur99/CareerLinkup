package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.bo.SignupBo;


@WebServlet("/AllRefisterUser")
public class AllRefisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AllRefisterUser() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		
		pw.print("<table border='1px solid black' width='100%'>");
		pw.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		
		pw.print("<div> <h1>User SignUp Data And Login Data</h1> </div>");
		
		pw.print("<tr> <th>Id</th>  <th>Name</th>  <th>Email</th>  <th>Mobile</th>  <th>Password</th>  <th>Update</th> <th>Delete</th> </tr>");
		
		    List<SignupBo> list = Dao.GetAllRegisterUser();
		
		for(SignupBo sb:list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td> <td>"+sb.getEmail()+"</td> <td>"+sb.getPassword()+"</td> <td>"+sb.getMobile()+"</td> <td><a href='editServlet?id="+sb.getId()+"'> Edit </a> </td> <td><a href='DeleteController?id="+sb.getId()+"'>Delete </a></td> </tr>");			
		}
		pw.print("<table>");
	}

}
