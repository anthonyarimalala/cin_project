<%@page import="webservice.Unite"%>
<%@page import="webservice.Personne"%>
<%@page import="financier.Banque"%>
<%@page import="java.util.List"%>
<%
    List<Banque> banques = (List<Banque>) request.getAttribute("banques");
    List<Banque> banquesTransa = (List<Banque>) request.getAttribute("banquesTransa");
    List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
    List<Unite> unites = (List<Unite>) request.getAttribute("unites");
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
        <form action="TransactionServlet">
            <div class="row">
                <div class="col">
                    <input type="hidden" name="solde" value=<%= banques.get(i).getSolde() %> /> 
                    <%= banques.get(i).getSolde() %>
                </div>
                <div class="col">
                  <%= banques.get(i).getBanque() %>
                </div>
                <div class="col">
                    
                        <input type="hidden" name="id_banque" value=<%= banques.get(i).getIdBanque() %> /> 
                        <input type="hidden" name="cin" value=<%= personnes.get(0).getCin() %> /> 
                        <input type="text" name="montant">
                        <select name="symbole">
                            <% for(int j=0; j< unites.size(); j++) { %>
                            <option value="<%= unites.get(j).getSymbole() %>" ><%= unites.get(j).getSymbole() %></option>
                            <% } %>
                        </select>
                    
                </div>
                <div class="col">
                    <select name="id_banque_receive">
                        <% for(int j=0; j< banquesTransa.size(); j++) { %>
                        <option value="<%= banquesTransa.get(j).getIdBanque() %>"><%= banquesTransa.get(j).getCin() %>-<%= banquesTransa.get(j).getBanque() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="col">
                    <button type="submit" class="btn btn-secondary">Transferer</button>
                </div>
              </div>
                <br/>
            </form>
        <% } %>
        
        
            
      </div>
    </div>
    </section>
    </body>
</html>
