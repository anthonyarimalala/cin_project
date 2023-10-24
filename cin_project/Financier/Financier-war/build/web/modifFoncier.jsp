<%@page import="webservice.Personne"%>
<%@page import="foncier.Foncier"%>
<%@page import="java.util.List"%>
<%
    List<Foncier> fonciers = (List<Foncier>) request.getAttribute("fonciers");
    List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
    String cin = (String) request.getAttribute("cin");
    %>

<html>
    <head>
      <!-- Basic -->
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <!-- Site Metas -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <meta name="keywords" content="" />
      <meta name="description" content="" />
      <meta name="author" content="" />

      <title>Edgecut</title>


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
    
    <body class="sub_page">
        <%@include file="header.jsp" %>
    <section class="about_section layout_padding long_section">
            
        
    <div class="container">
            
        
         
         <h3><%= personnes.get(0).getNom() %> <%= personnes.get(0).getPrenom() %></h3>
        <div class="container">
        
        <% for(int i=0; i< fonciers.size(); i++) { %>
            <div class="row">
                <div class="col">
                    <%= fonciers.get(i).getTerrain() %>
                </div>
                <div class="col">
                  <%= fonciers.get(i).getSuperficie() %>
                </div>
                <div class="col">
                    <a href="SupprimerFoncierServlet?id_foncier=<%= fonciers.get(i).getId_foncier()%>&&cin=<%= personnes.get(0).getCin() %>" class="btn btn-danger">Supprimer</a>
                </div>
              </div>
                <br/>
        <% } %>
        
            
      </div>
    </div>
    </section>
    </body>
</html>
