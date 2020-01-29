<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.Output"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agile Group 4</title>
<link href="css/mainPage.css" rel="stylesheet" type="text/css">
<body>
	<div class = "title-block">Hello</div>
	<% out.println("Hello World!");
	Output tester = new Output();
	int p = tester.numberWang();
	out.println(p);%>

</body>
</html>