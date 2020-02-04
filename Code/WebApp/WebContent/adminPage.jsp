<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="css/adminPage.css">
</head>
<body>
  <center><div>
    <form action="updateDatabase.jsp" method="post" enctype="multipart/form-data"> Select CSV file to upload:
      <input type="file" name="fileToUpload" id="fileToUpload">
      <input class="styled" type="submit" value="Upload Dataset" name="submit">
    </form>
  </div></center>

</body>
</html>
