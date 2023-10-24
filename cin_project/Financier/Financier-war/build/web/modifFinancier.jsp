<%@page import="webservice.Personne"%>
<%@page import="financier.Banque"%>
<%@page import="java.util.List"%>
<%
    List<Banque> banques = (List<Banque>) request.getAttribute("banques");
    List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
    String cin = (String) request.getAttribute("cin");
    %>
<!DOCTYPE html>
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
        
        <% for(int i=0; i< banques.size(); i++) { %>
            <div class="row">
                <div class="col">
                    <%= banques.get(i).getSolde() %>
                </div>
                <div class="col">
                  <%= banques.get(i).getBanque() %>
                </div>
                <div class="col">
                    <form action="ModifBanqueSevlet">
                        <input type="hidden" name="id_banque" value=<%= banques.get(i).getIdBanque() %> /> 
                        <input type="hidden" name="cin" value=<%= personnes.get(0).getCin() %> /> 
                        <input type="number" name="update" value="0"><button type="submit" class="btn btn-secondary">Changement</button>
                    </form>
                </div>
                <div class="col">
                    <a href="SupprimerBanqueServlet?id_banque=<%= banques.get(i).getIdBanque() %>&&cin=<%= personnes.get(0).getCin() %>" class="btn btn-danger">Supprimer</a>
                </div>
              </div>
                <br/>
        <% } %>
        
            
      </div>
    </div>
    </section>
    </body>
</html>
