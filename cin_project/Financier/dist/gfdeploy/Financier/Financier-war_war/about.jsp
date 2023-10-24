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

  <div class="hero_area">
    <!-- header section strats -->
    <%@include file="header.jsp" %>
    <!-- end header section -->
  </div>

  <!-- about section -->

  <section class="about_section layout_padding long_section">
    <div class="container">
        <div class="col-md-12">
          <div class="img-box">
              <h1><%= cin %>
                  <% for(int i=0 ; i<personnes.size(); i++) { %>
                    <%= personnes.get(i).getNom() %> <%= personnes.get(i).getPrenom() %>
                  <% } %>
              </h1>
          </div>
        </div>
                  <% if(cin!="No CIN found!") { %>
          <div class="row">
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Financier:</h5>
                  <p class="card-text">
                    <ul>
                      <% for(int i=0 ; i<banques.size(); i++) { %>
                      <li><%= banques.get(i).getSolde() %> - <%= banques.get(i).getBanque() %></li>
                      <% } %>
                    </ul>
                  </p>
                  <% if(cin!="No CIN found!") { %>
                  <a href="AboutToTransactionServlet?cin=<%= personnes.get(0).getCin() %>" class="btn btn-secondary">Transaction</a>
                  <% } %>
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Foncier:</h5>
                  <p class="card-text">
                      <ul>
                        <% for(int i=0 ; i<fonciers.size(); i++) { %>
                        <li><%= fonciers.get(i).getTerrain() %>:  <%= fonciers.get(i).getSuperficie() %></li>
                        <% } %>
                    </ul>
                  </p>
                  <% if(cin!="No CIN found!") { %>
                  <a href="AboutToCarteServlet?cin=<%= personnes.get(0).getCin() %>" class="btn btn-secondary">Nouveau Foncier</a>
                  <% } %>
                </div>
              </div>
            </div>
          </div>
          <br>
          <div class="row">
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Antecedants:</h5>
                  <p class="card-text">
                      <ul>
                        <% for(int i=0 ; i<antecedants.size(); i++) { %>
                        <li><%= antecedants.get(i).getAntecedant() %></li>
                        <% } %>
                    </ul>
                  </p>
                  
                </div>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Allergies:</h5>
                  <p class="card-text">
                      <% for(int i=0 ; i<infos.size(); i++) { %>
                        <li><%= infos.get(i).getAllergie() %></li>
                        <% } %>
                  </p>
                  
                </div>
              </div>
            </div>
          </div>  
                  <% } %>
      </div>
  </section>

  <!-- end about section -->


  <!-- info section -->
  <section class="info_section long_section">

    <div class="container">
      <div class="contact_nav">
        <a href="">
          <i class="fa fa-phone" aria-hidden="true"></i>
          <span>
            Call : +01 123455678990
          </span>
        </a>
        <a href="">
          <i class="fa fa-envelope" aria-hidden="true"></i>
          <span>
            Email : demo@gmail.com
          </span>
        </a>
        <a href="">
          <i class="fa fa-map-marker" aria-hidden="true"></i>
          <span>
            Location
          </span>
        </a>
      </div>

      <div class="info_top ">
        <div class="row ">
          <div class="col-sm-6 col-md-4 col-lg-3">
            <div class="info_links">
              <h4>
                QUICK LINKS
              </h4>
              <div class="info_links_menu">
                <a class="" href="index.html">Home <span class="sr-only">(current)</span></a>
                <a class="" href="about.html"> About</a>
                <a class="" href="furniture.html">Furniture</a>
                <a class="" href="blog.html">Blog</a>
                <a class="" href="contact.html">Contact Us</a>
              </div>
            </div>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3 mx-auto">
            <div class="info_post">
              <h5>
                INSTAGRAM FEEDS
              </h5>
              <div class="post_box">
                <div class="img-box">
                  <img src="images/f1.png" alt="">
                </div>
                <div class="img-box">
                  <img src="images/f2.png" alt="">
                </div>
                <div class="img-box">
                  <img src="images/f3.png" alt="">
                </div>
                <div class="img-box">
                  <img src="images/f4.png" alt="">
                </div>
                <div class="img-box">
                  <img src="images/f5.png" alt="">
                </div>
                <div class="img-box">
                  <img src="images/f6.png" alt="">
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="info_form">
              <h4>
                SIGN UP TO OUR NEWSLETTER
              </h4>
              <form action="">
                <input type="text" placeholder="Enter Your Email" />
                <button type="submit">
                  Subscribe
                </button>
              </form>
              <div class="social_box">
                <a href="">
                  <i class="fa fa-facebook" aria-hidden="true"></i>
                </a>
                <a href="">
                  <i class="fa fa-twitter" aria-hidden="true"></i>
                </a>
                <a href="">
                  <i class="fa fa-linkedin" aria-hidden="true"></i>
                </a>
                <a href="">
                  <i class="fa fa-instagram" aria-hidden="true"></i>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- end info_section -->


  <!-- footer section -->
  <footer class="footer_section">
    <div class="container">
      <p>
        &copy; <span id="displayYear"></span> All Rights Reserved By
        <a href="https://html.design/">Free Html Templates</a>
      </p>
    </div>
  </footer>
  <!-- footer section -->


  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap"></script>
  <!-- End Google Map -->

</body>

</html>