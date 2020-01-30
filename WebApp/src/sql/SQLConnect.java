package sql;
import java.sql.*;
import java.util.*;

class record
{
	public int procedureID;
	String procedureDesc;
	int providerID;
	String providerName;
	String providerStreetAddress;
	String providerCity;
	String providerState;
	String providerZip;
	String HRR;
	int totalDischarges;
	float avgPayments;
	
}

public class SQLConnect 
	{
	
		static Connection con;
	
		
	
		public static void main(String[] args)
		{
//			LinkedList<String[]> ll = run();
//			System.out.println(ll.getFirst()[3]);
//			for(int i =0; i < ll.size(); i++)
//			{
//				String[] output = ll.get(i);
//				for(int p = 0; p < 5; p++)
//				{
//					System.out.print(output[p] + " ");
//				}
//				System.out.println();
//			}
			
			
		}
		
		public static String run()
		{
			System.out.println("echo");
			String s = test();
			//LinkedList<String[]> ll = getResults(1, 0, "0", "0", "0", "0", 0, 0);
			return s;
		}
	
		public static LinkedList<String[]> getResults(int procedureID, int providerID, String city, 
				String state, String procedureDesc, String providerName, int minPrice, int maxPrice)
		{
		
			
			
			
			try
			{
				Statement stmt = con.createStatement();
				System.out.println("test1");
				ResultSet rs = stmt.executeQuery("EXEC multipleSelectTest '" + procedureID +"', '" + providerID +"', '"+
												city+"', '"+state+"', '"+procedureDesc+"', '"+providerName+"', '"+minPrice
												+"', '"+maxPrice+"'");
				System.out.println("test2");
				rs.next();
				LinkedList<String[]> resultArray = new LinkedList<String[]>();
				while(rs.next())
				{
					String[] sArray = new String[5];
					for(int i=1; i < 6; i++)
					{
						sArray[i-1] = rs.getString(i);
						//System.out.println(sArray[i-1]);
					}
					resultArray.add(sArray);
					
				}
				
				return resultArray;
			}
			catch(Exception e)
			{
				System.out.println("error " + e.getMessage());
				return null;
			}
			
			
			
			
			
			
			
		
		}
		
		
		
		
		
		public static String[][] search(String table, String condition)
		{
			try
			{
				//Code taken from https://stackoverflow.com/questions/24547406/resultset-into-2d-array
				List<String[]> resultList = new ArrayList<>();
				int colCount = 5;	//Change this to no. of columns in table
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " " + condition);
			
				while (rs.next())
				{
					String[] col = new String[colCount];
					for (int i = 0; i < colCount; i++)
					{
						col[i] = rs.getString(i);
					}
					
					resultList.add(col);
					
				}
				
				String[][] returnString = resultList.toArray(new String[resultList.size()][]);
				return returnString;
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				return null;
			}
			
		}
		
		
		public static String test() 
		{
			try{
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String conURL = "jdbc:sqlserver://agileprojecttest875413.database.windows.net:1433;"
								+ "database=AgileProjectTest;"
								+ "user=agileprojecttestuser@agileprojecttest875413;"
								+ "password=HopeThis1Works;"
								+ "encrypt=true;"
								+ "trustServerCertificate=false;"
								+ "loginTimeout=30;";
				
				
				con = DriverManager.getConnection(conURL);
				
				
				
				
//				MysqlDataSource ds = new MysqlDataSource();
//				ds.setUser("agileprojectusertest");
//				ds.setPassword("HopeThis1Works");
//				ds.setServerName("agileprojecttest875413.database.windows.net");
//				
//				con = ds.getConnection();
				
				
				Statement stmt=con.createStatement(); 
				
				ResultSet rs=stmt.executeQuery("select * from health");  
				rs.next();
				rs.next();
				rs.next();
				rs.next();
				rs.next();
				String s = rs.getString(1);
				
				//con.close();
				
//				System.out.println("connected");
//				System.out.println(s);
				
				return s;
			}
			catch(Exception e) {return e.getMessage();}
		}
		
	}

