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
        <title>JSP Page</title>
    </head> 
    <body>
         <table id="favouriteMovies" hidden>
            <c:forEach var = "i" items="${favoriteMovies}">
                <tr> <td>
                        <c:out value="${i.userandmoviePK.movieid}"/>
                    </td> </tr>
            </c:forEach>
                                   
                    </table>
                 <table id="seenMovies" hidden>

            <c:forEach var = "i" items="${seenMovies}">
                <tr> <td>
                        <c:out value="${i.seenmoviesPK.movieid}"/>
                    </td> </tr>
            </c:forEach>
                                   
                    </table>
        
                         <table id="watchlist" hidden>

            <c:forEach var = "i" items="${watchlist}">
                <tr> <td>
                        <c:out value="${i.watchlistPK.movieid}"/>
                    </td> </tr>
            </c:forEach>
                                   
                    </table>
        
        <div class="container">
        <div id="movies" class="row"></div>
        <a href="${pageContext.request.contextPath}/movies" class="pager">Back to movies</a>
    </div>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="static/profile.js"></script>
    </body>
</html>
