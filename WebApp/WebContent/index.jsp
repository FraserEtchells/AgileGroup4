<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.Output"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Agile</title>

<link href="../css/mainPage.css" rel="stylesheet" type="text/css">
<link href="../css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href=".../css/util.css">
<link rel="stylesheet" type="text/css" href=".../css/inputform.css">
<link rel="stylesheet" type="text/css" href=".../css/table.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style>
   .scrollingTable {
       overflow-y: auto;
      }

      .formBorder {
        width:1170px;
        border-style: solid;
        border-width: 5px;
        border-color: white;
        background:#fcbe03;
        padding: 10px;
      }
   </style>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Craneware Healthcare</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active">
						<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					</li>
				</ul>
			</div>
	</nav>
	
	<div class = "flex-container">
	<div>1</div>
	<div>2</div>
	<div>3</div>
	</div>
	
	<div class = "section-container">
	
	<form class="formBorder">
					<div class="containter">
						<div class="mx-2">
							<div class="row">
								<!--First column - The search label-->
								<div class="col-1">
									Search by:
								</div>
								<!--Second column - The search criteria-->
								<div class="col-3">
									<div class="row">
										<div class="col-4">
											<input type="radio" name="searchType" value="procedure"> Procedure
										</div>
										<div class="col-8">
											<input type="radio" name="searchType" value="condition"> Condition
										</div>
									</div>
									<div class="row">
										<div class="col">
											<input type="text" class="form-control" placeholder="" name="searchTerm" id="search">
										</div>
									</div>
								</div>
								<!--Third column - The filer label-->
								<div class="col-1">
									Filters:
								</div>
								<!--Fourth column - The filters-->
								<div class="col-7">
									<!--Price filter-->
									<div class="row">
										<div class="col-1">
										</div>
										<div class="col" style="width">
											<input type="number" class="form-control" placeholder="Min Price" name="minPrice" min="0" max="1300000" id="minPrice">
										</div>
										<div class="col-1">
										</div>
										<div class="col">
											<input type="number" class="form-control" placeholder="Max Price" name="maxPrice" min="0" max="1300000" id="maxPrice">
										</div>
									</div>
									<!--Location filter-->
									<div class="row" style="padding-top:10px">
                    <label class="switch">
                      <input type="checkbox" checked>
                      <span class="slider round"></span>
                    </label>
										<div class="col-5">
											<input type="text" class="form-control" placeholder="Location" id="area">
										</div>
										<div class="col-1">
										</div>
										<div class="col">
											<select class="form-control" id="distance" placeholder="Max Price">
												<option value="" disabled selected>Distance</option>
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
								</div>
							</div>
						</div>
					</div>
					<br>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
	
	</div>	
	
	<div class = "section-container">
		<b>Table here</b>
		<div class="limiter">
          <div class="container-table100">
            <div class="wrap-table100">
              <div class="table100 scrollingTable">
                <table id="myTable">
                  <thead>
                    <tr class="table100-head">
                      <th class="column1" onclick="sortTable(0)">Procedure</th>
                      <th class="column2" onclick="sortTable(1)">Institute</th>
                      <th class="column3" onclick="sortTableNumericaly(2)">Price ($) </th>
                      <th class="column4" onclick="sortTableNumericaly(3)">Distance (KM)</th>
                      <th class="column5" onclick="sortTableNumericaly(4)">Rank</th>
                    </tr>
                  </thead>
                  <tbody>
                      <tr>
                        <td class="column1">A871 - SEPTICEMIA OR SEVERE SEPSIS W/O MV >96 HOURS W MCC</td>
                        <td class="column2">HOUSTON METHODIST THE WOODLANDS HOSPITAL</td>
                        <td class="column3">1070</td>
                        <td class="column4">10</td>
                        <td class="column5">11</td>
                      </tr>
                      <tr>
                        <td class="column1">L037 - EXTRACRANIAL PROCEDURES W MCC</td>
                        <td class="column2">SOUTHEAST ALABAMA MEDICAL CENTER</td>
                        <td class="column3">100427</td>
                        <td class="column4">25</td>
                        <td class="column5">40</td>
                      </tr>
                      <tr>
                        <td class="column1">Y163 - MAJOR CHEST PROCEDURES W MCC</td>
                        <td class="column2">NEW TORK</td>
                        <td class="column3">22</td>
                        <td class="column4">1</td>
                        <td class="column5">2</td>
                      </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
	
	</div>

</body>

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