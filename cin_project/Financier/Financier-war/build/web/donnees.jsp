
<%@page import="webservice.Info"%>
<%@page import="webservice.Antecedantt"%>
<%@page import="webservice.Personne"%>
<%@page import="financier.Banque"%>
<%@page import="foncier.Foncier"%>
<%@page import="java.util.List"%>
<%
    String cin = (String) request.getAttribute("cin");
    
    List<Banque> banques = (List<Banque>) request.getAttribute("banques");
    List<Foncier> fonciers = (List<Foncier>) request.getAttribute("fonciers");
    List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
    List<Antecedantt> antecedants = (List<Antecedantt>) request.getAttribute("antecedants");
    List<Info> infos = (List<Info>) request.getAttribute("infos");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= cin %></h1>
        <h4>Personne: </h4>
    <ul>
        <% for(int i=0 ; i<personnes.size(); i++) { %>
        <li><%= personnes.get(i).getNom() %> <%= personnes.get(i).getPrenom() %></li>
        <% } %>
    </ul>
        
        <h4>Financier: </h4>
    <ul>
        <% for(int i=0 ; i<banques.size(); i++) { %>
        <li><%= banques.get(i).getSolde() %> - <%= banques.get(i).getBanque() %></li>
        <% } %>
    </ul>
    
        <h4>Foncier: </h4>
    <ul>
        <% for(int i=0 ; i<fonciers.size(); i++) { %>
        <li><%= fonciers.get(i).getTerrain() %> - <%= fonciers.get(i).getSuperficie() %></li>
        <% } %>
    </ul>
    
        <h4>Antecedant: </h4>
    <ul>
        <% for(int i=0 ; i<antecedants.size(); i++) { %>
        <li><%= antecedants.get(i).getAntecedant() %></li>
        <% } %>
    </ul>
    
    <h4>Allergies: </h4>
    <ul>
        <% for(int i=0 ; i<infos.size(); i++) { %>
        <li><%= infos.get(i).getAllergie() %></li>
        <% } %>
    </ul>
        
    </body>
</html>
