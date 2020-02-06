<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "sql.SQLAdmin"
    import = "java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/inputform.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
	Cookie cookie = null;
	Cookie[] cookies = null;
	String username = " ";
	String password = " ";
	
	cookies = request.getCookies();
	
	if(cookies != null)
	{
		out.println("Cookies found");
	}
	else
	{
		out.println("No cookie found");
	}
	
	cookie = cookies[0];
	
	for(int i = 0; i < cookies.length; i++)
	{
		if(cookies[i].getName().equals("validUser"))
		{
			if(cookies[i].getValue().equals("true"))
			{
				out.println("Successfully transferred");
				
				for(int j = 0; j < cookies.length; j++)
				{
					if(cookies[j].getName().equals("username"))
					{
						username = cookies[j].getValue();
					}
					
					else if(cookies[j].getName().equals("password"))
					{
						password = cookies[j].getValue();	
					}
				}
				
				try
				{
					Connection con = SQLAdmin.connectToDatabase(username, password);
					
					if(con.isValid(0))
					{
						out.println("Complete Success!");
					}
				}
				catch(Exception e)
                {
                	out.println("error (" + e.getMessage() + ")");
                }
			}
		}
	}

%>
</body>
</html>