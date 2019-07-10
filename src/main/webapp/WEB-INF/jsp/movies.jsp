<%-- 
    Document   : movies
    Created on : 7 Ιουλ 2019, 8:57:27 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <sec:authorize access="isAuthenticated()">
    authenticated as <sec:authentication property="principal.username" /> 
</sec:authorize>
    <a href="logout">Logout</a>
    </body>
</html>
