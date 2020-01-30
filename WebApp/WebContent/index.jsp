<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.Output"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agile</title>
<link href="../css/mainPage.css" rel="stylesheet" type="text/css">
<body>

	<div class = "section-container">
	
		<div class = "title">
			<b> Craneware Tech </b>
		</div>
		
	</div>
	
	<div class = "flex-container">
	<div>1</div>
	<div>2</div>
	<div>3</div>
	</div>
	
	<div class = "section-container">
	
		<b>Input forms here</b>
	
	</div>	
	
	<div class = "section-container">
		<b>Table here</b>
		<% out.println("Hello World!");
		Output tester = new Output();
		int p = tester.numberWang();
		out.println(p);%>
	
	</div>

</body>
</html>