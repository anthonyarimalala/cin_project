<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header class="header_section long_section px-0">
      <nav class="navbar navbar-expand-lg custom_nav-container ">
        <a class="navbar-brand" href="index.html">
          <span>
            Finance
          </span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class=""> </span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <div class="d-flex mx-auto flex-column flex-lg-row align-items-center">
            <ul class="navbar-nav  ">
              <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
              </li>
              
<!--              <li class="nav-item">
                <a class="nav-link" href="about.jsp"> About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="furniture.jsp">Furnitures</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="blog.jsp">Blog</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="contact.jsp">Contact Us</a>
              </li>-->
            </ul>
          </div>
          <div class="quote_btn-container">
             <form class="form-inline" action="FirstServlet">
               <input type="text" name="search" placeholder=" ID client" >
              <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                <i class="fa fa-search" aria-hidden="true"></i>
              </button>
            </form>
          </div>
        </div>
      </nav>
    </header>
