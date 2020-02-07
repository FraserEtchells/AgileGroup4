function toRadians(x){
  return x * Math.PI/180;
};

//This function calculates the distance between 2 coordinates.
function haversine(lat1,lon1,lat2,lon2)
{
  //Calculating half of the change in distance between the points.
  var halfLon = toRadians((lat1 - lat2))/2;
  var halfLat = toRadians((lon1 - lon2))/2;
  lat1 = toRadians(lat1);
  lat2 = toRadians(lat2);
  //Earth's Radius in kilometers
  var earthRad = 6371;
  //Calculating the
  var a = Math.sin(halfLat) * Math.sin(halfLat) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(halfLon) * Math.sin(halfLon);
  var angularDist = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  return earthRad * angularDist;
};

haversine(38.39,-89.35,32.1,-101.34);

var api = new H.service.Platform({
  apikey: '10UmFtAGly-G0AEFjDot_PuKKz4nsfHnOryzfp-EYzg'
});

// Obtain the default map types from the platform object:
var defaultLayers = api.createDefaultLayers();

// Instantiate (and display) a map object:
var map = new H.Map(document.getElementById('mapContainer'), defaultLayers.vector.normal.map, {center: { lat: 39, lng: -104 }, zoom: 3.6, pixelRatio: window.devicePixelRatio || 1 });

//Stores markup for a Hospital Icon.
var svgMarkup = '<svg width="24" height="24" ' +
        'xmlns="http://www.w3.org/2000/svg">' +
        '<rect stroke="white" fill="#1b468d" x="1" y="1" width="22" ' +
        'height="22" /><text x="12" y="18" font-size="12pt" ' +
        'font-family="Arial" font-weight="bold" text-anchor="middle" ' +
        'fill="white">H</text></svg>';

// Create an icon, an object holding the latitude and longitude, and a marker:
var icon = new H.map.Icon(svgMarkup),
    coords = {lat: 39, lng: -104},
    marker = new H.map.Marker(coords, {icon: icon});

  // Add the marker to the map and center the map at the location of the marker:
  map.addObject(marker);

//instantiate map events to allow for map interaction on supported devices.
var mapEvents = new H.mapevents.MapEvents(map);
new H.mapevents.Behavior(mapEvents);

//Applies default UI to map for zooming and viewing layers.
var ui = H.ui.UI.createDefault(map, defaultLayers, 'en-US');

//Set location and content for a speech bubble.
var bubble = new H.ui.InfoBubble({lat: 39, lng: -103},{
  content:'<p>Hospital</p>'
});

//Add bubble to map
ui.addBubble(bubble);

// Create the parameters for the geocoding request:
var geocodingParams = {
      searchText: 'Texas'
    };


// Define a callback function to process the geocoding response:
var onResult = function(result) {
  var locations = result.Response.View[0].Result,
      position,
      marker;
  // Add a marker for each location found
//  for (i = 0;  i < locations.length; i++) {
//    position = {
//      lat: locations[i].Location.DisplayPosition.Latitude,
//      lng: locations[i].Location.DisplayPosition.Longitude
//    };
//    marker = new H.map.Marker(position, {icon: icon});
//    map.addObject(marker);
//  }

  position = {
	      lat: locations[0].Location.DisplayPosition.Latitude,
	      lng: locations[0].Location.DisplayPosition.Longitude
	    };

  marker = new H.map.Marker(position, {icon: icon});

	    map.addObject(marker);

};

var moveMap = function(result) {
  var locations = result.Response.View[0].Result,
      position,
      marker;

  // Add a marker for each location found
//  for (i = 0;  i < locations.length; i++) {
//    position = {
//      lat: locations[i].Location.DisplayPosition.Latitude,
//      lng: locations[i].Location.DisplayPosition.Longitude
//    };
//    marker = new H.map.Marker(position, {icon: icon});
//    map.addObject(marker);
//  }

  position = {
        lat: locations[0].Location.DisplayPosition.Latitude,
        lng: locations[0].Location.DisplayPosition.Longitude
      };
      alert(locations[0].Location.DisplayPosition.Latitude);
      alert(locations[0].Location.DisplayPosition.Longitude);
      map.setZoom(4);
      map.setCenter({lat:locations[0].Location.DisplayPosition.Latitude, lng:locations[0].Location.DisplayPosition.Longitude});

};

var getCoords = function(result) {

  var locations = result.Response.View[0].Result,
      position,
      marker;

  var startLat = document.getElementById("startLat").innerHTML;
  var startLng = document.getElementById("startLng").innerHTML;
  
  alert("long - " + locations[0].Location.DisplayPosition.Latitude);
  
  	var count = parseInt(document.getElementById("p0").innerHTML, 10);
  
	  //document.getElementById("p0").innerHTML = locations[0].Location.DisplayPosition.Latitude;
	  //document.getElementById("p1").innerHTML = locations[0].Location.DisplayPosition.Longitude;
	  
  	var idDist = "distance" + count;
  	alert("id = " + idDist);
  	document.getElementById(idDist).innerHTML = haversine(startLat,startLng,locations[0].Location.DisplayPosition.Latitude,locations[0].Location.DisplayPosition.Longitude);
  	count = count + 1;
  	document.getElementById("p0").innerHTML = count;
 
}

var getCoordsForSetLocation = function(result) {

	  var locations = result.Response.View[0].Result,
	      position,
	      marker;

	  
	  alert("long - " + locations[0].Location.DisplayPosition.Latitude);
	  
	  
	  
		  document.getElementById("startLat").innerHTML = locations[0].Location.DisplayPosition.Latitude;
		  document.getElementById("startLng").innerHTML = locations[0].Location.DisplayPosition.Longitude;
		  
	  
	  
	 
	}



// Get an instance of the geocoding service:
var geocoder = api.getGeocodingService();

// Call the geocode method with the geocoding parameters,
// the callback and an error callback function (called if a
// communication error occurs):
function addLocationToMap(address) {
  geocodingParams = {searchText: address, country: "USA"};


  geocoder.geocode(geocodingParams, onResult, function(e) {
  alert(e);
});
}

function zoomToLocation(address) {

geocodingParams = {searchText: address};

geocoder.geocode(geocodingParams, moveMap, function(e) {
alert(e);
});
}


function convertAddressToCoords(address, setLocation) {

	alert(address);
geocodingParams = {searchText: address, country: "USA"};
if(setLocation)
	{
	geocoder.geocode(geocodingParams, getCoordsForSetLocation, function(e) {
		alert(e);
		});
	}
else
	{
	geocoder.geocode(geocodingParams, getCoords, function(e) {
		alert(e);
		});
	}

}


