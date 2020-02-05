package sql;

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
		assertTrue(SQLAdmin.connectToDatabase("adminUser", "098AccessTheDatabase!"));
	}

}
