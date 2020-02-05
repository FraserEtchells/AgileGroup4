var platform = new H.service.Platform({
  apikey: '10UmFtAGly-G0AEFjDot_PuKKz4nsfHnOryzfp-EYzg'
});

// Obtain the default map types from the platform object:
var defaultLayers = platform.createDefaultLayers();

// Instantiate (and display) a map object:
var map = new H.Map(document.getElementById('mapContainer'), defaultLayers.vector.normal.map, {center: { lat: 39, lng: -104 }, zoom: 3.6 });

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

var mapEvents = new H.mapevents.MapEvents(map);
new H.mapevents.Behavior(mapEvents);

var ui = H.ui.UI.createDefault(map, defaultLayers, 'en-US');
/*
var bubble = new H.ui.InfoBubble({lat: 39, lng: -103},{
  content:'<p>Hospital</p>'
});

ui.addBubble(bubble);

map.addEventListener('drag',function(evt){
  alert(evt);
});
*/


// Define a callback function to process the geocoding response:
var onResult = function(result) {
  var locations = result.Response.View[0].Result,
      position,
      marker;
  // Add a marker for each location found
  for (i = 0;  i < locations.length; i++) {
    position = {
      lat: locations[i].Location.DisplayPosition.Latitude,
      lng: locations[i].Location.DisplayPosition.Longitude
    };
    marker = new H.map.Marker(position, {icon: icon});
    map.addObject(marker);
  }
};

// Get an instance of the geocoding service:
var geocoder = platform.getGeocodingService();

// Call the geocode method with the geocoding parameters,
// the callback and an error callback function (called if a
// communication error occurs):
function addLocationToMap(address) {
  geocodingParams = {searchText: address, country: "USA"};
  geocoder.geocode(geocodingParams, onResult, function(e) {
  alert(e);
});
}
