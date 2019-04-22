<%-- 
    Document   : _header
    Created on : Mar 2, 2019, 9:03:06 PM
    Author     : migue
--%>
<%@ include file="_verify.jsp"%>
<header>
    <!-- Navigation Bar -->
    <div class="top-bar" id="Navigation_Bar">
        <div class="top-bar-left">
            <ul class="menu">
                <figure>
                    <a href="index.jsp"><img src="https://foundation.zurb.com/sites/docs/assets/img/logos/foundation-sites-nuget-icon-128x128.jpg" class="logo" id="Navigation_Bar_Logo" /></a>
                </figure>
            </ul>
        </div>
        <div class="top-bar-right">
            <ul class="dropdown menu" data-dropdown-menu>
                <ul class="dropdown menu" data-accordion-menu>
                    <li><a href="home_h.jsp">Inicio</a></li>
                    <li><a><%= user %></a>
                    <li><a href="Logout">Cerrar Sesion</a></li>
                </ul>
            </ul>
        </div>
    </div>
         <!--<div class="top-bar">
          <div class="top-bar-right">
            <ul class="dropdown menu" data-dropdown-menu>
              <li class="menu-text">Site Title</li>
              <li>
                <a href="#">One</a>
                <ul class="menu vertical">
                  <li><a href="#">One</a></li>
                  <li><a href="#">Two</a></li>
                  <li><a href="#">Three</a></li>
                </ul>
              </li>
              <li><a href="#">Two</a></li>
              <li><a href="#">Three</a></li>
            </ul>
          </div>
          <div class="top-bar-right">
            <ul class="menu">
              <li><input type="search" placeholder="Search"></li>
              <li><button type="button" class="button">Search</button></li>
            </ul>
          </div>
        </div> -->
</header>






