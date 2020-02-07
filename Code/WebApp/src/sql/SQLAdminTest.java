package sql;
import java.sql.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SQLAdminTest {

	@Test
	void testParamPass() 
	{
		SQLAdmin testClass = new SQLAdmin("admin","admin");
		boolean paramPass = false;
		
		if(testClass.getUsername() == "admin" && testClass.getPassword() == "admin")
		{
			paramPass = true;
		}
		assertTrue(paramPass);
	}
	
	@Test
	void testSQLConnection()
	{
		Connection testCon = SQLAdmin.connectToDatabase("agileprojecttestuser", "HopeThis1Works");
		try {
			assertTrue(testCon.isValid(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
