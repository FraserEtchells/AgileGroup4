var api = new H.service.Platform({
  apikey: '10UmFtAGly-G0AEFjDot_PuKKz4nsfHnOryzfp-EYzg'
});

// Obtain the default map types from the platform object:
var defaultLayers = api.createDefaultLayers();

// Instantiate (and display) a map object:
var map = new H.Map(
    document.getElementById('mapContainer'),
    defaultLayers.vector.normal.map,
    {
      zoom: 3.6,
      center: { lat: 39, lng: -104 }
    }
);

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
*/

var calculatedRoutes = new Array();

var routingParameters = {
  'mode':'shortest;car;traffic:disabled',
  'waypoint0': 'geo!50.1120423728813,8.68340740740811',
  // The end point of the route:
  'waypoint1': 'geo!52.5309916298853,13.3846220493377',
  // To retrieve the shape of the route we choose the route
  // representation mode 'display'
  'representation': 'display',
  'requestId':'0',
  'metricSystem':'imperial'
};

var queryRouteInfo = {
  'requestId':'0',
};

  // Define a callback function to process the routing response:
  var onDist = function(result) {
    var route,
      routeShape,
      startPoint,
      endPoint,
      linestring;
    if(result.response.route)
    {
      // Pick the first route from the response:
      route = result.response.route[0];
      // Pick the route's shape:
      routeShape = route.shape;

      // Create a linestring to use as a point source for the route line
      linestring = new H.geo.LineString();

      // Push all the points in the shape into the linestring:
      routeShape.forEach(function(point)
      {
        var parts = point.split(',');
        linestring.pushLatLngAlt(parts[0], parts[1]);
      });

      // Retrieve the mapped positions of the requested waypoints:
      startPoint = route.waypoint[0].mappedPosition;
      endPoint = route.waypoint[1].mappedPosition;

      // Create a polyline to display the route:
      var routeLine = new H.map.Polyline(linestring, {
        style: { strokeColor: 'blue', lineWidth: 3 }
      });

      // Create a marker for the start point:
      var startMarker = new H.map.Marker({
        lat: startPoint.latitude,
        lng: startPoint.longitude
      });

      // Create a marker for the end point:
      var endMarker = new H.map.Marker({
        lat: endPoint.latitude,
        lng: endPoint.longitude
      });

    // Add the route polyline and the two markers to the map:
    map.addObjects([routeLine, startMarker, endMarker]);

    // Set the map's viewport to make the whole route visible:
    map.getViewModel().setLookAtData({bounds: routeLine.getBoundingBox()});
  }
  console.log(result);
};

var router = api.getRoutingService();

router.calculateRoute(routingParameters, onDist,
  function(error) {
    alert(error.message);
  });

/*var routeConfig = {
  ../routing/7.2/getroute.{format}?routeId=<ROUTEID>&<parameter>=<value>...
};*/

//var routeData = api.getCustomRoutingService(routeConfig);

// Create the parameters for the geocoding request:
var geocodingParams = {
      searchText: 'New York'
    };


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
var geocoder = api.getGeocodingService();

// Call the geocode method with the geocoding parameters,
// the callback and an error callback function (called if a
// communication error occurs):
var temp = geocoder.geocode(geocodingParams, onResult, function(e) {
  alert(e);
});
