<%-- 
    Document   : carte
    Created on : Oct 21, 2023, 9:26:12 PM
    Author     : antho
--%>
<%@page import="java.util.List"%>
<%@page import="webservice.Personne"%>
<%
    List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" integrity="sha256-p4NxAoJBhIIN+hmNHrzRCf9tD/miZyoHS5obTRR9BMY=" crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>

        <link rel="stylesheet" href="https://unpkg.com/leaflet-control-geocoder@1.13.0/dist/Control.Geocoder.css" />
        <script src="https://unpkg.com/leaflet-control-geocoder@1.13.0/dist/Control.Geocoder.js"></script>
        
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />

        <!-- font awesome style -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
    </head>
    
    
    <body>

        
        <h1>Ajout de terrain.</h1>
        <h2><%= personnes.get(0).getCin() %>: <%= personnes.get(0).getNom() %> <%= personnes.get(0).getPrenom() %></h2>
        <form action="InsertFoncierServlet" id="myForm" method="post">
            <input type="hidden" name="cin" value="<%= personnes.get(0).getCin() %>" />
        <div class="col-md-6">
            <label for="inputEmail4" class="form-label">Address: </label>
            <input type="text" id="terrain" name="terrain" class="form-control" placeholder="Addresse">
        </div>
            
        <div>
            <button id="reinitialiser" class="btn btn-warning" type="button">Retour</button>
        </div>
        <br>
            
        <div id="map" style="height: 400px;" border="1px"></div>
        <style>
            #map { height: 180px; }
        </style>
        
        <script>
        var map = L.map('map').setView([-18.8792, 47.5079], 13);
        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        }).addTo(map);
        
        L.Control.geocoder().addTo(map);
    

    

        // Créez un tableau pour stocker les marqueurs
        var markers = [];
        var latlon = [];
        var polygon;

        var popup = L.popup();

        function onMapClick(e) {
            var marker = L.marker(e.latlng).addTo(map);
            markers.push(marker);
            latlon.push([e.latlng.lat, e.latlng.lng]);

            if (markers.length > 1) {
                if (polygon) {
                    map.removeLayer(polygon);
                }
                polygon = L.polygon(markers.map(function (m) {
                    return m.getLatLng();
                })).addTo(map);
            }
            
            // Ajoutez la latitude et la longitude à la liste
            var coordinatesList = document.getElementById("coordinatesList");
            var listItem = document.createElement("li");
            listItem.textContent = "Latitude: " + e.latlng.lat + ", Longitude: " + e.latlng.lng;
            coordinatesList.appendChild(listItem);
            var latlonJSON = JSON.stringify(latlon);
            document.getElementById("latlonJSON").value = latlonJSON;
            
        }

        map.on('click', onMapClick);

        var boutonReinitialiser = document.getElementById("reinitialiser");

        boutonReinitialiser.addEventListener("click", function () {
            if (markers.length > 0) {
                var dernierMarqueur = markers.pop();
                latlon.length = latlon.length - 1;
                map.removeLayer(dernierMarqueur);

                if (markers.length > 1 && polygon) {
                    map.removeLayer(polygon);
                    polygon = L.polygon(markers.map(function (m) {
                        return m.getLatLng();
                    })).addTo(map);
                } else if (polygon) {
                    map.removeLayer(polygon);
                    polygon = null;
                }
            }
            // Effacez la liste des coordonnées
            var coordinatesList = document.getElementById("coordinatesList");
            // Vérifiez s'il y a des éléments enfants à supprimer
            if (coordinatesList.hasChildNodes()) {
                // Supprimez le dernier enfant
                coordinatesList.removeChild(coordinatesList.lastChild);
            }
            var latlonJSON = JSON.stringify(latlon);
            document.getElementById("latlonJSON").value = latlonJSON;
        });
        
        
        
        
    </script>
    
    <ul id="coordinatesList"></ul>
    
        <input type="hidden" name="latlonJSON" id="latlonJSON">
        <div class="row g-3">
            <div class="col">
                <input type="number" step="0.000000000000001" id="lat" class="form-control" name="lat" placeholder="latitude">
            </div>
            <div class="col">
                <input type="number" step="0.000000000000001" id="lon" class="form-control" name="lon" placeholder="longitude">
            </div>
            <div class="col">
                <button id="add-input" type="button" class="btn btn-primary">Ajouter</button>
            </div>
        </div>
    
    <br>
    
    

<script>
    var inputCounter = 0; // Initial input number

    document.getElementById('add-input').addEventListener('click', function() {
            var latValue = document.getElementById("lat").value;
            var lonValue = document.getElementById("lon").value;
            var marker = L.marker([latValue, lonValue]).addTo(map);
            markers.push(marker);
            latlon.push([latValue, lonValue]);

            if (markers.length > 1) {
                if (polygon) {
                    map.removeLayer(polygon);
                }
                polygon = L.polygon(markers.map(function (m) {
                    return m.getLatLng();
                })).addTo(map);
            }
            
            // Ajoutez la latitude et la longitude à la liste
            var coordinatesList = document.getElementById("coordinatesList");
            var listItem = document.createElement("li");
            listItem.textContent = "Latitude: " + latValue + ", Longitude: " + lonValue;
            coordinatesList.appendChild(listItem);
            var latlonJSON = JSON.stringify(latlon);
            document.getElementById("latlonJSON").value = latlonJSON;

    });
</script>
    
    
    <div id="error-message">
    </div>
    
    <input type="submit" class="btn btn-success non-input-button" value="Envoyer au Servlet">
    </form>
        <script>
            var form = document.getElementById("myForm");
            var errorMessage = document.getElementById("error-message");
            var terrain = document.getElementById("terrain");
            
            form.addEventListener("submit", function (e) {
                // Empêchez le formulaire de se soumettre par défaut
                e.preventDefault();

                // Vérifiez la longueur de latlon
                if (latlon.length < 3) {
                    // Affichez le message d'erreur
                    errorMessage.textContent = "La longueur minimum doit être 3.";
                } else if(terrain.value.trim() === "") {
                    errorMessage.textContent = "Le nom du terrain n'est pas specifié.";
                }
            });
        </script>
    </body>
</html>
