<%-- 
    Document   : profile
    Created on : 19 Ιουλ 2019, 12:37:18 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>🎬 My movies</title>
        <script src="https://code.jquery.com/jquery-3.4.0.min.js"
        integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="static/movies.css">
        <link rel="stylesheet" type="text/css" href="static/navbar.css">
    </head> 
    <body>
        <div class="container">
            <div class="row">
                <!-- MovieNights Logo -->
                <div class="col-md-4 col-xs-12 mt-3">
                    <a href="${pageContext.request.contextPath}/movies">
                        <img src="static/pictures/mn.png" class="mx-5 img-fluid" id="movienightsprof" title="Home">
                    </a>
                </div>
                <!-- End -->
                <div class="col-md-4 text-center profpage mt-3"><h2>My profile</h2></div>
            </div>

            <!--Navbar-->
            <div class="row">
                <div class="d-flex justify-content-center mx-auto">
                    <nav class="navbar navbar-expand-lg navbar-dark ">

                        <!-- Navbar brand -->

                        <!-- Collapsible content -->
                        <div class="collapse navbar-collapse " id="basicExampleNav">

                            <!-- Links -->
                            <ul class="navbar-nav profnavbar-nav">
                                <li class="nav-item" id="popular">
                                    <a class="nav-link" href="accountSettings">Account Settings
                                        <span class="sr-only">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item" id="favourite">
                                    <a class="nav-link" href="#" id="fav">Favourite Movies</a>
                                </li>
                                <li class="nav-item" id="alreadywatched">
                                    <a class="nav-link" href="#" id="seen">Already Watched</a>
                                </li>
                                <li class="nav-item " id="watchlists">
                                    <a class="nav-link" href="#" id="watch">Watch Later</a>
                                </li>
                                <li class="nav-item vertical-line">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sign out</a>
                                </li>
                            </ul>
                            <!-- Links -->
                        </div>
                        <!-- Collapsible content -->

                    </nav>
                    <!--/.Navbar-->
                </div>

            </div>
        </div>

        <table id="favouriteMovies" hidden>
            <c:forEach var = "i" items="${favoriteMovies}">
                <tr>
                    <td>
                        <c:out value="${i.userandmoviePK.movieid}"/>
                    </td> 
                </tr>
            </c:forEach>
        </table>

        <table id="seenMovies" hidden>
            <c:forEach var = "i" items="${seenMovies}">
                <tr> 
                    <td>
                        <c:out value="${i.seenmoviesPK.movieid}"/>
                    </td> 
                </tr>
            </c:forEach>
        </table>

        <table id="watchlist" hidden>
            <c:forEach var = "i" items="${watchlist}">
                <tr> 
                    <td>
                        <c:out value="${i.watchlistPK.movieid}"/>
                    </td> 
                </tr>
            </c:forEach>
        </table>

        <div class="container">
            <div id="pagetitle" class="my-5 text-center "></div>
            <div id="movies" class="row"></div>

          
        </div>

        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="static/profile.js"></script>
    </body>
</html>
