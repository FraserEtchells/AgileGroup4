<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.Output"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Agile</title>

<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/inputform.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style>
   .scrollingTabl{
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
</head>
<body>
  <!--Sets a background to the website-->
  <div class="bg">
    <!--This applies the oswald font to the entire website-->
    <div id="oswaldFont">
      <!--Adds padding to the search bar-->
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
  </div>
</nav>
<br>
      <div class="row">
        <div class="col-sm">
          <!--Puts a margin to left of the filter-->
          <div class="filter">
            <div class="pad">
              <!--This is the Filter Form-->
              <!--TODO: add an action to the form-->
              <form action="">
              	<div class = "row">
              		<div class = "col">
              			<input class="form-control" type="search" placeholder="Procedure ID or Condition" name="search">
              			<br>
              		</div>
              	</div>
                <div class="row">
                  <div class="col">
                    <label for="minPrice">Min. Price</label>
                    <input type="number" class="form-control" placeholder="0" name="minPrice" min="0" max="1300000" id="minPrice">
                  </div>
                  <div class="col">
                    <label for="maxPrice">Max. Price</label>
                    <input type="number" class="form-control" placeholder="1300000" name="maxPrice" min="0" max="1300000" id="maxPrice">
                  </div>
                </div>
                <div class="row">
                  <div class="col">
                    <label for="area">Location</label>
                    <input type="text" class="form-control" placeholder="Location" id="area" name="location">
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
                <button type="submit" class="btn btn-primary">Submit</button>
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
                    <th scope="col" onclick="sortTableNumericaly(2)">Price</th>
                    <th scope="col" onclick="sortTableNumericaly(3)">Distance</th>
                    <th scope="col" onclick="sortTableNumericaly(4)">Rank</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>A871 - SEPTICEMIA OR SEVERE SEPSIS W/O MV >96 HOURS W MCC</td>
                    <td>HOUSTON METHODIST THE WOODLANDS HOSPITAL</td>
                    <td>1070</td>
                    <td>10</td>
                    <td>11</td>
                  </tr>
                  <tr>
                    <td>L037 - EXTRACRANIAL PROCEDURES W MCC</td>
                    <td>SOUTHEAST ALABAMA MEDICAL CENTER</td>
                    <td>100427</td>
                    <td>25</td>
                    <td>40</td>
                  </tr>
                  <tr>
                    <td>Y163 - MAJOR CHEST PROCEDURES W MCC</td>
                    <td>NEW TORK</td>
                    <td>22</td>
                    <td>1</td>
                    <td>2</td>
                  </tr>
                  <tr>
                    <td>MARRIAGE</td>
                    <td>UKRAINIAN PROSTITUTES</td>
                    <td>100</td>
                    <td>1000</td>
                    <td>3</td>
                  </tr>
                  <tr>
                    <td>MARRIAGE</td>
                    <td>UKRAINIAN PROSTITUTES</td>
                    <td>100</td>
                    <td>1000</td>
                    <td>3</td>
                  </tr>
                  <tr>
                    <td>MARRIAGE</td>
                    <td>UKRAINIAN PROSTITUTES</td>
                    <td>100</td>
                    <td>1000</td>
                    <td>3</td>
                  </tr>
                  <tr>
                    <td>MARRIAGE</td>
                    <td>UKRAINIAN PROSTITUTES</td>
                    <td>100</td>
                    <td>1000</td>
                    <td>3</td>
                  </tr>
                  <tr>
                    <td>MARRIAGE</td>
                    <td>UKRAINIAN PROSTITUTES</td>
                    <td>100</td>
                    <td>1000</td>
                    <td>3</td>
                  </tr>
                  <tr>
                    <td>MARRIAGE</td>
                    <td>UKRAINIAN PROSTITUTES</td>
                    <td>100</td>
                    <td>1000</td>
                    <td>3</td>
                  </tr>
                  <tr>
                    <td>MARRIAGE</td>
                    <td>UKRAINIAN PROSTITUTES</td>
                    <td>100</td>
                    <td>1000</td>
                    <td>3</td>
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