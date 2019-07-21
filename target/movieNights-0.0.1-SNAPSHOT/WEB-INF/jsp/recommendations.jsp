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
        <title>JSP Page</title>
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
        <button id="button">Search!</button>
        <div class="container">
            <div id="movies" class="row"></div>
            <a href="${pageContext.request.contextPath}/movies" class="pager">Back to movies</a>
        </div>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="static/recommendations.js"></script>   
    </body>
</html>
