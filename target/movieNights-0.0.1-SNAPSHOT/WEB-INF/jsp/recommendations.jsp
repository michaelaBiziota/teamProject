<%-- 
    Document   : recommendations
    Created on : Jul 20, 2019, 8:04:14 PM
    Author     : creoo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recommendations</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="static/movies.css">
    </head>
    <body>
        <table id="favouriteMovies" hidden>
            <c:forEach var = "i" items="${favoriteMovies}">
                <tr> <td>
                        <input type="number" value="<c:out value="${i.userandmoviePK.movieid}"/>">
                    </td> </tr>
                </c:forEach>
        </table>
        <table id="seenMovies" hidden>

            <c:forEach var = "i" items="${seenMovies}">
                <tr> <td>
                        <input type="number" value="<c:out value="${i.seenmoviesPK.movieid}"/>">
                    </td> </tr>
                </c:forEach>
        </table>

        <div class="container">
            <div class="row">
                <!-- MovieNights Logo -->
                <div class="col-md-4 col-xs-12 mt-3">
                    <a href="${pageContext.request.contextPath}/movies">
                        <img src="static/pictures/mn.png" class="mx-5 img-fluid" id="movienights" title="Home">
                    </a>
                </div>
                <!-- End -->
                <div class="col-md-4 text-center mt-3"><h2>Recommendations</h2></div>
            </div>

            <div class="par">
                <p>Many apps offer recommendations but usually fail to provide good ones.<br>
                    We decided to focus on great browsing experience that makes it easy to quickly find a movie you'll enjoy watching.</p>
            </div>
        </div>
        <div class="container">
            <div class="container my-4">
                <div id="movies" class="row"></div>
                <div class="text-center">
                    <button class="btn" id="button"> <img src="static/pictures/recommendation.png" class="mx-5 img-fluid" id="recimg" title="Press for Recommendations"></button>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
            <script src="static/recommendations.js"></script>   
    </body>
</html>
