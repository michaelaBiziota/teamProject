<%-- 
    Document   : form
    Created on : 20 Ιουν 2019, 6:36:48 μμ
    Author     : bizmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form modelAttribute="movie" method="POST" action="${pageContext.request.contextPath}/movies/doinsert">
            <form:input  path="shName"/>
            <form:errors  path="shName" cssClass="error"/>
            <input type="submit">    
        </form:form>
    </body>
</html>
