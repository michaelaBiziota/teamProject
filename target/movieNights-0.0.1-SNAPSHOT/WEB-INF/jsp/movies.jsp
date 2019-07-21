<%-- 
    Document   : movies
    Created on : 7 Ιουλ 2019, 8:57:27 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MovieNights</title>
    <script src="https://code.jquery.com/jquery-3.4.0.min.js"
        integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


    <link rel="stylesheet" type="text/css" href="static/header.css">
    <link rel="stylesheet" type="text/css" href="static/navbar.css">
    <link rel="stylesheet" type="text/css" href="static/movies.css">
    


</head>

<body>

    <input type="number" hidden id="hidden" name="movieId">
    <header>
        
    
        <div class="row">
            <!-- MovieNights Logo -->
            <div class="col-md-4 col-xs-12 mt-3">
                <img src="static/mn.png" class="mx-5 img-fluid" id="movienights">
            </div>
            <!-- End -->
            <div class="col-md-4 col-xs-12 mt-4">
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="${pageContext.request.contextPath}/allusers" id="adminmenu">Admin ⚙️</a>
              </sec:authorize>   
            </div>

            <!-- USER PROFILE DROP DOWN -->
            <div class="col-md-4 col-sm-xs mt-4">
                <ul class="nav navbar-nav">
                    <li class="dropdown1">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                            <sec:authorize access="isAuthenticated()">
                                <sec:authentication property="principal.username" /> 
                              </sec:authorize><span
                                class="glyphicon glyphicon-user pull-right"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Account Settings <span
                                        class="glyphicon glyphicon-cog pull-right"></span></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="watchList">Watchlist<span class="glyphicon  glyphicon-eye-open pull-right"></span></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="alreadyWatchedMovies">Already Watched<span class="glyphicon glyphicon-eye-close pull-right"></span></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="favoriteMovies">Favourite Movies <span class="glyphicon glyphicon-heart pull-right"></span></a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/logout">Sign Out <span class="glyphicon glyphicon-log-out pull-right"></span></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- End -->
        </div>
    </header>

    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark ">

        <!-- Navbar brand -->

<!--        <a href="#HOME" data-toggle="tooltip" data-placement="bottom" title="Home"><img class="logo" alt="Brand"
                src="static/cam.png"></a>-->
        <a class="navbar-brand " href="Homepage.jsp">Recommended Movies</a>
        <!-- Collapse button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
            aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Collapsible content -->
        <div class="collapse navbar-collapse" id="basicExampleNav">

            <!-- Links -->
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" id="popular">
                    <a class="nav-link" href="#">Most Popular
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="nav-item" id="toprated">
                    <a class="nav-link" href="#">Top Rated</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Whatever</a>
                </li>

                <li class="nav-item dropdown" id="dropdownli">
                    <a class=" nav-link dropdown-toggle " id="navbarDropdownMenuLink" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        Genre
                    </a>
                    <div class="dropdown-menu dropdown-services" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item hvr-sweep-to-top genres" id="action"> Action</a>
                        <a class="dropdown-item hvr-sweep-to-top genres" id="animation"> Animation</a>
                        <a class="dropdown-item hvr-sweep-to-top genres" id="comedy"> Comedy</a>
                        <a class="dropdown-item hvr-sweep-to-top genres" id="drama"> Drama</a>
                        <a class="dropdown-item hvr-sweep-to-top genres" id="romance"> Romance</a>
                        
                        <a class="dropdown-item hvr-sweep-to-top genres" id="mystery"> Mystery</a>
                        
                        <a class="dropdown-item hvr-sweep-to-top genres" id="science" > Science Fiction</a>
                        <a class="dropdown-item hvr-sweep-to- genres" id="thriller"> Thriller</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="New Movies.jsp">New Movies</a>
                </li>
                <li class="nav-item vertical-line">
                    <a class="nav-link" href="Contact Us.jsp">Contact Us</a>
                </li>

                <!-- Slider -->
                <li class="nav-item vertical-line ">
                    <div class="nav-link">
                        <div class="slidecontainer">
                            <p class="text-center mt-2">Released in: <span id="year"></span></p>
                            <input type="range" min="1942" max="2019" value="50%" class="slider" id="myRange">
                        </div>
                    </div>
                </li>
                <!-- Slider END -->
            </ul>
            <!-- Links -->
        </div>
        <!-- Collapsible content -->


        <!-- Search -->
        <form class="search" id="searchForm">
            <div class="md-form my-auto">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search"
                    id="searchText">
            </div>
        </form>
        <!-- Search END -->

    </nav>
    <!--/.Navbar-->


    <!-- Movies -->
    <div class="container">
        <div id="movies" class="row"></div>
    </div>
    <!-- Movies End-->

    <script src="static/slider.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="static/movies.js"></script>
</body>

</html>