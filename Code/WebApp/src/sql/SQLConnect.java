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
			LinkedList<String[]> ll = run("1", "0", "0");
			//System.out.println(ll.getFirst()[3]);
			for(int i =0; i < ll.getFirst().length; i++)
			{
				System.out.println(ll.getFirst()[i]);
			}
			
			
		}
		
		public static LinkedList<String[]> run(String searchParam, String minPrice, String maxPrice)
		{
			try
			{
				if(connectToDatabase())
				{
					LinkedList<String[]> ll = getResults(searchParam, 0, "0", "0", searchParam, "0", minPrice, maxPrice);
					return ll;
				}
				else
				{
					System.out.println("Couldnt connect");
					return null;
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
			
			//
		}
	
		public static LinkedList<String[]> getResults(String procedureID, int providerID, String city, 
				String state, String procedureDesc, String providerName, String minPrice, String maxPrice)
		{
		
			try
			{
				//See if procedureID is an int
				int procIDInt = Integer.parseInt(procedureID);
				procedureDesc = "0";
			}
			catch(Exception e)
			{
				procedureID = "0";
			}
			
			
			try
			{
				Statement stmt = con.createStatement();
				System.out.println("test1");
				ResultSet rs = stmt.executeQuery("EXEC multipleSelectTest '" + procedureID +"', '" + providerID +"', '"+
												city+"', '"+state+"', '"+procedureDesc+"', '"+providerName+"', '"+minPrice
												+"', '"+maxPrice+"'");
				System.out.println("test2");
				rs.next();
				LinkedList<String[]> results = new LinkedList<String[]>();
				while(rs.next() && results.size() < 50) {
					String[] temp = new String[11];
					temp[0] = rs.getString(1);
					temp[1] = rs.getString(2);
					temp[2] = rs.getString(3);
					temp[3] = rs.getString(4);
					temp[4] = rs.getString(5);
					temp[5] = rs.getString(6);
					temp[6] = rs.getString(7);	//!
					
					results.add(temp);
				}
				
				
            	
//            	System.out.println("<tbody>");
            	
            	
//            	Iterator<String[]> i = results.iterator();
//            	
//            	while(i.hasNext())
//            	{
//            		String[] s = i.next();
//            		System.out.println("<td>" + s[0] + " " + s[1] + "</td>"); 	//Proccedure
//            		System.out.println("<td>" + s[3] + "</td>");				//Institute
//            		System.out.println("<td>" + s[10] + "</td>");				//Price
//            		System.out.println("<td>" + "Distance placeholder" + "</td>");				//Distance
//            		System.out.println("<td>" + "Rank placeholder" + "</td>");				//Rank
//            	}
//            	
//            	System.out.println("</tbody>");
				
				return results;
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
		
		
		public static boolean connectToDatabase() 
		{
			try{
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				String conURL = "jdbc:sqlserver://agileprojecttest875413.database.windows.net:1433;"
								+ "database=AgileProjectTest;"
								+ "user=agileprojecttestuser@agileprojecttest875413;"
								+ "password=HopeThis1Works;"
								+ "encrypt=true;"
								+ "trustServerCertificate=false;"
								+ "loginTimeout=30;";
				
				
				con = DriverManager.getConnection(conURL);
				
				
				
				return true;
			}
			catch(Exception e) {System.out.print(e.getMessage()); return false;}
		}
		
	}

