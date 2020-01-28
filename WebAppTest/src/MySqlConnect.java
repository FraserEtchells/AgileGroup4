import java.sql.*;

public class MySqlConnect 
	{
		public static void test() 
		{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql:agileprojecttest875413.database.windows.net/agileprojecttest975413",
														"agileprojectusertest", 	"HopeThis1Works");

				con.close();
			}
			catch(Exception e) {System.out.println(e);}
		}
		
	}

