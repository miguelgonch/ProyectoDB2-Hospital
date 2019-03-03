<%-- 
    Document   : _header
    Created on : Mar 2, 2019, 9:03:06 PM
    Author     : migue
--%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%= request.getParameter("title") %></title>
    <link rel="stylesheet" href="css/foundation.css">
    <link rel="stylesheet" href="css/app.css">
    <script src="js/vendor/jquery.js"></script>
</head>
<header>
    <!-- Navigation Bar -->
    <div class="top-bar" id="Navigation_Bar">
        <div class="top-bar-left">
            <ul class="menu">
                <figure>
                    <a href="index.html"><img src="Imagenes/logo.jpg" class="logo" id="Navigation_Bar_Logo" /></a>
                </figure>
            </ul>
        </div>
        <div class="top-bar-right">
            <ul class="dropdown menu" data-dropdown-menu>
                <ul class="dropdown menu" data-accordion-menu>
                    <li><a href="#">Inicio</a></li>
                </ul>
            </ul>
        </div>
    </div>
</header>
