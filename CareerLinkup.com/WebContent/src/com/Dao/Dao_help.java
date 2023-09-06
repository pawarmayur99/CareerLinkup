package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.SignupBo;
import com.bo.helpBo;


public class Dao_help
    {
	
	public static Connection getconnection() 
	{
	   Connection con=null;
	   
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/march","root","pawar1616");
					
	} 
	   catch (Exception e) 
	   {
		e.printStackTrace();
	}   
	   return con;
	}
    
public static int help(helpBo sb) 
{
  int status=0;
  
  try
  {
    Connection con=Dao_help.getconnection();
     String  sql="insert into help(name,contact,email,message) values(?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(sql);
         
		ps.setString(1, sb.getName());
		ps.setString(2, sb.getContact());
		ps.setString(3, sb.getEmail());
		ps.setString(4, sb.getMessage());
			
	   status=ps.executeUpdate();
		} 
  catch (Exception e)
  {
	   e.printStackTrace();
 }
  return status;
	
    }



public static List GetAllRegisterUser()
{
	ArrayList<helpBo> list=new ArrayList<helpBo>();
	
	try 
	{
	   Connection con=Dao_help.getconnection();	
    	String sql="select *from help";
	    PreparedStatement ps=con.prepareStatement(sql);
	    ResultSet rs=ps.executeQuery();
	    
	    while(rs.next())
	    {
	    	helpBo sb=new helpBo();
	    	
	    	sb.setId(rs.getInt(1));
	    	sb.setName(rs.getNString(2));
	    	sb.setContact(rs.getString(3));
	    	sb.setEmail(rs.getString(4));
	    	sb.setMessage(rs.getString(5));
	    	
	    	list.add(sb);
	    }
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	}    	
	return list;
}




public static int getdeleteData(int id)
{
	int status = 0;
	
	try 
	{
		Connection con = Dao_help.getconnection();
		
		String sql = "delete from help where id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		status = ps.executeUpdate();
		
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	return status;	
}
}

