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

        // Create a hospital icon:
        var icon = new H.map.Icon(svgMarkup);






//instantiate map events to allow for map interaction on supported devices.
var mapEvents = new H.mapevents.MapEvents(map);
new H.mapevents.Behavior(mapEvents);

//Applies default UI to map for zooming and viewing layers.
var ui = H.ui.UI.createDefault(map, defaultLayers, 'en-US');















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

      addMarker(position,locations[0].Location.Address.Label);
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
      map.setZoom(10);
      map.setCenter({lat:locations[0].Location.DisplayPosition.Latitude, lng:locations[0].Location.DisplayPosition.Longitude});

};

var getCoords = function(result) {

  var locations = result.Response.View[0].Result,
      position,
      marker;

  var startLat = document.getElementById("startLat").innerHTML;
  var startLng = document.getElementById("startLng").innerHTML;



  	var count = parseInt(document.getElementById("p0").innerHTML, 10);

	  //document.getElementById("p0").innerHTML = locations[0].Location.DisplayPosition.Latitude;
	  //document.getElementById("p1").innerHTML = locations[0].Location.DisplayPosition.Longitude;

  	var idDist = "distance" + count;
  	document.getElementById(idDist).innerHTML = haversine(startLat,startLng,locations[0].Location.DisplayPosition.Latitude,locations[0].Location.DisplayPosition.Longitude);
  	count = count + 1;
  	document.getElementById("p0").innerHTML = count;

}

var getCoordsForSetLocation = function(result) {

	  var locations = result.Response.View[0].Result,
	      position,
	      marker;

	  var lat = locations[0].Location.DisplayPosition.Latitude;
    var lng = locations[0].Location.DisplayPosition.Longitude;

		  document.getElementById("startLat").innerHTML = lat;
		  document.getElementById("startLng").innerHTML = lng;

      alert("Location = " + lat + ", " + lng);






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

map.setCenter({lat:39,lng: -104});
/**
 * Will add the marker to the map and attach and eventlistener to the marker.
 * @param marker An H.map.Marker Object
 * @returns
 */
function addMarker(coords,address){
	var prin = '<h5>' + address +'</h6>';
	marker = new H.map.Marker(coords, {icon: icon, data: prin});
	map.addObject(marker);
	marker.addEventListener('tap',function(evt){
		var markers = map.getObjects();
		if(markers.includes(evt.target)){
			var bubble = new H.ui.InfoBubble({lat: evt.target.getGeometry().lat,lng:evt.target.getGeometry().lng},{
				content: evt.target.getData()
			});
			ui.addBubble(bubble);
		}
	});
}
