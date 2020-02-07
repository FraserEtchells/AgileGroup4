<%@
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.Output"
    import="sql.SQLConnect"
    import="java.util.LinkedList"
    import="java.util.Iterator"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Agile</title>
		
		<!-- External style sheets -->
		<link rel="stylesheet" type="text/css" href="css/util.css">
		<link rel="stylesheet" type="text/css" href="css/inputform.css">
		<link rel="stylesheet" type="text/css" href="css/table.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	
	<body>
	    <!-- Applies the Oswald font to the entire WebSite -->
	    <div id="oswaldFont">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="#">Craneware</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item active">
							<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
						</li>
					</ul>
				</div>
			</nav>
			
	  		<!-- Sets the background of the WebSite -->
	  		<div class="bg-results">
				<br>
	      		<div class="row">
	        		<div class="col-sm">
	          			<!-- Puts a margin to left of the search form -->
	          			<div class="filter-sm">
	            			<div class="pad">
	              				<!--Search form-->
	              				<form action="results.jsp">
	              					<div class="row">
	              	  					<div class="col">
	              	  						<input class="form-control" type="search" placeholder="Procedure" name="search">
	              	  					</div>
	              	  					<div class="col">
	              	  						<input class="form-control" type="search" placeholder="Condition" name="search">
	              	  					</div>
	              					</div>
	              					<br>
	                				<div class="row">
	                  					<div class="col">
						                    <label for="maxPrice">Max. Price</label>
						                    <input type="number" class="form-control" placeholder="1000000" name="maxPrice" min="0" max="1000000" id="maxPrice">
	                  					</div>
	                				</div>
	                				<br>
	                				<div class="row">
	                  					<div class="col">
	                    					<label for="area">Location</label>
	                    					<input type="search" class="form-control" placeholder="Location" id="area" name="location">
	                  					</div>
	                  					<div class="col">
	                    					<label for="distance">Distance</label>
                    						<select class="form-control" id="distance">
                      							<option>1 mile</option>
                      							<option>5 miles</option>
                      							<option>10 miles</option>
                      							<option>15 miles</option>
                      							<option>30 miles</option>
                      							<option>50 miles</option>
                      							<option>75 miles</option>
                      							<option>100 miles</option>
                    						</select>
	                  					</div>
	                				</div>
	                				<br>
	                				<button type="submit" name="submit" class="btn btn-primary btn-block">Submit</button>
	              				</form>
	            			</div>
	          			</div>
	        		</div>
	        		<div class ="col-sm-9">
	          			<!--The Table goes here-->
	          			<div class="tableProp">
	              			<table id="myTable" class="table">
	                			<thead class="thead-dark">
	                  				<tr>
	                    				<th scope="col" onclick="sortTable(0)">Procedure</th>
	                    				<th scope="col" onclick="sortTable(1)">Institute</th>
	                    				<th scope="col" onclick="sortTableNumericaly(2)">Average Price</th>
	                    				<th scope="col" onclick="sortTableNumericaly(3)">Distance</th>
	                    				<th scope="col" onclick="sortTableNumericaly(4)">Rank</th>
	                  				</tr>
	                			</thead>
	                			<%
	                				String searchParam = "1";
	                				String minPrice = "0";
	                				String maxPrice = "1000000";
	                
	                				if(request.getParameter("submit") != null)
	                				{
	                					searchParam = request.getParameter("search");
	                					minPrice = "0";
	                					maxPrice = request.getParameter("maxPrice");
	                				}
	                
	                				try
	                				{
	                					LinkedList<String[]> results = SQLConnect.run(searchParam, minPrice, maxPrice);
	                	
	                					out.println("<tbody>");

	                					Iterator<String[]> i = results.iterator();
	                	
					                	while(i.hasNext())
					                	{
					                		String[] s = i.next();
					                		out.println("<tr>");
					                		out.println("<td>" + s[0] + " " + s[1] + "</td>"); 		//Proccedure
					                		out.println("<td>" + s[3] + "</td>");					//Institute
					                		out.println("<td>" + "$" + String.format("%1.2f", Float.parseFloat(s[10])) + "</td>");	//Price
					                		out.println("<td>" + "Distance placeholder" + "</td>");	//Distance
					                		out.println("<td>" + "Rank placeholder" + "</td>");		//Rank
					                		out.println("</tr>");
					                	}
	                	
					                	out.println("</tbody>");
					                }
					                catch(Exception e)
					                {
					                	out.println("error (" + e.getMessage() + ")");
					                }
								%>
	              			</table>
	          			</div>
	        		</div>
	      		</div>
	      		
	      		<!-- Footer -->
			    <footer class="footer-dark bg-dark">
			    	&copy 2020 Copyright: Craneware
			    </footer>
	    	</div>
	    </div>
	</body>
	
	<!-- Internal JavaScript -->
	<script>
		function sortTable(n) {
		  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
		  table = document.getElementById("myTable");
		  switching = true;
		  // Set the sorting direction to ascending:
		  dir = "asc";
		  /* Make a loop that will continue until
		  no switching has been done: */
		  while (switching) {
		    // Start by saying: no switching is done:
		    switching = false;
		    rows = table.rows;
		    /* Loop through all table rows (except the
		    first, which contains table headers): */
		    for (i = 1; i < (rows.length - 1); i++) {
		      // Start by saying there should be no switching:
		      shouldSwitch = false;
		      /* Get the two elements you want to compare,
		      one from current row and one from the next: */
		      x = rows[i].getElementsByTagName("TD")[n];
		      y = rows[i + 1].getElementsByTagName("TD")[n];
		      /* Check if the two rows should switch place,
		      based on the direction, asc or desc: */
		      if (dir == "asc") {
		        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
		          // If so, mark as a switch and break the loop:
		          shouldSwitch = true;
		          break;
		        }
		      } else if (dir == "desc") {
		        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
		          // If so, mark as a switch and break the loop:
		          shouldSwitch = true;
		          break;
		        }
		      }
		    }
		    if (shouldSwitch) {
		      /* If a switch has been marked, make the switch
		      and mark that a switch has been done: */
		      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
		      switching = true;
		      // Each time a switch is done, increase this count by 1:
		      switchcount ++;
		    } else {
		      /* If no switching has been done AND the direction is "asc",
		      set the direction to "desc" and run the while loop again. */
		      if (switchcount == 0 && dir == "asc") {
		        dir = "desc";
		        switching = true;
		      }
		    }
		  }
		}
		
		function sortTableNumericaly(n) {
		  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
		  table = document.getElementById("myTable");
		  switching = true;
		  // Set the sorting direction to ascending:
		  dir = "asc";
		  /* Make a loop that will continue until
		  no switching has been done: */
		  while (switching) {
		    // Start by saying: no switching is done:
		    switching = false;
		    rows = table.rows;
		    /* Loop through all table rows (except the
		    first, which contains table headers): */
		    for (i = 1; i < (rows.length - 1); i++) {
		      // Start by saying there should be no switching:
		      shouldSwitch = false;
		      /* Get the two elements you want to compare,
		      one from current row and one from the next: */
		      x = rows[i].getElementsByTagName("TD")[n];
		      y = rows[i + 1].getElementsByTagName("TD")[n];
		      /* Check if the two rows should switch place,
		      based on the direction, asc or desc: */
		      if (dir == "asc") {
		        if (Number(x.innerHTML) > Number(y.innerHTML)) {
		          // If so, mark as a switch and break the loop:
		          shouldSwitch = true;
		          break;
		        }
		      } else if (dir == "desc") {
		        if (Number(x.innerHTML) < Number(y.innerHTML)) {
		          // If so, mark as a switch and break the loop:
		          shouldSwitch = true;
		          break;
		        }
		      }
		    }
		    if (shouldSwitch) {
		      /* If a switch has been marked, make the switch
		      and mark that a switch has been done: */
		      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
		      switching = true;
		      // Each time a switch is done, increase this count by 1:
		      switchcount ++;
		    } else {
		      /* If no switching has been done AND the direction is "asc",
		      set the direction to "desc" and run the while loop again. */
		      if (switchcount == 0 && dir == "asc") {
		        dir = "desc";
		        switching = true;
		      }
		    }
		  }
		}
		
		function makeTableScroll() {
		  // Constant retrieved from server-side via JSP
		  var maxRows = 10;
		
		  var table = document.getElementById('myTable');
		  var wrapper = table.parentNode;
		  var rowsInTable = table.rows.length;
		  var height = 0;
		  if (rowsInTable > maxRows) {
		    for (var i = 0; i < maxRows; i++) {
		      height += table.rows[i].clientHeight;
		    }
		    wrapper.style.height = height + "px";
		  }
		}
	</script>
</html>