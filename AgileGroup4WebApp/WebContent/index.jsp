<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "classes.outputTest"
    import = "classes.MySqlConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agile Group 4 Home</title>
</head>
<body>
	<% out.println("Tom is taking over this website please");
	//MySqlConnect con = new MySqlConnect();
	out.println(MySqlConnect.test());%>
</body>
</html>