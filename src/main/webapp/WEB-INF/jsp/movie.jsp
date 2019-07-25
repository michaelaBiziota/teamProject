<%-- 
    Document   : movie
    Created on : 13 Ιουλ 2019, 5:43:00 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <title>Movie info</title>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/movie.css">
    </head>

    <body>

        <div  hidden id="hidden">${mId}</div>
        <div id="warnseen">${seen}</div>
        <div id="like">${like}</div>
        <div id="watchlist">${watchlist}</div>

        <div class="container">
            <div id="movie" class="well"></div>
        </div>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/movie.js"></script>
    </body>

</html>
