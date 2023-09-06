//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@WebServlet("/HomeController")
//public class home extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//  
//    public home() {
//        super();
//    }
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//		PrintWriter pw=response.getWriter();
//		
//		HttpSession session=request.getSession();
//		String Email=(String)session.getAttribute("Email");
//		
//		if(Email!=null)
//		{
//			pw.print(Email);
//		}
//		else
//		{
//			pw.print("<script> alert('Please log in First') </script>");
//			RequestDispatcher rd=request.getRequestDispatcher("login.html");
//			rd.include(request, response);
//			
//		}
//		
//		//pw.print("<a href='logout'>Logout</a> ");
//	}
//
//	
//
//}