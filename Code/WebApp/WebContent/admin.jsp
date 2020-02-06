<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "sql.SQLAdmin"
    import = "java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/inputform.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>



<div id = "oswaldFont">

		<div class="loginPageTop">
		<a>Craneware - Administrator Login</a>
		</div>
		
		<div class="row">
        	<div class="col-sm">
        	    <div class="loginForm">
        	      <form action="admin.jsp">
        	        <div class="row">
        	          <div class="col">
        	            <label for="username">Username</label>
        	            <input type="text" class="form-control" placeholder="Username" name="username" id="username">
        	          </div>
        	          <div class="col">
        	            <label for="password">Password</label>
        	            <input type="password" class="form-control" placeholder="Password" name="password" id="password">
        	          </div>
        	        </div>
        	        <br>
        	        <button type="submit" name="loginSubmit" class="btn btn-primary btn-block">Submit</button>
        	      </form>
        	    </div>
        	</div>
		</div>
</div>

<%
                String username = " ";
                String password = " ";
                
                if(request.getParameter("loginSubmit") != null)
                {
                	username = request.getParameter("username");
                	password = request.getParameter("password");
                	
                	try{
                    	Connection con = SQLAdmin.connectToDatabase(username, password);
                    	if(con.isValid(0) == true)
                    	{
                    		out.println("Success - Valid connection");
                    		  Cookie validUser = new Cookie("validUser","true");
                    		  response.addCookie( validUser);
                    		  //String redirectURL = request.getAttribute("javax.servlet.forward.request_uri").toString();
                    		 // out.println(redirectURL);
                    		 // response.sendRedirect("");
                    		 out.println("<script>window.location.href='index.jsp'</script>");
                    	}
                    
                    }
                    catch(Exception e)
                    {
                    	out.println("error (" + e.getMessage() + ")");
                    }
                	
                }
                
%>

</body>
</html>