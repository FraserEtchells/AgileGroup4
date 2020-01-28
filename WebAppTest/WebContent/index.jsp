<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="PackageTest.outputTest"
    import="java.sql.*,java.util.*,java.io.*"
    import="javax.servlet.http.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
	<b><% out.println("Hello World!"); %></b>
	<%
		outputTest n = new outputTest();
	
		out.println(n.testOutput());
	%>
</body>
</html>