package sql;
import java.sql.*;
import java.util.*;

public class SQLAdmin {
	String username;
	String password;
	static Connection con;
	
	public SQLAdmin(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
//	public static LinkedList<String[]> getLoginDetails()
//	{
//		
//	}
	

	public static Connection connectToDatabase(String username, String password) 
	{
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String conURL = "jdbc:sqlserver://agileprojecttest875413.database.windows.net:1433;"
							+ "database=AgileProjectTest;"
							+ "user=" + username + "@agileprojecttest875413;"
							+ "password="+ password +";"
							+ "encrypt=true;"
							+ "trustServerCertificate=false;"
							+ "loginTimeout=30;";
			
			
			con = DriverManager.getConnection(conURL);
			
			
			
			return con;
		}
		catch(Exception e) {System.out.print(e.getMessage());return con;}
	}
	

}
