<%-- 
    Document   : movies
    Created on : 7 Ιουλ 2019, 8:57:27 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>test api</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">      
    <link rel="stylesheet" type="text/css" href="static/movies.css">
    


</head>

<body>
 <sec:authorize access="isAuthenticated()">
    authenticated as <sec:authentication property="principal.username" /> 
</sec:authorize>
    <input type="number" hidden id="hidden" name="movieId">
    <form id="searchForm" action="">
        <input type="text" id="searchText">
        <button type="submit"></button>
    </form>

    <div class="container">
        <div id="movies" class="row"></div>
    </div>


    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="static/movies.js"></script>
</body>

</html>