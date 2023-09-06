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



/**
 * Servlet implementation class HelpDelete
 */
@WebServlet("/HelpDelete")
public class HelpDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		
		int status = Dao_help.getdeleteData(id);		
		if(status>0)
		{
			pw.print("<script> alert('Data has been deleted successfully...') </script>");
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


