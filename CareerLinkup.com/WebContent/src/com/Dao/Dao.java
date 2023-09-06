package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.SignupBo;

public class Dao
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
    
public static int Signup(SignupBo sb) 
{
  int status=0;
  try
  {
    Connection con=Dao.getconnection();
     String  sql="insert into CareerLinkup(Name,Email,Mobile,Password) values(?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(sql);
         
		ps.setString(1, sb.getName());
		ps.setString(2, sb.getEmail());
		ps.setString(3, sb.getMobile());
		ps.setString(4, sb.getPassword());
		
	   status=ps.executeUpdate();
		} 
  catch (Exception e)
  {
	   e.printStackTrace();
 }
  return status;
  }

    public static boolean login(String Email,String Password) {
    	
    	boolean status=false;
    	
    	try 
    	{
    	   Connection con=Dao.getconnection();	
			 String sql="select *from CareerLinkup where Email=? and Password=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Email);
            ps.setString(2, Password);			 
			 ResultSet rs= ps.executeQuery();
		      status=rs.next();
    	} 
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	return status;
    }

    public static List GetAllRegisterUser()
    {
    	ArrayList<SignupBo> list=new ArrayList<SignupBo>();
    	
    	try 
    	{
		   Connection con=Dao.getconnection();	
	    	String sql="select *from CareerLinkup";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    
		    while(rs.next())
		    {
		    	SignupBo sb=new SignupBo();
		    	
		    	sb.setId(rs.getInt(1));
		    	sb.setName(rs.getNString(2));
		    	sb.setEmail(rs.getNString(3));
		    	sb.setPassword(rs.getNString(4));
		    	sb.setMobile(rs.getNString(5));
		    	
		    	list.add(sb);
		    }
    	} 
    	catch (Exception e)
    	{
    		e.printStackTrace();
		}    	
    	return list;
    }
          
  public static boolean reset(String Email,String Password) {
    	
    	boolean status=false;
    	
    	try 
    	{
    	   Connection con=Dao.getconnection();	
           String sql = "UPDATE CareerLinkup SET Password = ? WHERE Email = ?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, Password);
			 ps.setString(2, Email);
            			 
			 int execute = ps.executeUpdate();
		        status = (execute > 0);		      
    	} 
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	return status;
    }

  	
  public static SignupBo getEmployeeDataById(int id)
	{
		
		SignupBo sb = new SignupBo();
		
		try 
		{
			Connection con = Dao.getconnection();
			
			String sql = "select * from CareerLinkup where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				sb.setId(rs.getInt(1));
				sb.setName(rs.getString(2));
				sb.setEmail(rs.getString(3));
				sb.setMobile(rs.getString(4));
				sb.setPassword(rs.getString(5));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sb;	
	}
	
	
	public static int getupdateEmployee(SignupBo sb)
	{
		int status = 0;
		
		try 
		{
			Connection con = Dao.getconnection();
			
			String sql = "update CareerLinkup set Name=?, Email=?, Mobile=?, Password=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getEmail());
			ps.setString(3, sb.getMobile());
			ps.setString(4, sb.getPassword());
			
			ps.setInt(5, sb.getId());
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
	public static int getdeleteEmployee(int id)
	{
		int status = 0;
		
		try 
		{
			Connection con = Dao.getconnection();
			
			String sql = "delete from CareerLinkup where id=?";
			
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
  

  