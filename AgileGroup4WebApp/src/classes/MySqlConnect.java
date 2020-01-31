package classes;
import java.sql.*;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MySqlConnect 
	{
	
		public static void main(String[] args)
		{
			System.out.print((test()));
		}
	
	
		public static String test() 
		{
			try{
				/*
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql:agileprojecttest875413.database.windows.net/agileprojecttest975413",
														"agileprojectusertest", 	"HopeThis1Works");
				*/
				MysqlDataSource ds = new MysqlDataSource();
				ds.setUser("19ac3u07");
				ds.setPassword("ac33b1");
				ds.setServerName("silva.computing.dundee.ac.uk/19ac3d07");
				
				Connection con = ds.getConnection();
				
				
				Statement stmt=con.createStatement(); 
				
				ResultSet rs=stmt.executeQuery("select * from view_shops");  
				rs.next();
				rs.next();
				rs.next();
				rs.next();
				rs.next();
				String s = rs.getString(1);
				
				con.close();
				
				return "success kinda";
			}
			catch(Exception e) {return "error " + e.getMessage();}
		}
		
	}

