var api = new H.service.Platform({
  'apikey': '{xzADpXW7FDuY_UZUfXACnvhd1mlSWTHJf1oo4-Q1h50}'
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

var ui = H.ui.UI.createDefault(map, defaultLayers, 'en-US');

var bubble = new H.ui.InfoBubble({lat: 39, lng: -103},{
  content:'<p>Hospital</p>'
});

ui.addBubble(bubble);

map.addEventListener('drag',function(evt){
  alert(evt);
});
