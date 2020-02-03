var platform = new H.service.Platform({
  'apikey': '{xzADpXW7FDuY_UZUfXACnvhd1mlSWTHJf1oo4-Q1h50}'
});

// Obtain the default map types from the platform object:
var defaultLayers = platform.createDefaultLayers();

// Instantiate (and display) a map object:
var map = new H.Map(
    document.getElementById('mapContainer'),
    defaultLayers.vector.normal.map,
    {
      zoom: 3.6,
      center: { lat: 39, lng: -104 }
    });
